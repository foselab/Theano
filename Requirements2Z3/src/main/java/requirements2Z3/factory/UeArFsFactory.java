package requirements2Z3.factory;

import requirements2Z3.encodings.UnboundedEncoder;
import requirements2Z3.encodings.step.FixedStepEncoder;
import requirements2Z3.encodings.trace.ArBasedEncoding;
import requirements2Z3.visitors.translators.UeArFs;

public class UeArFsFactory extends EncoderFactory {

	public UeArFsFactory(float timestamp) {
		super(new UeArFs(new UnboundedEncoder(new FixedStepEncoder(new ArBasedEncoding(), timestamp))));
	}
}
