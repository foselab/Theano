package requirements2Z3.visitors.translators;

import requirements2Z3.encodings.Encoder;
import requirements2Z3.rqt.DurFormula;
import requirements2Z3.rqt.Identifier;
import requirements2Z3.rqt.TimestampDefinition;
import requirements2Z3.z3formulae.Z3Expression;
import requirements2Z3.z3formulae.Z3Formula;

public class BeUfFs extends BoundedVisitor {

	private double ts;

	public BeUfFs(Encoder encoder, int index, double ts) {
		super(encoder, index);
		this.ts = ts;
	}
	
	@Override
	public Z3Formula visit(Identifier identifier) {
		if (identifier.equals("tau")) {
			return Z3Formula.getVariable("tau("+this.getIndex()+")");
		} else {
			return super.visit(identifier); 		
		}

	}
	
	@Override
	public Z3Formula visit(DurFormula durFormula) {
	
		Z3Expression constant = Z3Formula.getConstant(Double.toString(durFormula.getConstant()));

		Z3Formula part1 = Z3Formula.getPredicate(Z3Formula.getVariable("tau(i)"),Z3Formula.getRelationalOperator(">="),constant);
		Z3Formula part2 = Z3Formula.getPredicate(constant,Z3Formula.getRelationalOperator(durFormula.getOp().toString()), Z3Formula.getVariable("Ts"));

		Z3Formula part3 =Z3Formula.getTrue();

		int lb = (int) (this.getIndex() - Float.parseFloat(constant.toString()) / this.ts);

		for (int n = lb; n <= this.getIndex(); n++) {
			part3 = Z3Formula.getAnd(part3,durFormula.getF().accept(new BeUfFs(this.getEncoder(), n, this.ts)));
		}
		return Z3Formula.getAnd(part1,part2, part3);
	}

	@Override
	public Z3Formula visit(TimestampDefinition timestampDefinition) {
		return Z3Formula.getPredicate(Z3Formula.getVariable("Ts"),
				Z3Formula.getRelationalOperator("="),
				Z3Formula.getConstant(
						Double.toString(timestampDefinition.getConstant())));
	}
}
