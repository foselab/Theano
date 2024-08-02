package requirements2Z3.rqt;

import requirements2Z3.visitors.RQTableVisitor;

public class UnaryExpression extends Expression {

	private final Expression exp;

	private final ArithmeticOperator op;

	public UnaryExpression(ArithmeticOperator op, Expression exp) {
		this.exp = exp;
		this.op = op;
	}

	public Expression getExp() {
		return exp;
	}

	public ArithmeticOperator getOp() {
		return op;
	}
	
	@Override
	public <T> T accept(RQTableVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
