package requirements2Z3.encodings.trace;

import requirements2Z3.z3formulae.Z3Exp;
import requirements2Z3.z3formulae.Z3Formula;

/**
 * Encoding based on Arrays
 */
public class ArBasedEncoding implements TraceEncoder {

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
	public Z3Exp getTracePosition(String signalname, String position) {
		return Z3Formula.getVariable(
				signalname + "[" + position + "]");
	}

}
