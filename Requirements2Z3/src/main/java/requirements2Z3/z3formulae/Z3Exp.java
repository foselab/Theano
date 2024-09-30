package requirements2Z3.z3formulae;

public abstract class Z3Exp extends Z3Formula {
	public abstract String toString();

}

class Variable extends Z3Exp {
	private final String variable;

	public Variable(String variable) {
		this.variable = variable;
	}

	@Override
	public String toString() {
		return variable;
	}
}

class Constant extends Z3Exp {
	private final String value;

	public Constant(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}
}

class ArithmeticExpression extends Z3Exp {
	private Z3Exp expression1;
	private String arithmeticOperator;
	private Z3Exp expression2;

	public ArithmeticExpression(Z3Exp expression1, String arithmeticOperator, Z3Exp expression2) {
		this.expression1 = expression1;
		this.arithmeticOperator = arithmeticOperator;
		this.expression2 = expression2;
	}

	@Override
	public String toString() {
		return this.expression1 + this.arithmeticOperator + this.expression2;
	}
}

class Z3UnaryExpression extends Z3Exp {
	private String arithmeticOperator;
	private Z3Exp expression2;

	public Z3UnaryExpression(String arithmeticOperator, Z3Exp expression2) {
		this.arithmeticOperator = arithmeticOperator;
		this.expression2 = expression2;
	}

	@Override
	public String toString() {
		return "("+this.arithmeticOperator + this.expression2+")";
	}
}

class RelationalOperator extends Z3Exp {
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