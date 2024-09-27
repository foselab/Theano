package requirements2Z3.rqt;

import requirements2Z3.visitors.RTVisitor;

public class RelationalExpression extends PFormula {

	private final Expression exp1;
	private final RelationalOperator op;
	private final Expression exp2;
	
	public RelationalExpression(Expression exp1, RelationalOperator op, Expression exp2) {
		this.exp1=exp1;
		this.op=op;
		this.exp2=exp2;
	}

	public Expression getExp1() {
		return exp1;
	}

	public RelationalOperator getOp() {
		return op;
	}

	public Expression getExp2() {
		return exp2;
	}
	
	public <T> T accept(RTVisitor<T> visitor) {
		return visitor.visit(this);
	}
	
}
