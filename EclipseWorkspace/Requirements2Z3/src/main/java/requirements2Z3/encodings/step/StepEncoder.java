package requirements2Z3.encodings.step;

import org.apache.commons.lang3.StringUtils;

import requirements2Z3.encodings.trace.TraceEncoder;
import requirements2Z3.z3formulae.Z3Expression;
import requirements2Z3.z3formulae.Z3Formula;

public abstract class StepEncoder {

	private TraceEncoder traceEncoder;

	/**
	 * 
	 * @param traceEncoder the encoder to be used to encode the trace
	 * @throws NullPointerException if the trace encoder is null
	 */
	public StepEncoder(TraceEncoder traceEncoder) {
		if (traceEncoder == null) {
			throw new NullPointerException("The trace encoder can not be null");
		}
		this.traceEncoder = traceEncoder;
	}

	/**
	 * Encodes a step of the trace
	 * 
	 * @param signalname the name of the signal
	 * @param position   the position to be considered
	 * @return a String that represents the Z3 encoding accessing the trace in that
	 *         position.
	 * @throws IllegalArgumentException if the signal name of the position is null
	 */
	public abstract Z3Formula getTracePositionMonotonicConstraint(String signalname, String position);

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
			return Z3Formula.getPredicate(this.getTraceEncoder().getTracePosition("tau", position),
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
	public Z3Expression getPrevValue(String signalname, String position) {
		if (StringUtils.isNumeric(position)) {
			int index = Integer.parseInt(position);
			if (index == 0) {
				return this.getTraceEncoder().getTracePosition(signalname, position);
			} else {
				return this.getTraceEncoder().getTracePosition(signalname, position + "-1");
			}
		} else {
			return Z3Formula.getConstant("((" + position + "==0)*("
					+ this.getTraceEncoder().getTracePosition(signalname, position) + ")+(" + position + ">0)*("
					+ this.getTraceEncoder().getTracePosition(signalname, position + "-1") + "))");
		}
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
	public Z3Expression getTracePosition(String signalname, String position) {
		return this.traceEncoder.getTracePosition(signalname, position);
	}

	/**
	 * returns the trace encoder
	 * 
	 * @return the trace encoder
	 */
	public TraceEncoder getTraceEncoder() {
		return traceEncoder;
	}

	public String defineTraceVariable() {
		return this.traceEncoder.defineTraceVariable();
	}
}
