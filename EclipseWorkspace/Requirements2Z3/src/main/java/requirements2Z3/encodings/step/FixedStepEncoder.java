package requirements2Z3.encodings.step;

import org.apache.commons.lang3.StringUtils;

import requirements2Z3.encodings.trace.TraceEncoder;

public class FixedStepEncoder extends StepEncoder {

	private float ts;

	/**
	 * {@inheritDoc}
	 * 
	 * @param traceEncoder the trace encoding to be considered
	 * @param ts           the timestep to be considered by the finite step encoding
	 */
	public FixedStepEncoder(TraceEncoder traceEncoder, float ts) {
		super(traceEncoder);
		this.ts = ts;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getTracePositionMonotonicConstraint(String signalname, String position) {

		String nextPosition;
		if (StringUtils.isNumeric(position)) {
			nextPosition = String.valueOf(Integer.parseInt(position) + 1);
		} else {
			nextPosition = position + " + 1";
		}

		return this.getTraceEncoder().getTracePosition(signalname, nextPosition) + "-"
				+ this.getTraceEncoder().getTracePosition(signalname, position) + "==" + ts;

	}

}
