package requirements2Z3.visitors.translators;

import generated.matlabParser.Dur_expressionContext;
import generated.matlabVisitor;
import requirements2Z3.encodings.Encoder;

public class BeArVs extends BoundedVisitor implements matlabVisitor<String> {

	public BeArVs(Encoder encoder, int index) {
		super(encoder, index);
	}

	@Override
	public String visitDur_expression(Dur_expressionContext ctx) {

		String constant = ctx.getChild(5).getText();

		String part3 = "And(";
		for (int j = 0; j <= this.getIndex(); j++) {

			String innerAnd = "And(";

			innerAnd = innerAnd + "tau[" + this.getIndex() + "]-tau[" + j + "]>=" + constant + ",";
			String nAnd = "And(";
			for (int n = j; n <= this.getIndex(); n++) {
				nAnd = nAnd + ctx.getChild(2).accept(new BeArVs(this.getEncoder(), n));
				if (n != this.getIndex()) {
					nAnd = nAnd + ",";
				}
			}
			nAnd = nAnd + ")";

			innerAnd = nAnd + ")";
			part3 = part3 + innerAnd;
			if (j != this.getIndex()) {
				part3 = part3 + ",";
			}
		}
		part3 = part3 + ")";

		return part3;
	}
}
