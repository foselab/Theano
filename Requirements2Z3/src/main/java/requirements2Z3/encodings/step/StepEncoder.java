package requirements2Z3.encodings.step;

import requirements2Z3.encodings.trace.TraceEncoder;
import requirements2Z3.z3formulae.Z3Exp;
import requirements2Z3.z3formulae.Z3Formula;

public abstract class StepEncoder {

	protected TraceEncoder traceEncoder;

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
	public abstract Z3Formula getMonConst(String signalname, String position);

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
	public Z3Exp getSig(String signalname, String position) {
		return this.traceEncoder.getSig(signalname, position);	
	}
	


	public String defTimestamp() {
		return this.traceEncoder.defTimestamp();
	}
}
