package requirements2Z3.z3formulae;

public abstract class Z3Expression extends Z3Formula {
	public abstract String toString();

}

class Variable extends Z3Expression {
	private final String variable;

	public Variable(String variable) {
		this.variable = variable;
	}

	@Override
	public String toString() {
		return variable;
	}
}

class Constant extends Z3Expression {
	private final String value;

	public Constant(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}
}

class ArithmeticExpression extends Z3Expression {
	private Z3Expression expression1;
	private String arithmeticOperator;
	private Z3Expression expression2;

	public ArithmeticExpression(Z3Expression expression1, String arithmeticOperator, Z3Expression expression2) {
		this.expression1 = expression1;
		this.arithmeticOperator = arithmeticOperator;
		this.expression2 = expression2;
	}

	@Override
	public String toString() {
		return this.expression1 + this.arithmeticOperator + this.expression2;
	}
}

class Z3UnaryExpression extends Z3Expression {
	private String arithmeticOperator;
	private Z3Expression expression2;

	public Z3UnaryExpression(String arithmeticOperator, Z3Expression expression2) {
		this.arithmeticOperator = arithmeticOperator;
		this.expression2 = expression2;
	}

	@Override
	public String toString() {
		return "("+this.arithmeticOperator + this.expression2+")";
	}
}

class RelationalOperator extends Z3Expression {
	private final String operator;

	public RelationalOperator(String operator) {
		this.operator = operator;
	}

	@Override
	public String toString() {
		if (operator.equals("~=")) {
			return "!=";
		}
		return operator;
	}
}