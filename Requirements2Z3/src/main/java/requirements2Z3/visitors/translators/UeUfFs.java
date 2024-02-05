package requirements2Z3.visitors.translators;

import generated.matlabParser.Dur_expressionContext;
import generated.matlabVisitor;
import requirements2Z3.encodings.Encoder;
import requirements2Z3.z3formulae.Z3Expression;
import requirements2Z3.z3formulae.Z3Formula;

public class UeUfFs extends UnboundedVisitor implements matlabVisitor<Z3Formula> {

	public UeUfFs(Encoder encoder) {
		super(encoder);
	}

	@Override
	public Z3Formula visitDur_expression(Dur_expressionContext ctx) {

		Z3Expression constant = Z3Formula.getConstant(ctx.getChild(5).getText());

		Z3Formula part1 = 
				Z3Formula.getPredicate(
						Z3Formula.getVariable("tau[i]"), 
						Z3Formula.getRelationalOperator(">="), 
						constant);
		
		Z3Formula part2 = 
				Z3Formula.getPredicate(
				constant,
				Z3Formula.getRelationalOperator(">="),
				Z3Formula.getVariable("Ts"));
		
		Z3Formula part3 = 
				Z3Formula.getForAll(
						"k", 
						Z3Formula.getImplies(
								Z3Formula.getAnd(
										Z3Formula.getPredicate(
												Z3Formula.getVariable("i-" + constant + "/Ts"), 
												Z3Formula.getRelationalOperator("<="), 
												Z3Formula.getVariable("k")),
										Z3Formula.getPredicate(
												Z3Formula.getVariable("k"), 
												Z3Formula.getRelationalOperator("<="), 
												Z3Formula.getVariable("i"))), 
								ctx.getChild(2).accept(this)));

		return Z3Formula.getAnd( part1, part2, part3);

	}

}
