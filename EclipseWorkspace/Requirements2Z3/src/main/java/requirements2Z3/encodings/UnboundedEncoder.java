package requirements2Z3.encodings;

import requirements2Z3.encodings.step.StepEncoder;

/**
 * Returns the encoding of a Variable Step trace
 */
public class UnboundedEncoder extends Encoder {


	/**
	 * Creates a UnboundedVariableStepTraceEncoder
	 */
	public UnboundedEncoder(StepEncoder stepEncoder) {
		super(stepEncoder);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getMonotonicityConstraint() {
		return "And("
					+ "ForAll(j,Implies(j>=0,("+this.getStepEncoder().getTracePositionMonotonicConstraint("tau", String.valueOf("j"))+"))"
							+ "),"
					+ "tau[0]==0"
				+ ")";
	}
}
