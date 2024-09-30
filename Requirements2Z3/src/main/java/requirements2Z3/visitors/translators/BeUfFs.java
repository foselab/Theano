package requirements2Z3.visitors.translators;

import requirements2Z3.encodings.Encoder;
import requirements2Z3.rqt.DurFormula;
import requirements2Z3.rqt.Identifier;
import requirements2Z3.rqt.TimestampDefinition;
import requirements2Z3.z3formulae.Z3Expression;
import requirements2Z3.z3formulae.Z3Formula;

public class BeUfFs extends BoundedVisitor {

	private double ts;

	public BeUfFs(Encoder encoder, int bound, double ts) {
		super(encoder, bound);
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
	public Z3Formula visit(DurFormula dr) {
	
		Z3Expression constant = Z3Formula.getConstant(Double.toString(dr.getConstant()));

		Z3Formula part1 = Z3Formula.getPredicate(Z3Formula.getVariable("tau(i)"),Z3Formula.getRelationalOperator(">="),constant);
		Z3Formula part2 = Z3Formula.getPredicate(constant,Z3Formula.getRelationalOperator(dr.getOp().toString()), Z3Formula.getVariable("Ts"));

		Z3Formula part3 =Z3Formula.getTrue();

		int lb = (int) (this.getIndex() - Float.parseFloat(constant.toString()) / this.ts);

		int index=this.getIndex();
		//if(lb>=0) {
			for (int n = lb; n <= this.getIndex(); n++) {
				
				BeUfFs visitor=new BeUfFs(this.getEncoder(), n, this.ts);
				visitor.setIndex(n);
				part3 = Z3Formula.getAnd(part3,dr.getF().accept(visitor));
			}
		//}else {
		//	part3 =Z3Formula.getFalse();
		//}
		return part3;//Z3Formula.getAnd(part1,part2, part3);
	}

	@Override
	public Z3Formula visit(TimestampDefinition timestampDefinition) {
		return Z3Formula.getPredicate(Z3Formula.getVariable("Ts"),
				Z3Formula.getRelationalOperator("="),
				Z3Formula.getConstant(
						Double.toString(timestampDefinition.getConstant())));
	}
}
