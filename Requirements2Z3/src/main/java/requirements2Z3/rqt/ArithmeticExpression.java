package requirements2Z3.rqt;

import requirements2Z3.visitors.RQTableVisitor;

public class ArithmeticExpression extends Expression {
	
	private final Expression left;
	private final Expression right;
	private final ArithmeticOperator op;
	
	public ArithmeticExpression(Expression left, ArithmeticOperator op, Expression right) {
		this.left=left;
		this.right=right;
		this.op=op;
	}

	public Expression getLeft() {
		return left;
	}

	public Expression getRight() {
		return right;
	}

	public ArithmeticOperator getOp() {
		return op;
	}
	public <T> T accept(RQTableVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
