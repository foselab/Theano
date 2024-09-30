package requirements2Z3.encodings.step;

import org.apache.commons.lang3.StringUtils;

import requirements2Z3.encodings.trace.TraceEncoder;
import requirements2Z3.z3formulae.Z3Formula;

public class FixedStepEncoder extends StepEncoder {

	private double ts;

	/**
	 * {@inheritDoc}
	 * 
	 * @param traceEncoder the trace encoding to be considered
	 * @param ts           the timestep to be considered by the finite step encoding
	 */
	public FixedStepEncoder(TraceEncoder traceEncoder, double ts) {
		super(traceEncoder);
		this.ts = ts;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Z3Formula getTracePositionMonotonicConstraint(String signalname, String position) {

		/*String nextPosition;
		try {
			nextPosition = String.valueOf(Integer.parseInt(position) + 1);
		} catch (NumberFormatException e) {
			nextPosition = position + " + 1";
		}

		return Z3Formula.getPredicate(
				Z3Formula.getExpression(this.getTraceEncoder().getTracePosition(signalname, nextPosition), "-",
						this.getTraceEncoder().getTracePosition(signalname, position)),
				Z3Formula.getRelationalOperator("=="), Z3Formula.getVariable(Double.toString(ts)));*/
		return Z3Formula.getPredicate(
				this.getTraceEncoder().getSig(signalname, position),
						Z3Formula.getRelationalOperator("=="),
						Z3Formula.getConstant(Double.toString(ts*Integer.parseInt(position))));

	}

}
