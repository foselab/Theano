package requirements2Z3.encodings.trace;

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
	public String getTracePosition(String signalname, String position) {
		return signalname + "[" + position + "]";
	}

}
