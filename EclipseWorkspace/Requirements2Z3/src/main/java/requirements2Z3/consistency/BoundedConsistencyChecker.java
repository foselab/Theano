package requirements2Z3.consistency;

import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import generated.matlabLexer;
import generated.matlabParser;
import requirements2Z3.Checker;
import requirements2Z3.visitors.ContainsVariableVisitor;

public abstract class BoundedConsistencyChecker extends ConsistencyChecker {

	private final float ts;

	private final int bound;
	
	protected int currentIndexI;
	
	public BoundedConsistencyChecker( float ts, int bound, int currentIndexI) throws Exception {
		this.ts = ts;
		this.bound = bound;
		this.currentIndexI=currentIndexI;

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

	

	protected String getEncodingOutputVariable(Set<Entry<String, String>> requirements, String encodingOutpuVariables,Checker ck) {
		boolean firstOutputVariables = true;

		String encodingIndex = "Or(";

		for (currentIndexI = 0; currentIndexI <= bound; currentIndexI++) {
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
