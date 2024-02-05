package requirements2Z3.factory;

import requirements2Z3.encodings.UnboundedEncoder;
import requirements2Z3.encodings.step.FixedStepEncoder;
import requirements2Z3.encodings.trace.UfBasedEncoding;
import requirements2Z3.visitors.translators.UeUfFs;

public class UeUfFsFactory extends EncoderFactory {

	public UeUfFsFactory(float timestamp) {
		super(new UeUfFs(new UnboundedEncoder(new FixedStepEncoder(new UfBasedEncoding(), timestamp))));
	}
}
