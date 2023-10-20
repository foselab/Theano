package requirements2Z3.encodings.step;

import org.apache.commons.lang3.StringUtils;

import requirements2Z3.encodings.trace.TraceEncoder;

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
	public abstract String getTracePositionMonotonicConstraint(String signalname, String position);

	/**
	 * Returns a string representing a condition that is true if a specific position
	 * of the trace is the first position of the trace, false otherwise
	 * 
	 * @param signalname the name of the signal
	 * @param position   the position to be considered
	 * @return a String that represents the Z3 encoding accessing the trace in that
	 *         position.
	 */
	public String getIsStartup(String signalname, String position) {
		if (StringUtils.isNumeric(position)) {
			int index = Integer.parseInt(position);
			if (index == 0) {
				return "True";
			} else {
				return "False";
			}
		} else {
			return this.getTraceEncoder().getTracePosition("tau", position) + "==0";
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
	public String getPrevValue(String signalname, String position) {
		if (StringUtils.isNumeric(position)) {
			int index = Integer.parseInt(position);
			if (index == 0) {
				return this.getTraceEncoder().getTracePosition(signalname, position);
			} else {
				return this.getTraceEncoder().getTracePosition(signalname, position+"-1");
			}		
		} else {
			StringBuilder b = new StringBuilder();

			b.append("((" + position + "==0)*(" + this.getTraceEncoder().getTracePosition(signalname, position) + ")+("
					+ position + ">0)*(" + this.getTraceEncoder().getTracePosition(signalname, position + "-1") + "))");
			return b.toString();

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
	public String getTracePosition(String signalname, String position) {
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
