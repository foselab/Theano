package requirements2Z3.completeness.checkers;

import java.util.Map.Entry;
import java.util.Set;

public abstract class BoundedCompletenessChecker extends CompletenessChecker {

	private final float ts;

	private final int bound;
	
	protected int currentIndexI;
	
	public BoundedCompletenessChecker(String inputFile, String outputFile, float ts, int bound) throws Exception {
		super(inputFile, outputFile);
		this.ts = ts;
		this.bound = bound;

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

}
