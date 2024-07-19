package requirements2Z3.encodings.trace;

import requirements2Z3.z3formulae.Z3Expression;
import requirements2Z3.z3formulae.Z3Formula;

/**
 * Encoding based on Arrays
 */
public class ArEncoder implements TraceEncoder {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String defTimestamp() {
		return "tau = Array('tau', I, R)\n";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Z3Expression getSignalValue(String signalname, String index) {
		return Z3Formula.getVariable(
				signalname + "[" + index + "]");
	}

}
