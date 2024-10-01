package requirements2Z3.encodings.step;

import requirements2Z3.encodings.trace.TraceEncoder;
import requirements2Z3.z3formulae.Z3Formula;

public class VariableStepEncoder extends StepEncoder {

	public VariableStepEncoder(TraceEncoder traceEncoder) {
		super(traceEncoder);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Z3Formula getMonConst(String signalname, String position) {
		String nextPosition;
		try {
			nextPosition = String.valueOf(Integer.parseInt(position) + 1);
		} catch (NumberFormatException e) {
			nextPosition = position + " + 1";
		}

		return Z3Formula.getPredicate(this.traceEncoder.getSig(signalname, position),
				Z3Formula.getRelationalOperator("<"),
				this.traceEncoder.getSig(signalname, nextPosition));
	}

}
