package requirements2Z3.visitors.translators;

import requirements2Z3.encodings.Encoder;
import requirements2Z3.rqt.DurFormula;
import requirements2Z3.rqt.TimestampDefinition;
import requirements2Z3.z3formulae.Z3Expression;
import requirements2Z3.z3formulae.Z3Formula;


/**
* This class represents the Bounded Encoding  based on arrays, finite step
* 
* @author  Claudio Menghi
* @version 1.0
* @since   2023-10-03
*/
public class BeArFs extends BoundedVisitor  {

	private double ts;

	/*
	 * 
	 */
	public BeArFs(Encoder encoder, int index, double ts) {
		super(encoder,index);
		this.ts = ts;
	}
	
	@Override
	public Z3Formula visit(DurFormula dr) {

		Z3Expression constant = Z3Formula.getConstant(Double.toString(dr.getConstant()));

		Z3Formula part1 = Z3Formula.getPredicate(Z3Formula.getVariable("tau[i]"),Z3Formula.getRelationalOperator(">="),constant);
		Z3Formula part2 = Z3Formula.getPredicate(constant,Z3Formula.getRelationalOperator(dr.getOp().toString()),Z3Formula.getVariable("Ts"));

		Z3Formula part3 = Z3Formula.getTrue();

		int lb = (int) (this.getIndex() - Float.parseFloat(constant.toString()) / this.ts);

		for (int n = lb; n <= this.getIndex(); n++) {
			part3 = Z3Formula.getAnd(part3,dr.getF().accept(new BeArFs(this.getEncoder(),n, this.ts)));
		}

		return Z3Formula.getAnd(part1,part2,part3);
	}

	@Override
	public Z3Formula visit(TimestampDefinition timestampDefinition) {
		return Z3Formula.getPredicate(Z3Formula.getVariable("Ts"),
				Z3Formula.getRelationalOperator("="),
				Z3Formula.getConstant(
						Double.toString(timestampDefinition.getConstant())));
	}
}
