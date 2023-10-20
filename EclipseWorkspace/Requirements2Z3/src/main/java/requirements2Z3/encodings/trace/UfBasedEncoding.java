package requirements2Z3.encodings.trace;

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
	public String getTracePosition(String signalname, String position) {
		return signalname + "(" + position + ")";
	}

}
