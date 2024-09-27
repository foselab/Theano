package requirements2Z3.visitors.translators;

import requirements2Z3.encodings.Encoder;
import requirements2Z3.rqt.AndFormula;
import requirements2Z3.rqt.ArithmeticExpression;
import requirements2Z3.rqt.Constant;
import requirements2Z3.rqt.NegationFormula;
import requirements2Z3.rqt.OrFormula;
import requirements2Z3.rqt.RQTable;
import requirements2Z3.rqt.RelationalExpression;
import requirements2Z3.rqt.Requirement;
import requirements2Z3.rqt.Requirements;
import requirements2Z3.rqt.True;
import requirements2Z3.rqt.UnaryExpression;
import requirements2Z3.rqt.Variables;
import requirements2Z3.visitors.RQTableVisitor;
import requirements2Z3.z3formulae.Z3Expression;
import requirements2Z3.z3formulae.Z3Formula;

public abstract class Table2Z3Visitor implements RQTableVisitor<Z3Formula> {

	
	private final Encoder encoder;

	public Table2Z3Visitor(Encoder encoder) {
		this.encoder = encoder;
	}

	
	public Encoder getEncoder() {
		return encoder;
	}
	
	@Override
	public Z3Formula visit(Constant constant) {
		return Z3Formula.getConstant(Double.toString(constant.getConstant()));
	}

	@Override
	public Z3Formula visit(AndFormula andFormula) {
		return Z3Formula.getAnd(andFormula.getLeft().accept(this),andFormula.getRight().accept(this));
	}
	
	@Override
	public Z3Expression visit(ArithmeticExpression arithmeticExpression) {
		return  Z3Formula.getExpression(
				(Z3Expression) arithmeticExpression.getLeft().accept(this), 
				arithmeticExpression.getOp().getOperator(), 
				(Z3Expression) arithmeticExpression.getRight().accept(this));
	}
	
	@Override
	public Z3Formula visit(NegationFormula negationFormula) {
		return Z3Formula.getNot(negationFormula.getF().accept(this));
	}

	@Override
	public Z3Formula visit(OrFormula orFormula) {
		return Z3Formula.getOr(orFormula.getLeft().accept(this),orFormula.getRight().accept(this));
	}

	@Override
	public Z3Formula visit(RelationalExpression relationalExpression) {
		return Z3Formula.getPredicate((Z3Expression) relationalExpression.getExp1().accept(this), Z3Formula.getRelationalOperator(relationalExpression.getOp().toString()), (Z3Expression)relationalExpression.getExp2().accept(this));
	}
		
	@Override
	public Z3Formula visit(Requirement requirement) {
		return Z3Formula.getImplies(requirement.getPrecondition().accept(this),requirement.getPostcondition().accept(this));
	}
	
	@Override
	public Z3Formula visit(True true1) {
		return Z3Formula.getTrue();
	}

	@Override
	public Z3Expression visit(UnaryExpression unaryExpression) {
		return Z3Formula.getZ3UnaryExpression(unaryExpression.getOp().toString(),(Z3Expression) unaryExpression.getExp().accept(this));
	}

	@Override
	public Z3Formula visit(Variables variables) {
		throw new IllegalArgumentException("Method not available");
	}

	@Override
	public Z3Formula visit(RQTable rqTable) {
		return rqTable.getRequirements().accept(this);	
	}

	@Override
	public Z3Formula visit(Requirements requirements) {
		Z3Formula f = Z3Formula.getTrue();
		
		for(Requirement rq: requirements.getRequirements()) {
			f = Z3Formula.getAnd(f,rq.accept(this));
		}
		return f;
	}
}