package requirements2Z3.factory;

import requirements2Z3.encodings.BoundedEncoder;
import requirements2Z3.encodings.step.VariableStepEncoder;
import requirements2Z3.encodings.trace.ArBasedEncoding;
import requirements2Z3.visitors.translators.BeArVs;

public class BeArVsFactory extends EncoderFactory  {

	public BeArVsFactory(int bound) {
		super(new BeArVs(new BoundedEncoder(new VariableStepEncoder(new ArBasedEncoding()), bound), bound));
	}
}