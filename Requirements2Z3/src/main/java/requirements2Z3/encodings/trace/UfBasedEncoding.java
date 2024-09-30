package requirements2Z3.encodings.trace;

import requirements2Z3.z3formulae.Z3Exp;
import requirements2Z3.z3formulae.Z3Formula;

/**
 * Encoding based on Uninterpreted Functions
 */
public class UfBasedEncoding implements TraceEncoder {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String defTimestamp() {
		return "tau = Function('tau', IntSort(), RealSort())\n";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Z3Exp getTracePosition(String signalname, String position) {
		if (signalname.equals("tau")) {
			return Z3Formula.getVariable(signalname + "(" + position + ")");
		} else {
			return Z3Formula.getVariable(signalname + "[" + position + "]");
		}
	}

}
