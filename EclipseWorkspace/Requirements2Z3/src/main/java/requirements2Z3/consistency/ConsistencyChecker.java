package requirements2Z3.consistency;

import java.io.Writer;
import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import requirements2Z3.Checker;
import requirements2Z3.RTFunctionality;

public class ConsistencyChecker implements RTFunctionality {

	

	public void processRequirements(Scanner sc, Writer wt, Checker ck) throws Exception {
		System.out.println("Processing the requirements");
		// checks that the first line of the file contains the string ----Input Data --
		// if not throws an error
		String nextLine = sc.nextLine();
		if (!(nextLine.equals("------- Requirements -----"))) {
			sc.close();
			wt.close();
			throw new Exception("The file does not start with the string \"------- Input Data -----\" ");
		}
		// this set will contain all the preconditions of the Requirements Table
		Set<Entry<String, String>> requirements = new HashSet<>();

		nextLine = sc.nextLine();
		while (sc.hasNextLine() && !nextLine.equals("------- End of Requirements -----")) {

			String[] fields = nextLine.split(",");
			requirements.add(new AbstractMap.SimpleEntry<String, String>(fields[0] + "\r", fields[1] + "\r"));
			nextLine = sc.nextLine();
		}

		// Monotonicity constraint for the timestamp array

		wt.write("s = Solver()\n");

		String tm = ck.getMonotonicityConstraint();

		String encodingRequirements = getEncodingRequirements(requirements,ck);

		String outputVariables = "";

		boolean firstVariable = true;
		for (String outputVariable : ck.getOutputVariables()) {
			if (firstVariable == true) {
				outputVariables = outputVariable;
				firstVariable = false;
			}
			outputVariables = outputVariables + "," + outputVariable;
		}

		String finalConvertedString = "And(" + tm + "," + "Forall([" + outputVariables + "] , " + "Exists(i," + "And("
				+ tm + "," + encodingRequirements + "))))";

		wt.write("s.add(" + finalConvertedString + ")\n");

	}

	protected String getEncodingRequirements(Set<Entry<String, String>> requirements,Checker ck) {
		boolean firstRequirement = true;

		String encodingRequirements = "And(";

		for (Entry<String, String> requirement : requirements) {

			String precondition = requirement.getKey();
			String postcondition = requirement.getValue();

			if (firstRequirement) {
				encodingRequirements = encodingRequirements + "Not(Implies(" + ck.conversion(precondition) + ","
						+ ck.conversion(postcondition) + ")";

				firstRequirement = false;
			} else {
				encodingRequirements = encodingRequirements + ",Not(Implies(" + ck.conversion(precondition) + ","
						+ ck.conversion(postcondition) + ")";
			}
		}
		return encodingRequirements;
	}

}
