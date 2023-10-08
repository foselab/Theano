package requirements2Z3.consistency;

import java.io.Writer;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

import requirements2Z3.Checker;
import requirements2Z3.RTBoundedFunctionality;

public class BoundedConsistencyChecker extends ConsistencyChecker implements RTBoundedFunctionality {

	private final float ts;

	private final int bound;

	protected int currentIndexI;

	public BoundedConsistencyChecker(float ts, int bound, int currentIndexI) throws Exception {
		this.ts = ts;
		this.bound = bound;
		this.currentIndexI = currentIndexI;

	}

	public float getTs() {
		return ts;
	}

	public int getBound() {
		return bound;
	}

	public int getCurrentIndexI() {
		return currentIndexI;
	}

	public void processRequirements(Scanner sc, Writer wt, Checker ck) throws Exception {
		//System.out.println("Processing the requirements");
		// checks that the first line of the file contains the string ----Input Data --
		// if not throws an error
		String nextLine = sc.nextLine();
		if (!(nextLine.equals("------- Requirements -----"))) {
			sc.close();
			wt.close();
			throw new Exception("The file does not start with the string \"------- Input Data -----\" ");
		}
		// this set will contain all the preconditions of the Requirements Table
		List<Entry<String, String>> requirements = new ArrayList<>();

		nextLine = sc.nextLine();
		while (sc.hasNextLine() && !nextLine.equals("------- End of Requirements -----")) {

			String[] fields = nextLine.split(",");
			requirements.add(new AbstractMap.SimpleEntry<String, String>(fields[0] + "\r", fields[1] + "\r"));
			nextLine = sc.nextLine();
		}

		// Monotonicity constraint for the timestamp array

		wt.write("s = Solver()\n");

		String tm = ck.getMonotonicityConstraint();

		String encodingRequirements = "And(";

		boolean firstVariable = true;
		for (String outputVariable : ck.getOutputVariables()) {
			if (firstVariable == true) {
				encodingRequirements = encodingRequirements
						+ getEncodingOutputVariable(requirements, outputVariable, ck);
			} else {
				encodingRequirements = encodingRequirements + ","
						+ getEncodingOutputVariable(requirements, outputVariable, ck);
			}
		}
		encodingRequirements = encodingRequirements + ")";

		String outputVariables = "";

		firstVariable = true;
		for (String outputVariable : ck.getOutputVariables()) {
			if (firstVariable == true) {
				outputVariables = outputVariable;
				firstVariable = false;
			}
			else {
				outputVariables = outputVariables + "," + outputVariable;
			}
		}

		String finalConvertedString = "And(" + tm + "," + "ForAll([" + outputVariables + "] , " + encodingRequirements
				+ "))";

		wt.write("s.add(" + finalConvertedString + ")\n");

	}

	protected String getEncodingOutputVariable(List<Entry<String, String>> requirements, String encodingOutpuVariables,
			Checker ck) {
		boolean firstRequirement = true;
		String encodingRequirements = "Or(";

		for (currentIndexI = 0; currentIndexI < bound; currentIndexI++) {

			for (Entry<String, String> requirement : requirements) {

				String precondition = requirement.getKey();
				String postcondition = requirement.getValue();

				String preconditionString = ck.conversion(precondition);
				String postconditionString = ck.conversion(postcondition);

				if (firstRequirement) {

					if (preconditionString.equals("True")) {
						encodingRequirements = encodingRequirements + "Not(" + postconditionString + ")";
					} else {
						if (!preconditionString.equals("False")) {
							encodingRequirements = encodingRequirements + "Not(Implies(" + preconditionString + ","
									+ postconditionString + "))";
						}

					}

					firstRequirement = false;
				} else {
					if (preconditionString.equals("True")) {
						encodingRequirements = encodingRequirements + ",Not(" + postconditionString + ")";
					} else {
						if (!preconditionString.equals("False")) {
							encodingRequirements = encodingRequirements + ",Not(Implies(" + preconditionString + ","
									+ postconditionString + "))";
						}

					}
				}
			}

			// if (currentIndexI < bound) {
			// encodingRequirements = encodingRequirements + ",";
			// }

		}

		return encodingRequirements + ")";
	}

}
