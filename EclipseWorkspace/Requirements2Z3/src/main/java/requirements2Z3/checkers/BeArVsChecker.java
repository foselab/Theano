package requirements2Z3.checkers;

import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

import org.antlr.v4.runtime.tree.ParseTree;

import requirements2Z3.RTBoundedFunctionality;
import requirements2Z3.visitors.BeArVs;

public class BeArVsChecker extends BoundedChecker {

	private RTBoundedFunctionality boundedFunctionality;

	public BeArVsChecker(String inputFile, String outputFile, RTBoundedFunctionality functionality, int bound)
			throws Exception {
		super(inputFile, outputFile, functionality, bound);
		this.boundedFunctionality = functionality;
	}

	public void processVariableDefinitions(Scanner sc, Writer wt) throws IOException, Exception {
		super.processVariableDefinitions(sc, wt);
		wt.write("Ts = Real('Ts')\n");
	}

	@Override
	public void defineTau(Scanner sc, Writer wt) throws Exception {
		wt.write("tau = Array('tau', I, R)\n");
	}

	@Override
	public String visitTree(ParseTree tree) {
		return tree.accept(new BeArVs(boundedFunctionality.getCurrentIndexI()));
	}

	@Override
	public String getMonotonicityConstraint() {
		StringBuilder bulder = new StringBuilder();
		bulder.append("And(");
		for (int i = 0; i < this.getBound()-1; i++) {
			if (i != 0) {
				bulder.append(",");
			}
			bulder.append("tau[" + i + "]<tau[" + (i+1) + "]");
		}
		bulder.append(")");

		return bulder.toString();
	}

	@Override
	public void writeTimestampConstraint(Writer wt) throws IOException {
	}

	@Override
	public void processRequirements(Scanner sc, Writer wt) throws Exception {
		this.functionality.processRequirements(sc, wt, this);
	}
}
