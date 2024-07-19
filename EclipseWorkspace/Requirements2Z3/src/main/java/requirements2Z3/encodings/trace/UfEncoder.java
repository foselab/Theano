package requirements2Z3.encodings.trace;

import requirements2Z3.z3formulae.Z3Expression;
import requirements2Z3.z3formulae.Z3Formula;

/**
 * Encoding based on Uninterpreted Functions
 */
public class UfEncoder implements TraceEncoder {

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
	public Z3Expression getSignalValue(String signalname, String index) {
		if (signalname.equals("tau")) {
			return Z3Formula.getVariable(signalname + "(" + index + ")");
		} else {
			return Z3Formula.getVariable(signalname + "[" + index + "]");
		}
	}

}