package requirements2Z3.encodings;

import requirements2Z3.encodings.step.StepEncoder;

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
		return this.stepEncoder.defineTraceVariable();
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
	public String getTracePosition(String signalname, String position) {
		return this.stepEncoder.getTracePosition(signalname, position);
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
	public String getIsStartup(String signalname, String position) {
		return this.stepEncoder.getIsStartup(signalname, position);
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
		return this.stepEncoder.getPrevValue(signalname, position);
	}

}
