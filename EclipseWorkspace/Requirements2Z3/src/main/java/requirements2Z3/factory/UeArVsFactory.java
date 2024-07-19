package requirements2Z3.factory;

import requirements2Z3.encodings.UnboundedEncoder;
import requirements2Z3.encodings.step.VariableStepEncoder;
import requirements2Z3.encodings.trace.ArBasedEncoding;
import requirements2Z3.visitors.translators.UeArVs;

public class UeArVsFactory extends EncoderFactory {

	public UeArVsFactory() {
		super(new UeArVs(new UnboundedEncoder(new VariableStepEncoder(new ArEncoder()))));
	}
}
