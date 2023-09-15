package requirements2Z3.completeness.checkers;

import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;

import org.antlr.v4.runtime.tree.ParseTree;

import requirements2Z3.completeness.visitors.BeArFs;

public class BeArFsCompletenessCheckers extends CompletenessChecker {

	private float ts;

	private int bound;

	private int currentIndexI;

	public BeArFsCompletenessCheckers(String inputFile, String outputFile, float ts, int bound) throws Exception {
		super(inputFile, outputFile);
		this.ts = ts;
		this.bound = bound;
	}

	protected void processVariableDefinitions(Scanner sc, Writer wt) throws IOException, Exception {
		super.processVariableDefinitions(sc, wt);

		wt.write("Ts = Real('Ts')\n");

	}

	@Override
	protected void defineTau(Scanner sc, Writer wt) throws Exception {
		wt.write("tau = Array('tau', I, R)\n");
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

	@Override
	protected String visitTree(ParseTree tree) {
		return tree.accept(new BeArFs(currentIndexI,this.ts));
	}

	@Override
	protected String getMonotonicityConstraint() {
		return "ForAll(j,Implies(j>=0,(tau[j+1]-tau[j]=" + ts + ")))";
	}

	@Override
	protected void writeTimestampConstraint(Writer wt) throws IOException {
		wt.write("s.add(Ts==" + ts + ")\n");
	}
}
