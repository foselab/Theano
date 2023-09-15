package requirements2Z3.completeness.checkers;

import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

import org.antlr.v4.runtime.tree.ParseTree;

import requirements2Z3.completeness.visitors.UeArFs;

public class UeArFsCompletenessCheckers extends CompletenessChecker {

	private float ts;
	
	public UeArFsCompletenessCheckers(String inputFile, String outputFile, float ts) throws Exception {
		super(inputFile, outputFile);
		this.ts=ts;
	}


	protected void processVariableDefinitions(Scanner sc, Writer wt) throws IOException, Exception {
		super.processVariableDefinitions(sc, wt);
		
		wt.write("Ts = Real('Ts')\n");
		
	}

	@Override
	protected void defineTau(Scanner sc, Writer wt) throws Exception {
		wt.write("tau = Array('tau', I, R)\n");
	}


	@Override
	protected String visitTree(ParseTree tree) {
		return tree.accept(new UeArFs());
	}


	@Override
	protected String getMonotonicityConstraint() {
		return "ForAll(j,Implies(j>=0,(tau[j+1]-tau[j]="+ts+")))";
	}


	@Override
	protected void writeTimestampConstraint(Writer wt) throws IOException {
		wt.write("s.add(Ts=="+ts+")\n");		
	}
}
