package requirements2Z3.z3formulae;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public abstract class Z3Formula {

	private static True z3true = new True();
	private static False z3false = new False();
	private static Empty empty = new Empty();

	public abstract String toString();

	public static Z3Expression getEmpty() {
		return empty;
	}

	public static Z3Formula getTrue() {
		return z3true;
	}

	public static Z3Expression getZ3UnaryExpression(String arithmeticOperator, Z3Expression expression2) {
		return new Z3UnaryExpression(arithmeticOperator, expression2);
	}

	public static Z3Formula getFalse() {
		return z3false;
	}

	public static Predicate getPredicate(Z3Expression expression1, RelationalOperator operator,
			Z3Expression expression2) {
		return new Predicate(expression1, operator, expression2);
	}

	public static Z3Formula getNot(Z3Formula f) {
		if (f == null) {
			throw new NullPointerException("NOT: The formula f1 can not be null");
		}
		if (f instanceof True) {
			return getFalse();
		}
		if (f instanceof False) {
			return getTrue();
		}
		if (f instanceof Not) {
			Not f1=((Not) f);
			return f1.getSubformula();
		}
		return new Not(f);
	}

	public static Z3Formula getAnd(Z3Formula f1, Z3Formula f2) {
		if (f1 == null) {
			throw new NullPointerException("AND: The formula f1 can not be null");
		}
		if (f2 == null) {
			throw new NullPointerException("AND: The formula f2 can not be null");
		}
		if (f1 instanceof False || f2 instanceof False) {
			return getFalse();
		}
		if (f1 instanceof True) {
			return f2;
		}
		if (f2 instanceof True) {
			return f1;
		}
		if (f1 instanceof And) {
			And f = (And) f1;
			f.addFormula(f2);
			return f;
		}
		if (f2 instanceof And) {
			And f = (And) f2;
			f.addFormula(f1);
			return f;
		}
		return new And(f1, f2);
	}

	public static Z3Formula getAnd(Z3Formula... formulae) {
		if (formulae == null) {
			throw new NullPointerException("AND: The formula f1 can not be null");
		}
		if (formulae.length == 1) {
			return formulae[0];
		}
		for (Z3Formula formula : formulae) {
			if (formula instanceof False) {
				return getFalse();
			}
		}
		return new And(formulae);
	}

	public static Z3Formula getOr(Z3Formula f1, Z3Formula f2) {
		if (f1 == null) {
			throw new NullPointerException("OR: The formula f1 can not be null");
		}
		if (f2 == null) {
			throw new NullPointerException("OR: The formula f2 can not be null");
		}
		if (f1 instanceof True || f2 instanceof True) {
			return getTrue();
		}
		if (f1 instanceof False) {
			return f2;
		}
		if (f2 instanceof False) {
			return f1;
		}
		if (f1 instanceof Or) {
			Or f = (Or) f1;
			f.addFormula(f2);
			return f;
		}
		if (f2 instanceof Or) {
			Or f = (Or) f2;
			f.addFormula(f1);
			return f;
		}
		return new Or(f1, f2);
	}

	public static Z3Formula getImplies(Z3Formula f1, Z3Formula f2) {
		if (f1 == null) {
			throw new NullPointerException("IMPLIES: The formula f1 can not be null");
		}
		if (f2 == null) {
			throw new NullPointerException("IMPLIES: The formula f2 can not be null");
		}
		if (f1 instanceof False) {
			return getTrue();
		}
		if (f1 instanceof True) {
			return f2;
		}
		if (f2 instanceof False) {
			return Z3Formula.getNot(f1);
		}
		return new Implies(f1, f2);
	}

	public static Z3Formula getForAll(String indexVariable, Z3Formula subformula) {
		return new ForAll(indexVariable, subformula);
	}

	public static Z3Formula getExists(String indexVariable, Z3Formula subformula) {
		return new Exists(indexVariable, subformula);
	}

	public static RelationalOperator getRelationalOperator(String operator) {
		return new RelationalOperator(operator);
	}

	public static RelationalOperator getDualOperator(String operator) {
		switch (operator) {
		case "<=":
			return new RelationalOperator(">=");
		case ">=":
			return new RelationalOperator("<=");
		case "<":
			return new RelationalOperator(">");
		case ">":
			return new RelationalOperator("<");
		case "=":
			return new RelationalOperator("!=");
		default:
			throw new IllegalArgumentException("Operator: " + operator + " not supported ");
		}
	}

	public static Z3Expression getConstant(String value) {
		return new Constant(value);
	}

	public static Z3Expression getVariable(String variable) {
		return new Variable(variable);
	}

	public static Z3Expression getExpression(Z3Expression expression1, String arithmeticOperator,
			Z3Expression expression2) {
		return new ArithmeticExpression(expression1, arithmeticOperator, expression2);
	}

}

class Empty extends Z3Expression {

	@Override
	public String toString() {
		return "Empty";
	}

}

class And extends Z3Formula {
	private Set<Z3Formula> subformulae;

	public And(Z3Formula... formulae) {
		subformulae = new LinkedHashSet<Z3Formula>(Arrays.asList(formulae));
	}

	public And(Z3Formula f1, Z3Formula f2) {
		this.subformulae = new LinkedHashSet<>();
		this.subformulae.add(f1);
		this.subformulae.add(f2);
	}

	public Z3Formula addFormula(Z3Formula subformula) {
		this.subformulae.add(subformula);
		return this;
	}

	@Override
	public String toString() {

		boolean first = true;
		String ret = "";
		for (Z3Formula formula : subformulae) {
			if (first) {
				ret = formula.toString();
				first = false;
			} else {
				ret = ret + "," + formula.toString();
			}
		}
		return "And(" + ret + ")";
	}
}

class Or extends Z3Formula {
	private Set<Z3Formula> subformulae;

	public Or(Z3Formula f1, Z3Formula f2) {
		this.subformulae = new LinkedHashSet<>();
		this.subformulae.add(f1);
		this.subformulae.add(f2);
	}

	public Z3Formula addFormula(Z3Formula subformula) {
		this.subformulae.add(subformula);
		return this;
	}

	@Override
	public String toString() {
		boolean first = true;
		String ret = "";
		for (Z3Formula formula : subformulae) {
			if (first) {
				ret = formula.toString();
				first = false;
			} else {
				ret = ret + "," + formula.toString();
			}
		}
		return "Or(" + ret + ")";
	}
}

class Implies extends Z3Formula {
	private Z3Formula f1;
	private Z3Formula f2;

	public Implies(Z3Formula f1, Z3Formula f2) {
		this.f1 = f1;
		this.f2 = f2;
	}

	@Override
	public String toString() {
		return "Implies(" + f1 + "," + f2 + ")";
	}
}

class Not extends Z3Formula {
	private Z3Formula subformula;

	public Not(Z3Formula subformula) {
		this.subformula = subformula;
	}

	public Z3Formula getSubformula() {
		return this.subformula;
	}
	
	@Override
	public String toString() {
		return "Not(" + subformula.toString() + ")";
	}
}

class Exists extends Z3Formula {
	private Z3Formula subformula;
	private String indexVariable;

	public Exists(String indexVariable, Z3Formula subformula) {
		this.subformula = subformula;
		this.indexVariable = indexVariable;
	}

	@Override
	public String toString() {
		return "Exists(" + this.indexVariable + "," + subformula + ")";
	}
}

class ForAll extends Z3Formula {
	private Z3Formula subformula;
	private String indexVariable;

	public ForAll(String indexVariable, Z3Formula subformula) {
		this.subformula = subformula;
		this.indexVariable = indexVariable;
	}

	@Override
	public String toString() {
		return "ForAll(" + this.indexVariable + "," + subformula + ")";
	}
}

class True extends Z3Formula {

	@Override
	public String toString() {
		return "True";
	}

}

class False extends Z3Formula {

	@Override
	public String toString() {
		return "False";
	}

}

class Predicate extends Z3Formula {
	private final Z3Expression expression1;
	private final RelationalOperator operator;
	private final Z3Expression expression2;

	public Predicate(Z3Expression expression1, RelationalOperator operator, Z3Expression expression2) {
		this.expression1 = expression1;
		this.operator = operator;
		this.expression2 = expression2;
	}

	@Override
	public String toString() {
		return expression1.toString() + operator.toString() + expression2.toString();
	}
}
