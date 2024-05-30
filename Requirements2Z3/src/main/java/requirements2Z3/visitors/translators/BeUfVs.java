package requirements2Z3.visitors.translators;

import generated.matlabParser.Dur_expressionContext;
import generated.matlabVisitor;
import requirements2Z3.encodings.Encoder;
import requirements2Z3.z3formulae.Z3Expression;
import requirements2Z3.z3formulae.Z3Formula;

public class BeUfVs extends BoundedVisitor implements matlabVisitor<Z3Formula> {

	public BeUfVs(Encoder encoder, int index) {
		super(encoder, index);
	}

	@Override
	public Z3Formula visitDur_expression(Dur_expressionContext ctx) {

		Z3Expression constant = Z3Formula.getConstant(ctx.getChild(5).getText());

		Z3Formula part3 = Z3Formula.getTrue();
		for (int j = 0; j <= this.getIndex(); j++) {

			Z3Formula innerAnd = 
					Z3Formula.getPredicate(
							Z3Formula.getVariable("tau(" + this.getIndex() + ")-tau(" + j + ")"), 
							Z3Formula.getRelationalOperator(">="), 
							constant);
			for (int n = j; n <= this.getIndex(); n++) {
				innerAnd = Z3Formula.getAnd(innerAnd, ctx.getChild(2).accept(new BeUfVs(this.getEncoder(), n)));
				
			}
			part3 = Z3Formula.getAnd(part3, innerAnd);
		}
		return part3;
	}
}
