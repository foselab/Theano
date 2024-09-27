package requirements2Z3.factory;

import requirements2Z3.encodings.Encoder;
import requirements2Z3.visitors.translators.RT2Z3Visitor;

public abstract class EncoderFactory {

	private final Encoder encoder;
	private final RT2Z3Visitor visitor;

	protected EncoderFactory(RT2Z3Visitor visitor) {
		this.visitor = visitor;
		this.encoder = visitor.getEncoder();
	}

	/**
	 * Creates the encoder to be used in the translation
	 */
	public Encoder getEncoder() {
		return this.encoder;
	}

	/**
	 * Creates the visitor to be used in the translation
	 */
	public RT2Z3Visitor getVisitor() {
		return this.visitor;
	}
}
