package requirements2Z3.visitors.translators;

import generated.matlabParser.Dur_expressionContext;
import generated.matlabVisitor;
import requirements2Z3.encodings.Encoder;
import requirements2Z3.z3formulae.Z3Expression;
import requirements2Z3.z3formulae.Z3Formula;

public class BeUfFs extends BoundedVisitor implements matlabVisitor<Z3Formula> {

	private float ts;

	public BeUfFs(Encoder encoder, int index, float ts) {
		super(encoder, index);
		this.ts = ts;
	}
	@Override
	public Z3Formula visitDur_expression(Dur_expressionContext ctx) {

		Z3Expression constant = Z3Formula.getConstant(ctx.getChild(5).getText());

		Z3Formula part1 = Z3Formula.getPredicate(Z3Formula.getVariable("tau(i)"),Z3Formula.getRelationalOperator(">="),constant);
		Z3Formula part2 = Z3Formula.getPredicate(constant,Z3Formula.getRelationalOperator(">="), Z3Formula.getVariable("Ts"));

		Z3Formula part3 =Z3Formula.getTrue();

		int lb = (int) (this.getIndex() - Float.parseFloat(constant.toString()) / this.ts);

		for (int n = lb; n <= this.getIndex(); n++) {
			part3 = Z3Formula.getAnd(part3,ctx.getChild(2).accept(new BeUfFs(this.getEncoder(), n, this.ts)));
		}
		return Z3Formula.getAnd(part1,part2, part3);
	}
}
