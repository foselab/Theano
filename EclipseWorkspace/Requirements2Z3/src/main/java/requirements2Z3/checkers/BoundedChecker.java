package requirements2Z3.checkers;

import java.io.IOException;
import java.io.Writer;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import generated.matlabLexer;
import generated.matlabParser;
import requirements2Z3.Checker;
import requirements2Z3.RTBoundedFunctionality;
import requirements2Z3.visitors.ContainsVariableVisitor;

public abstract class BoundedChecker extends Checker {

	private final int bound;

	private RTBoundedFunctionality boundedFunctionality;

	public BoundedChecker(String inputFile, String outputFile, RTBoundedFunctionality functionality, int bound)
			throws Exception {
		super(inputFile, outputFile, functionality);
		this.bound = bound;
		this.boundedFunctionality=functionality;

	}
	
	public void processVariableDefinitions(Scanner sc, Writer wt) throws IOException, Exception {
		//System.out.println("Processing the variable definitions");

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
		this.defineTau(sc, wt);
		wt.write("j = Int('j')\n");
		wt.write("i = Int('i')\n");
		wt.write("k = Int('k')\n");

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
				this.defineRealVariable(splitted[0],wt);
			} else {
				if (splitted[1].equals("Int")) {
					this.defineIntVariable(splitted[0],wt);
				}
			}
			nextLine = sc.nextLine();
		}
	}

	public int getBound() {
		return bound;
	}

	public int getCurrentIndexI() {
		return this.boundedFunctionality.getCurrentIndexI();
	}

	protected String getEncodingOutputVariable(Set<Entry<String, String>> requirements, String encodingOutpuVariables) {
		boolean firstOutputVariables = true;

		String encodingIndex = "Or(";

		for (int currentIndexI = 0; currentIndexI <= bound; currentIndexI++) {
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
				if (currentIndexI < bound) {
					encodingOutpuVariables = encodingOutpuVariables + ",";
				}

			}
			encodingIndex = encodingIndex + encodingOutpuVariables;

		}
		return encodingIndex + ")";
	}

	protected Set<String> getPre(String variable, Set<Entry<String, String>> requirements) {

		Set<String> preconditions = new HashSet<>();

		for (Entry<String, String> requirement : requirements) {
			matlabLexer lexer = new matlabLexer(new ANTLRInputStream(requirement.getValue() + "\r"));
			CommonTokenStream tokens = new CommonTokenStream(lexer);
			matlabParser parser = new matlabParser(tokens);
			parser.setBuildParseTree(true);

			ParseTree tree = parser.statement_list();

			if (tree.accept(new ContainsVariableVisitor(variable))) {
				preconditions.add(requirement.getKey());
			}
		}
		return preconditions;
	}
	
	

}
