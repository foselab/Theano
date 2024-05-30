package requirements2Z3.factory;

import requirements2Z3.encodings.BoundedEncoder;
import requirements2Z3.encodings.step.VariableStepEncoder;
import requirements2Z3.encodings.trace.UfBasedEncoding;
import requirements2Z3.visitors.translators.BeUfVs;

public class BeUfVsFactory extends EncoderFactory {

	public BeUfVsFactory(int bound) {
		super(new BeUfVs(new BoundedEncoder(new VariableStepEncoder(new UfBasedEncoding()), bound), bound));
	}
}
