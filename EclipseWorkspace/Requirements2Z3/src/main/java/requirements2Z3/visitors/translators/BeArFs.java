package requirements2Z3.visitors.translators;

import generated.matlabParser.Dur_expressionContext;
import generated.matlabVisitor;
import requirements2Z3.encodings.Encoder;


/**
* This class represents the Bounded Encoding  based on arrays, finite step
* 
* @author  Claudio Menghi
* @version 1.0
* @since   2023-10-03
*/
public class BeArFs extends BoundedVisitor implements matlabVisitor<String> {

	

	private float ts;

	/*
	 * 
	 */
	public BeArFs(Encoder encoder, int index, float ts) {
		super(encoder,index);
		this.ts = ts;
	}

	

	@Override
	public String visitDur_expression(Dur_expressionContext ctx) {

		String constant = ctx.getChild(5).getText();

		String part1 = "tau[i]>=" + constant;
		String part2 = constant + ">=Ts";

		String part3 = "And(";

		int lb = (int) (this.getIndex() - Float.parseFloat(constant) / this.ts);

		for (int n = lb; n <= this.getIndex(); n++) {
			part3 = part3 + ctx.getChild(2).accept(new BeArFs(this.getEncoder(),n, this.ts));
			if (n != this.getIndex()) {
				part3 = part3 + ",";
			}
		}
		part3 = part3 + ")";

		return "And(" + part1 + "," + part2 + "," + part3 + ")";
	}

	


	
}
