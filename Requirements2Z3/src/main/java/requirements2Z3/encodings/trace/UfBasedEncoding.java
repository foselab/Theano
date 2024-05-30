package requirements2Z3.encodings.trace;

import requirements2Z3.z3formulae.Z3Expression;
import requirements2Z3.z3formulae.Z3Formula;

/**
 * Encoding based on Uninterpreted Functions
 */
public class UfBasedEncoding implements TraceEncoder {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String defineTraceVariable() {
		return "tau = Function('tau', IntSort(), RealSort())\n";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Z3Expression getTracePosition(String signalname, String position) {
		if (signalname.equals("tau")) {
			return Z3Formula.getVariable(signalname + "(" + position + ")");
		} else {
			return Z3Formula.getVariable(signalname + "[" + position + "]");
		}
	}

}
