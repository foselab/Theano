package requirements2Z3.factory;

import requirements2Z3.encodings.UnboundedEncoder;
import requirements2Z3.encodings.step.VariableStepEncoder;
import requirements2Z3.encodings.trace.UfBasedEncoding;
import requirements2Z3.visitors.translators.UeUfVs;

public class UeUfVsFactory extends EncoderFactory {

	public UeUfVsFactory() {
		super(new UeUfVs(new UnboundedEncoder(new VariableStepEncoder(new UfBasedEncoding()))));
	}
}
