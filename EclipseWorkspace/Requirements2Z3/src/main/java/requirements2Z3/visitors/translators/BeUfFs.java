package requirements2Z3.visitors.translators;

import generated.matlabParser.Dur_expressionContext;
import generated.matlabVisitor;
import requirements2Z3.encodings.Encoder;

public class BeUfFs extends BoundedVisitor implements matlabVisitor<String> {

	private float ts;

	public BeUfFs(Encoder encoder, int index, float ts) {
		super(encoder, index);
		this.ts = ts;
	}
	@Override
	public String visitDur_expression(Dur_expressionContext ctx) {

		String constant = ctx.getChild(5).getText();

		String part1 = "tau(i)>=" + constant;
		String part2 = constant + ">=Ts";

		String part3 = "And(";

		int lb = (int) (this.getIndex() - Float.parseFloat(constant) / this.ts);

		for (int n = lb; n <= this.getIndex(); n++) {
			part3 = part3 + ctx.getChild(2).accept(new BeUfFs(this.getEncoder(), n, this.ts));
			if (n != this.getIndex()) {
				part3 = part3 + ",";
			}
		}
		part3 = part3 + ")";

		return "And(" + part1 + "," + part2 + "," + part3 + ")";
	}
}
