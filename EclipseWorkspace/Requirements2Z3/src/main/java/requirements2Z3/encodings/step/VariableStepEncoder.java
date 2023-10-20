package requirements2Z3.encodings.step;

import requirements2Z3.encodings.trace.TraceEncoder;

public class VariableStepEncoder extends StepEncoder {

	public VariableStepEncoder(TraceEncoder traceEncoder) {
		super(traceEncoder);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getTracePositionMonotonicConstraint(String signalname, String position) {
		return this.getTraceEncoder().getTracePosition(signalname, position) + "<"
				+ this.getTraceEncoder().getTracePosition(signalname, position + " + 1");
	}

}
