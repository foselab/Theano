package requirements2Z3.checkers;

import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

import org.antlr.v4.runtime.tree.ParseTree;

import requirements2Z3.Checker;
import requirements2Z3.RTFunctionality;
import requirements2Z3.visitors.UeArVs;

public class UeUfVsChecker extends Checker {

	
	public UeUfVsChecker(String inputFile, String outputFile, RTFunctionality functionality, float ts) throws Exception {
		super(inputFile, outputFile,functionality);
	}


	public void processVariableDefinitions(Scanner sc, Writer wt) throws IOException, Exception {
		super.processVariableDefinitions(sc, wt);
	}

	@Override
	public void defineTau(Scanner sc, Writer wt) throws Exception {
		wt.write("tau = Function('tau', IntSort(), RealSort())\n");
	}


	@Override
	public String visitTree(ParseTree tree) {
		return tree.accept(new UeArVs());
	}


	@Override
	public String getMonotonicityConstraint() {
		return "ForAll(j,Implies(j>=0,(tau[j]<tau[j+1])))";
	}


	@Override
	public void writeTimestampConstraint(Writer wt) throws IOException {
				
	}
	@Override
	public void processRequirements(Scanner sc, Writer wt) throws Exception {
		this.functionality.processRequirements(sc, wt, this);
	}
}
