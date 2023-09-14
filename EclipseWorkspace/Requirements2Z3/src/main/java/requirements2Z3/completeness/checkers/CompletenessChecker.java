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
import requirements2Z3.completeness.visitors.UeUfFs;

public abstract class CompletenessChecker {
	
	protected Set<String> inputVariables;

	protected Set<String> outputVariables;
	
	public CompletenessChecker(String inputFile, String outputFile) throws Exception  {
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

	abstract protected void processVariableDefinitions(Scanner sc, Writer wt) throws IOException, Exception;

	protected void processResult(Scanner sc, Writer wt) throws Exception {

		System.out.println("Processing the result");
		
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
			
			if(nextLine.startsWith("Complete")) {
				wt.write("if (res.r ==  Z3_L_TRUE):\n");
				wt.write("\t print('Error! Expecting  Complete, but result is incomplete')\n");
				
				wt.write("if (res.r ==  Z3_L_FALSE):\n");
				wt.write("\t print('Correct! Expecting  Complete, and result is complete')\n");
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

		String result = tree.accept(new UeUfFs());
		return result;
	}

}
