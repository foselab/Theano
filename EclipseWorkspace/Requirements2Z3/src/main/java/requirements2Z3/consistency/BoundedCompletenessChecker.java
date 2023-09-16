package requirements2Z3.consistency;

import java.util.Map.Entry;

import requirements2Z3.Checker;

import java.util.Set;

public abstract class BoundedCompletenessChecker extends CompletenessChecker {

	private final float ts;

	private final int bound;
	
	protected int currentIndexI;
	
	public BoundedCompletenessChecker(float ts, int bound, int currentIndexI) throws Exception {
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

}
