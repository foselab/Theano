package requirements2Z3.checkers;

import java.util.Map.Entry;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import generated.matlabLexer;
import generated.matlabParser;

import java.util.HashSet;
import java.util.Set;

import requirements2Z3.Checker;
import requirements2Z3.RTFunctionality;
import requirements2Z3.visitors.ContainsVariableVisitor;

public abstract class BoundedChecker extends Checker {

	private final int bound;
	
	protected int currentIndexI;
	
	public BoundedChecker(String inputFile, String outputFile, RTFunctionality functionality, int bound) throws Exception {
		super(inputFile, outputFile,functionality);
		this.bound = bound;

	}
	
	

	public int getBound() {
		return bound;
	}

	public int getCurrentIndexI() {
		return currentIndexI;
	}

	

	protected String getEncodingOutputVariable(Set<Entry<String, String>> requirements, String encodingOutpuVariables) {
		boolean firstOutputVariables = true;

		String encodingIndex = "Or(";

		for (currentIndexI = 0; currentIndexI <= bound; currentIndexI++) {
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
