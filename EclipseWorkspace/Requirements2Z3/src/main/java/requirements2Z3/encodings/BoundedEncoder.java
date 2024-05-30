package requirements2Z3.encodings;

import org.apache.commons.lang3.StringUtils;

import requirements2Z3.encodings.step.StepEncoder;
import requirements2Z3.z3formulae.Z3Expression;
import requirements2Z3.z3formulae.Z3Formula;

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
	public Z3Formula getIsStartup(String signalname, String position) {
		if (StringUtils.isNumeric(position)) {
			int index = Integer.parseInt(position);
			if (index == 0) {
				return Z3Formula.getTrue();
			} else {
				return Z3Formula.getFalse();
			}
		} else {
			throw new IllegalArgumentException("The position to be considered by the bounded encoding should be numeric");
		}
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
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Z3Expression getPrevValue(String signalname, String position) {
		if (StringUtils.isNumeric(position)) {
			int index = Integer.parseInt(position);
			if (index == 0) {
				return this.getTracePosition(signalname, position);
			} else {
				return this.getTracePosition(signalname, position + "-1");
			}
		} else {
			throw new IllegalArgumentException("The position for the bounded encoding must be numeric");
		}
	}
}
