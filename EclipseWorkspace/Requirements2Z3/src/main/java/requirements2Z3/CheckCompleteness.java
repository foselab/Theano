package requirements2Z3;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import generated.matlabLexer;
import generated.matlabParser;
import requirements2Z3.completeness.ContainsVariableVisitor;
import requirements2Z3.completeness.UeUfFs;

public class CheckCompleteness {

	private Set<String> inputVariables;

	private Set<String> outputVariables;

	public CheckCompleteness(String inputFile, String outputFile) throws Exception {
		this.inputVariables = new HashSet<>();
		this.outputVariables = new HashSet<>();
		// Creates a scanner that reads the file containing the Requirements Table
		Scanner sc = new Scanner(new FileReader(inputFile));

		// Creates a writer that writes the python file to be executed by Z3
		Writer wt = new FileWriter(outputFile);

		this.processVariableDefinitions(sc, wt);

		this.processRequirements(sc, wt);

		sc.close();
		wt.close();
	}

	private void processRequirements(Scanner sc, Writer wt) throws Exception {
		
		System.out.println("Processing the requirements");
		// checks that the first line of the file contains the string ----Input Data --
		// if not throws an error
		String nextLine=sc.nextLine();
		if (!(nextLine.equals("------- Requirements -----"))) {
			sc.close();
			wt.close();
			throw new Exception("The file does not start with the string \"------- Input Data -----\" ");
		}
		// this set will contain all the preconditions of the Requirements Table
		Set<Entry<String, String>> requirements = new HashSet<>();

		nextLine=sc.nextLine();
		while (sc.hasNextLine() && !nextLine.equals("------- End of Requirements -----")) {
			
			System.out.println(nextLine);
			String[] fields = nextLine.split(",");
			requirements.add(new AbstractMap.SimpleEntry<String, String>(fields[0] + "\r", fields[1] + "\r"));
			nextLine=sc.nextLine();
		}

		// Monotonicity constraint for the timestamp array

		wt.write("s = Solver()\n");

		String tm = "ForAll(j,Implies(j>=0,(tau[j]<tau[j+1])))";

		String encodingOutpuVariables = "";
		boolean firstOutputVariables = true;

		System.out.println("Analyzing the requirements");
		for (String outputVariable : this.outputVariables) {

			System.out.println("Generating the condition for the output variable "+outputVariable);

			Set<String> preconditions = this.getPre(outputVariable, requirements);

			
			String encodingForAnOutputVariable = "";
			boolean firstPrecondition = true;

			for (String precondition : preconditions) {
				System.out.println("Precondition: " + precondition);
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
		wt.write("if (res.r ==  Z3_L_FALSE):\n");
		wt.write("\t print('Requirements Table Complete (unsat)')\n");
		wt.write("else:\n");
		wt.write("\t if (res.r == Z3_L_TRUE):\n");
		wt.write("\t\t print('Requirements Table InComplete (sat)')\n");
		wt.write("\t else:\n");
		wt.write("\t\t print('unknown')");
	}

	private void processVariableDefinitions(Scanner sc, Writer wt) throws IOException, Exception {
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

	public static void main(String[] args) throws Exception {

		String folder="TestsCompleteness";
		String[] requirementsTablesFileNames=new String[] {"Table1", "Table2"};
		String encoding="UeUfFs";
		
		for(String fileName: requirementsTablesFileNames) {
		
			System.out.println("Processing the file: "+"./"+folder+"/"+fileName+".txt");
			new CheckCompleteness("./"+folder+"/"+fileName+".txt", "./"+folder+"/"+encoding+"/"+fileName+".py");
		}
	}

	private String conversion(String input) {
		matlabLexer lexer = new matlabLexer(new ANTLRInputStream(input));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		matlabParser parser = new matlabParser(tokens);
		parser.setBuildParseTree(true);

		ParseTree tree = parser.statement_list();

		String result = tree.accept(new UeUfFs());
		return result;
	}

	private Set<String> getPre(String variable, Set<Entry<String, String>> requirements) {

		Set<String> preconditions = new HashSet<>();

		for (Entry<String, String> requirement : requirements) {
			matlabLexer lexer = new matlabLexer(new ANTLRInputStream(requirement.getValue()+"\r"));
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
