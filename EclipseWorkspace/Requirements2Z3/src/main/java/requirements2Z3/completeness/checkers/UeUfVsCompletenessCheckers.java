package requirements2Z3.completeness.checkers;

import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

import org.antlr.v4.runtime.tree.ParseTree;

import requirements2Z3.completeness.visitors.UeArVs;

public class UeUfVsCompletenessCheckers extends CompletenessChecker {

	
	public UeUfVsCompletenessCheckers(String inputFile, String outputFile, float ts) throws Exception {
		super(inputFile, outputFile);
	}


	protected void processVariableDefinitions(Scanner sc, Writer wt) throws IOException, Exception {
		super.processVariableDefinitions(sc, wt);
	}

	@Override
	protected void defineTau(Scanner sc, Writer wt) throws Exception {
		wt.write("tau = Function('tau', IntSort(), RealSort())\n");
	}


	@Override
	protected String visitTree(ParseTree tree) {
		return tree.accept(new UeArVs());
	}


	@Override
	protected String getMonotonicityConstraint() {
		return "ForAll(j,Implies(j>=0,(tau[j]<tau[j+1])))";
	}


	@Override
	protected void writeTimestampConstraint(Writer wt) throws IOException {
				
	}
}
