package requirements2Z3.visitors.translators;

import requirements2Z3.encodings.Encoder;
import requirements2Z3.rqt.DurFormula;
import requirements2Z3.rqt.Identifier;
import requirements2Z3.rqt.TimestampDefinition;
import requirements2Z3.z3formulae.Z3Exp;
import requirements2Z3.z3formulae.Z3Formula;

public class UeUfFs extends UnboundedVisitor {

	public UeUfFs(Encoder encoder) {
		super(encoder);
	}
	
	@Override
	public Z3Formula visit(Identifier identifier) {
		if (identifier.equals("tau")) {
			return Z3Formula.getVariable("tau(i)");
		} else {
			return super.visit(identifier); 		
		}

	}

	@Override
	public Z3Formula visit(DurFormula dr) {

		Z3Exp constant = Z3Formula.getConstant(Double.toString(dr.getConstant()));

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
												Z3Formula.getDualOperator(dr.getOp().toString()), 
												Z3Formula.getVariable("k")),
										Z3Formula.getPredicate(
												Z3Formula.getVariable("k"), 
												Z3Formula.getDualOperator(dr.getOp().toString()), 
												Z3Formula.getVariable("i"))), 
								dr.getF().accept(this)));

		return Z3Formula.getAnd( part1, part2, part3);

	}
	@Override
	public Z3Formula visit(TimestampDefinition timestampDefinition) {
		return Z3Formula.getPredicate(Z3Formula.getVariable("Ts"),
				Z3Formula.getRelationalOperator("="),
				Z3Formula.getConstant(
						Double.toString(timestampDefinition.getConstant())));
	}
}
