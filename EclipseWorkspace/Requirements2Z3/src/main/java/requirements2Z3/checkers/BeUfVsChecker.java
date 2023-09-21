package requirements2Z3.checkers;

import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

import org.antlr.v4.runtime.tree.ParseTree;

import requirements2Z3.RTBoundedFunctionality;
import requirements2Z3.visitors.BeUfVs;

public class BeUfVsChecker extends BoundedChecker {

	public BeUfVsChecker(String inputFile, String outputFile, RTBoundedFunctionality functionality, int bound) throws Exception {
		super(inputFile, outputFile, functionality,  bound);
	}

	public void processVariableDefinitions(Scanner sc, Writer wt) throws IOException, Exception {
		super.processVariableDefinitions(sc, wt);
		wt.write("Ts = Real('Ts')\n");
	}

	@Override
	public void defineTau(Scanner sc, Writer wt) throws Exception {
		wt.write("tau = Function('tau', IntSort(), RealSort())\n");
	}

	@Override
	public String visitTree(ParseTree tree) {
		return tree.accept(new BeUfVs(this.getCurrentIndexI()));
	}

	@Override
	public String getMonotonicityConstraint() {
		return "ForAll(j,Implies(j>=0,(tau(j)<tau(j+1))))";
	}

	@Override
	public void writeTimestampConstraint(Writer wt) throws IOException {
	}
	@Override
	public void processRequirements(Scanner sc, Writer wt) throws Exception {
		this.functionality.processRequirements(sc, wt, this);
	}
}
