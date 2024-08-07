package requirements2Z3.visitors.translators;

import requirements2Z3.encodings.Encoder;
import requirements2Z3.rqt.DurFormula;
import requirements2Z3.rqt.Identifier;
import requirements2Z3.rqt.TimestampDefinition;
import requirements2Z3.z3formulae.Z3Expression;
import requirements2Z3.z3formulae.Z3Formula;

public class UeUfVs extends UnboundedVisitor  {

	public UeUfVs(Encoder encoder) {
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
	public Z3Formula visit(DurFormula durFormula) {
		
		Z3Expression constant = Z3Formula.getConstant(Double.toString(durFormula.getConstant()));
		return Z3Formula.getExists("j", Z3Formula.getAnd(
				Z3Formula.getPredicate(Z3Formula.getVariable("j"), Z3Formula.getRelationalOperator("<="),
						Z3Formula.getVariable("i")),
				Z3Formula.getPredicate(Z3Formula.getVariable("tau[i]-tau[j]"), Z3Formula.getRelationalOperator(">="),
						constant),
				Z3Formula.getForAll("k",
						Z3Formula.getImplies(
								Z3Formula.getAnd(
										Z3Formula.getPredicate(Z3Formula.getVariable("j"),
												Z3Formula.getDualOperator(durFormula.getOp().toString()), Z3Formula.getVariable("k")),
										Z3Formula.getPredicate(Z3Formula.getVariable("k"),
												Z3Formula.getDualOperator(durFormula.getOp().toString()), Z3Formula.getVariable("i"))),
								durFormula.getF().accept(this)))));
	}
	
	@Override
	public Z3Formula visit(TimestampDefinition timestampDefinition) {
		throw new UnsupportedOperationException();
	}
}
