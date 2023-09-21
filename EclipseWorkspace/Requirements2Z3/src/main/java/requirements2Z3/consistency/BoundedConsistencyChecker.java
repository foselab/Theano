package requirements2Z3.consistency;

import java.util.Map.Entry;
import java.util.Set;

import requirements2Z3.Checker;
import requirements2Z3.RTBoundedFunctionality;

public class BoundedConsistencyChecker extends ConsistencyChecker implements RTBoundedFunctionality {

	private final float ts;

	private final int bound;

	protected int currentIndexI;

	public BoundedConsistencyChecker(float ts, int bound, int currentIndexI) throws Exception {
		this.ts = ts;
		this.bound = bound;
		this.currentIndexI = currentIndexI;

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

	protected String getEncodingOutputVariable(Set<Entry<String, String>> requirements, String encodingOutpuVariables,
			Checker ck) {
		boolean firstRequirement = true;
		String encodingRequirements = "Or(";

		for (currentIndexI = 0; currentIndexI <= bound; currentIndexI++) {


			for (Entry<String, String> requirement : requirements) {

				String precondition = requirement.getKey();
				String postcondition = requirement.getValue();

				if (firstRequirement) {
					encodingRequirements = encodingRequirements + "Not(Implies(" + ck.conversion(precondition) + ","
							+ ck.conversion(postcondition) + ")";
					firstRequirement = false;
				} else {
					encodingRequirements = encodingRequirements + ",Not(Implies(" + ck.conversion(precondition) + ","
							+ ck.conversion(postcondition) + ")";
				}
			}

			if (currentIndexI < bound) {
				encodingRequirements = encodingRequirements + ",";
			}

		}
		return encodingRequirements + ")";
	}

	

}
