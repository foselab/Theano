package requirements2Z3.completeness.checkers;

import java.io.IOException;
import java.io.Writer;
import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

public class UeUfFsCompletenessCheckers extends CompletenessChecker {

	public UeUfFsCompletenessCheckers(String inputFile, String outputFile) throws Exception {
		super(inputFile, outputFile);
	}

	protected void processRequirements(Scanner sc, Writer wt) throws Exception {

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

		String tm = "ForAll(j,Implies(j>=0,(tau[j]<tau[j+1])))";

		String encodingOutpuVariables = "";
		boolean firstOutputVariables = true;

		for (String outputVariable : this.outputVariables) {

		
			Set<String> preconditions = this.getPre(outputVariable, requirements);

			String encodingForAnOutputVariable = "";
			boolean firstPrecondition = true;

			for (String precondition : preconditions) {
				if (firstPrecondition) {
					encodingForAnOutputVariable = "Not(" + conversion(precondition) + ")";

					firstPrecondition = false;
				} else {
					encodingForAnOutputVariable = "And(" + encodingForAnOutputVariable + ",Not("
							+ conversion(precondition) + "))";
				}
			}

			if (firstOutputVariables) {
				encodingOutpuVariables = encodingForAnOutputVariable;
				firstOutputVariables = false;
			} else {
				encodingOutpuVariables = "Or(" + encodingOutpuVariables + "," + encodingForAnOutputVariable + ")";
			}

		}

		String inputVariableStrings = "";

		for (String inputVariable : this.inputVariables) {
			inputVariableStrings = inputVariableStrings + inputVariable + ", ";

		}

		String finalConvertedString = "Exists([" + inputVariableStrings + "tau, i] ,And(" + tm + ","
				+ encodingOutpuVariables + "))";

		wt.write("s.add(" + finalConvertedString + ")\n");
		// wt.write(conversion(sc.nextLine()+";")+"\n");

		wt.write("res=s.check()\n");

	}

	protected void processVariableDefinitions(Scanner sc, Writer wt) throws IOException, Exception {
		System.out.println("Processing the variable definitions");
		
		// writes the first file in the file to import the Z3 library
		wt.write("from z3 import *;\n");

		// checks that the first line of the file contains the string ----Input Data --
		// if not throws an error
		if (!(sc.nextLine().equals("------- Input Data -----"))) {
			sc.close();
			wt.close();
			throw new Exception("The file does not start with the string \"------- Input Data -----\" ");
		}

		// reads one line and put it into next line
		String nextLine = null;
		if (sc.hasNext()) {
			nextLine = sc.nextLine();
		}
		wt.write("I = IntSort()\n");
		wt.write("R = RealSort()\n");
		wt.write("tau = Array('tau', I, R)\n");
		wt.write("j = Int('j')\n");
		wt.write("i = Int('i')\n");

		// Executes the instruction within the while loop until the string -------
		// Requirements ----- is found or nextLine is null
		while (nextLine != null && !nextLine.equals("------- End of Input Data -----")) {

			// splits the line separated by the character comma ","
			String[] splitted = nextLine.split(",");

			if (splitted[2].equals("input")) {
				this.inputVariables.add(splitted[0]);
			}
			if (splitted[2].equals("output")) {
				this.outputVariables.add(splitted[0]);
			}

			// if the the type is "Real"
			if (splitted[1].equals("Real")) {
				wt.write(splitted[0] + "=" + "Array('" + splitted[0] + "', I, R)\n");
			} else {
				if (splitted[1].equals("Int")) {
					wt.write(splitted[0] + "=" + "Array('" + splitted[0] + "', I, R)\n");
				}
			}
			nextLine = sc.nextLine();
		}
	}

}
