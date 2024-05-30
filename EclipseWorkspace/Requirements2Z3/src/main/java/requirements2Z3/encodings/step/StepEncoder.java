package requirements2Z3.encodings.step;

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
		return this.traceEncoder.getSignalValue(signalname, position);
	}

	/**
	 * returns the trace encoder
	 * 
	 * @return the trace encoder
	 */
	protected TraceEncoder getTraceEncoder() {
		return traceEncoder;
	}

	public String defineTraceVariable() {
		return this.traceEncoder.defTimestamp();
	}
}
