package requirements2Z3.factory;

import requirements2Z3.encodings.BoundedEncoder;
import requirements2Z3.encodings.step.FixedStepEncoder;
import requirements2Z3.encodings.trace.UfBasedEncoding;
import requirements2Z3.visitors.translators.BeUfFs;


public class BeUfFsFactory extends EncoderFactory {

	public BeUfFsFactory(int bound, float timestamp) {
		super(new BeUfFs(new BoundedEncoder(new FixedStepEncoder(new UfBasedEncoding(), timestamp), bound), bound, timestamp));
	}
}
