package requirements2Z3.encodings;

import org.apache.commons.lang3.StringUtils;

import requirements2Z3.encodings.step.StepEncoder;
import requirements2Z3.z3formulae.Z3Exp;
import requirements2Z3.z3formulae.Z3Formula;

/**
 * Returns the encoding for a trace. The encoder is implemented using a
 * decorator structure
 * 
 */
public abstract class Encoder {

	private StepEncoder stepEncoder;

	public Encoder(StepEncoder stepEncoder) {
		this.stepEncoder = stepEncoder;
	}

	/**
	 * Returns the String that forces the monotonicity constraint to hold on the
	 * trace
	 * 
	 * @return the String that forces the monotonicity constraint to hold on the
	 *         trace
	 */
	public abstract String getMonotonicityConstraint();
	

	/**
	 * Defines the variables used to encode the trace
	 * 
	 * @return a String that defines the variable used to encode the trace
	 */
	public String defineTraceVariable() {
		return this.stepEncoder.defTimestamp();
	}

	protected StepEncoder getStepEncoder() {
		return stepEncoder;
	}

	/**
	 * Given a signal name and the position of the trace to be considered, returns a
	 * string accessing the signal name at that position
	 * 
	 * @param signalname the name of the signal
	 * @param position   the position to be considered
	 * @return a String that represents the Z3 encoding accessing the trace in that
	 *         position.
	 * @throws IllegalArgumentException if the signal name of the position is null
	 */
	public Z3Exp getTracePosition(String signalname, String position) {
		return this.stepEncoder.getSig(signalname, position);
	}

	/**
	 * Returns a string representing a condition that is true if a specific position
	 * of the trace is the first position of the trace, false otherwise
	 * 
	 * @param signalname the name of the signal
	 * @param position   the position to be considered
	 * @return a String that represents the Z3 encoding accessing the trace in that
	 *         position.
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
			return Z3Formula.getPredicate(this.stepEncoder.getSig("tau", position),
					Z3Formula.getRelationalOperator("=="), Z3Formula.getConstant("0"));
		}
	}

	/**
	 * Returns a string representing a condition that returns the provious value of
	 * a string given a position (i.e., a generic index such as 'i' or an actual
	 * index such as '0')
	 * 
	 * @param signalname the name of the signal
	 * @param position   the position to be considered
	 * @return a string representing a condition that returns the provious value of
	 *         a string given a position (i.e., a generic index such as 'i' or an
	 *         actual index such as '0')
	 */
	public Z3Exp getPrevValue(String signalname, String position) {
		if (StringUtils.isNumeric(position)) {
			int index = Integer.parseInt(position);
			if (index == 0) {
				return this.getStepEncoder().getSig(signalname, position);
			} else {
				return this.getStepEncoder().getSig(signalname, position + "-1");
			}
		} else {
			return Z3Formula.getConstant("((" + position + "==0)*("
					+ this.getStepEncoder().getSig(signalname, position) + ")+(" + position + ">0)*("
					+ this.getStepEncoder().getSig(signalname, position + "-1") + "))");
		}
	}

}
