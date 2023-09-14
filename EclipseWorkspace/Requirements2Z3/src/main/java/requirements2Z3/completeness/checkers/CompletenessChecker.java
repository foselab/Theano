package requirements2Z3.completeness.checkers;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import generated.matlabLexer;
import generated.matlabParser;
import requirements2Z3.completeness.visitors.ContainsVariableVisitor;

public abstract class CompletenessChecker {

	protected Set<String> inputVariables;

	protected Set<String> outputVariables;

	public CompletenessChecker(String inputFile, String outputFile) throws Exception {
		this.inputVariables = new HashSet<>();
		this.outputVariables = new HashSet<>();
		// Creates a scanner that reads the file containing the Requirements Table
		Scanner sc = new Scanner(new FileReader(inputFile));

		// Creates a writer that writes the python file to be executed by Z3
		Writer wt = new FileWriter(outputFile);

		this.processVariableDefinitions(sc, wt);

		this.processRequirements(sc, wt);

		this.processResult(sc, wt);

		sc.close();
		wt.close();
	}

	abstract protected void processRequirements(Scanner sc, Writer wt) throws Exception;

	abstract protected void defineTau(Scanner sc, Writer wt) throws Exception;
	
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
				wt.write(splitted[0] + "=" + "Array('" + splitted[0] + "', I, R)\n");
			} else {
				if (splitted[1].equals("Int")) {
					wt.write(splitted[0] + "=" + "Array('" + splitted[0] + "', I, R)\n");
				}
			}
			nextLine = sc.nextLine();
		}
	}

	protected void processResult(Scanner sc, Writer wt) throws Exception {

		System.out.println("Processing the result");

		wt.write("res=s.check()\n");
		wt.write("if (res.r ==  Z3_L_FALSE):\n");
		wt.write("\t print('Requirements Table Complete (unsat)')\n");
		wt.write("else:\n");
		wt.write("\t if (res.r == Z3_L_TRUE):\n");
		wt.write("\t\t print('Requirements Table InComplete (sat)')\n");
		wt.write("\t else:\n");
		wt.write("\t\t print('unknown')\n");
		// checks that the first line of the file contains the string ----Input Data --
		// if not throws an error

		if (!(sc.nextLine().equals("------- Expected Results -----"))) {
			sc.close();
			wt.close();
			throw new Exception("The file does not start with the string \"------- Expected Results -----\" ");
		}

		// reads one line and put it into next line
		String nextLine = sc.next();

		while (nextLine != null && !nextLine.startsWith("------- End of Expected Results -----")) {

			if (nextLine.startsWith("Complete")) {
				wt.write("if (res.r ==  Z3_L_FALSE):\n");
				wt.write("\t print('Correct!')\n");
				wt.write("else:\n");
				wt.write("\t if (res.r == Z3_L_TRUE):\n");
				wt.write("\t\t print('Error')\n");
				wt.write("\t else:\n");
				wt.write("\t\t print('MissRes')\n");
			}
			if (nextLine.startsWith("Incomplete")) {
				wt.write("if (res.r ==  Z3_L_FALSE):\n");
				wt.write("\t print('Error!')\n");
				wt.write("else:\n");
				wt.write("\t if (res.r == Z3_L_TRUE):\n");
				wt.write("\t\t print('Correct')\n");
				wt.write("\t else:\n");
				wt.write("\t\t print('MissRes')\n");
			}
			nextLine = sc.nextLine();
		}
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

	protected String conversion(String input) {
		matlabLexer lexer = new matlabLexer(new ANTLRInputStream(input));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		matlabParser parser = new matlabParser(tokens);
		parser.setBuildParseTree(true);

		ParseTree tree = parser.statement_list();

		String result = this.visitTree(tree);
		return result;
	}
	
	abstract protected String visitTree(ParseTree tree);

}
