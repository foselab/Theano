package requirements2Z3.encodings.trace;

import requirements2Z3.z3formulae.Z3Expression;
import requirements2Z3.z3formulae.Z3Formula;

/**
 * Encoding based on Arrays
 */
public class ArBasedEncoding implements TraceEncoder {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String defineTraceVariable() {
		return "tau = Array('tau', I, R)\n";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Z3Expression getTracePosition(String signalname, String position) {
		return Z3Formula.getVariable(
				signalname + "[" + position + "]");
	}

}
