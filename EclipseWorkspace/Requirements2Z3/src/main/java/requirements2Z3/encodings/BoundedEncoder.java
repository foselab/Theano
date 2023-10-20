package requirements2Z3.encodings;

import requirements2Z3.encodings.step.StepEncoder;

/**
 * Returns the encoding of a Variable Step trace
 */
public class BoundedEncoder extends Encoder {

	private int bound;

	/**
	 * Creates a BoundedVariableStepTraceEncoder
	 * 
	 * @param bound the bound to be used for the encoding
	 * @throws IllegalArgumentException if the bound is lower than 1
	 */
	public BoundedEncoder(StepEncoder stepEncoder, int bound) {
		super(stepEncoder);
		if (bound < 1) {
			throw new IllegalArgumentException("The value " + bound + " for the bound must be greater than 0");
		}
		this.bound = bound;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getMonotonicityConstraint() {

		StringBuilder bulder = new StringBuilder();
		bulder.append("And(");
		for (int i = 0; i < this.bound - 1; i++) {
			if (i != 0) {
				bulder.append(",");
			}
			bulder.append(this.getStepEncoder().getTracePositionMonotonicConstraint("tau", String.valueOf(i)));
		}
		bulder.append(")");

		return bulder.toString();
	}
	
	
}
