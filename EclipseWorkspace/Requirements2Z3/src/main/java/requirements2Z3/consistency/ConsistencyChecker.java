package requirements2Z3.consistency;

import java.io.Writer;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

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

		String finalConvertedString = "And(" + tm + "," + "ForAll([" + outputVariables + "] , "  + encodingRequirements + "))";

		wt.write("s.add(" + finalConvertedString + ")\n");

	}

	protected String getEncodingRequirements(List<Entry<String, String>> requirements,Checker ck) {
		boolean firstRequirement = true;

		String encodingRequirements = "And(";

		for (Entry<String, String> requirement : requirements) {

			String precondition = requirement.getKey();
			String postcondition = requirement.getValue();

			if (firstRequirement) {
				String preconditionString=ck.conversion(precondition);
				String postconditionString=ck.conversion(postcondition);
				if(preconditionString.equals("True")) {
					encodingRequirements = encodingRequirements + postconditionString;
				}
				else {
					if(!preconditionString.equals("False")) {
						encodingRequirements = encodingRequirements + "Implies(" + preconditionString + ","
								+postconditionString + ")";
					}
				
				}
				
				

				firstRequirement = false;
			} else {
				String preconditionString=ck.conversion(precondition);
				String postconditionString=ck.conversion(postcondition);
				if(preconditionString.equals("True")) {
					encodingRequirements = encodingRequirements +","+postconditionString;
				}
				else {
					if(!preconditionString.equals("False")) {
						encodingRequirements = encodingRequirements + ",Implies(" + preconditionString + ","
								+postconditionString + ")";
					}
				
				}
				
			}
		}
		encodingRequirements=encodingRequirements+")";
		encodingRequirements="Exists(i,Not("  + encodingRequirements + "))";
		
		return encodingRequirements;
	}

	@Override
	public void printPositiveResult(Scanner sc, Writer wt) throws Exception {
		wt.write("\t print('Requirements Table Consistent (unsat)')\n");
		
	}

	@Override
	public void printNegativeResult(Scanner sc, Writer wt) throws Exception {
		wt.write("\t\t print('Requirements Table Inconsistent (sat)')\n");
	}

}
