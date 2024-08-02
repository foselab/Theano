package requirements2Z3.rqt;

import requirements2Z3.visitors.RQTableVisitor;

public class DurFormula extends PFormula {

	private final PFormula f;
	private final RelationalOperator op;
	private final double constant;
	
	public DurFormula(PFormula f, RelationalOperator op, double constant) {
		this.f=f;
		this.op=op;
		this.constant=constant;
	}

	public PFormula getF() {
		return f;
	}

	public RelationalOperator getOp() {
		return op;
	}

	public double getConstant() {
		return constant;
	}
	
	public <T> T accept(RQTableVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}
