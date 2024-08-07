package requirements2Z3.factory;

import requirements2Z3.encodings.BoundedEncoder;
import requirements2Z3.encodings.step.FixedStepEncoder;
import requirements2Z3.encodings.trace.ArBasedEncoding;
import requirements2Z3.visitors.translators.BeArFs;

public class BeArFsFactory extends EncoderFactory {

	public BeArFsFactory(int bound, double timestamp) {
		super(new BeArFs(new BoundedEncoder(new FixedStepEncoder(new ArBasedEncoding(), timestamp), bound), bound,
				timestamp));
	}

}
