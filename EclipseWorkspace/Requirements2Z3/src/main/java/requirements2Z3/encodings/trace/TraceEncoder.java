package requirements2Z3.encodings.trace;

import requirements2Z3.z3formulae.Z3Expression;

public interface TraceEncoder {
	
	/**
	 * Returns the String that must be used to define the trace
	 * 
	 * @return the String that must be used to define the trace
	 */
	public abstract String defineTraceVariable();
	
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
	public abstract Z3Expression getTracePosition(String signalname, String position);

}
