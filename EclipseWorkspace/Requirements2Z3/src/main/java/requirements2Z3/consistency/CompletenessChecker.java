package requirements2Z3.consistency;

import java.io.Writer;
import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Map.Entry;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import generated.matlabLexer;
import generated.matlabParser;

import java.util.Scanner;
import java.util.Set;

import requirements2Z3.Checker;
import requirements2Z3.RTFunctionality;
import requirements2Z3.visitors.ContainsVariableVisitor;

public class CompletenessChecker implements RTFunctionality {

	

	public void processRequirements(Scanner sc, Writer wt,Checker ck) throws Exception{
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

		String encodingOutpuVariables = getEncodingOutputVariable(requirements,ck);

		String inputVariableStrings = "";

		for (String inputVariable : ck.getInputVariables()) {
			inputVariableStrings = inputVariableStrings + inputVariable + ", ";

		}

		String finalConvertedString = "And(" + tm + "," + encodingOutpuVariables + ")";

		wt.write("s.add(" + finalConvertedString + ")\n");
		// wt.write(conversion(sc.nextLine()+";")+"\n");
	
	}
	
	protected String getEncodingOutputVariable(Set<Entry<String, String>> requirements, Checker ck) {
		boolean firstOutputVariables = true;
		
		String encodingOutpuVariables="";

		for (String outputVariable : ck.getOutputVariables()) {

		
			Set<String> preconditions = this.getPre(outputVariable, requirements);

			String encodingForAnOutputVariable = "";
			boolean firstPrecondition = true;

			for (String precondition : preconditions) {
				if (firstPrecondition) {
					encodingForAnOutputVariable = "Not(" + ck.conversion(precondition) + ")";

					firstPrecondition = false;
				} else {
					encodingForAnOutputVariable = "And(" + encodingForAnOutputVariable + ",Not("
							+ ck.conversion(precondition) + "))";
				}
			}

			if (firstOutputVariables) {
				encodingOutpuVariables = encodingForAnOutputVariable;
				firstOutputVariables = false;
			} else {
				encodingOutpuVariables = "Or(" + encodingOutpuVariables + "," + encodingForAnOutputVariable + ")";
			}

		}
		return encodingOutpuVariables;
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
