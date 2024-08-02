package requirements2Z3.visitors.translators;

import requirements2Z3.encodings.Encoder;
import requirements2Z3.rqt.DurFormula;
import requirements2Z3.z3formulae.Z3Expression;
import requirements2Z3.z3formulae.Z3Formula;

public class BeArVs extends BoundedVisitor {

	public BeArVs(Encoder encoder, int index) {
		super(encoder, index);
	}

	@Override
	public Z3Formula visit(DurFormula durFormula) {

		Z3Expression constant = Z3Formula.getConstant(Double.toString(durFormula.getConstant()));

		Z3Formula part3 = Z3Formula.getTrue();
		for (int j = 0; j <= this.getIndex(); j++) {

			Z3Formula innerAnd = Z3Formula.getTrue();

			innerAnd = Z3Formula.getAnd(innerAnd,
					Z3Formula.getPredicate(
							Z3Formula.getExpression(Z3Formula.getVariable("tau[" + this.getIndex() + "]"), "-",
									Z3Formula.getVariable("tau[" + j + "]")),
							Z3Formula.getRelationalOperator(durFormula.getOp().toString()), constant));
			for (int n = j; n <= this.getIndex(); n++) {
				innerAnd = Z3Formula.getAnd(innerAnd, durFormula.getF().accept(new BeArVs(this.getEncoder(), n)));
			}
			part3 = Z3Formula.getAnd(part3, innerAnd);
		}
		return part3;
	}
}
