package requirements2Z3.visitors;

import java.util.Set;

import requirements2Z3.rqt.AndFormula;
import requirements2Z3.rqt.ArithmeticExpression;
import requirements2Z3.rqt.Constant;
import requirements2Z3.rqt.DurFormula;
import requirements2Z3.rqt.Identifier;
import requirements2Z3.rqt.IsNotStartup;
import requirements2Z3.rqt.IsStartup;
import requirements2Z3.rqt.NegationFormula;
import requirements2Z3.rqt.OrFormula;
import requirements2Z3.rqt.PrevExpression;
import requirements2Z3.rqt.RT;
import requirements2Z3.rqt.RelationalExpression;
import requirements2Z3.rqt.Requirement;
import requirements2Z3.rqt.Requirements;
import requirements2Z3.rqt.TimestampDefinition;
import requirements2Z3.rqt.True;
import requirements2Z3.rqt.UnaryExpression;
import requirements2Z3.rqt.Variable;
import requirements2Z3.rqt.Variables;

/**
 * This visitor is used to define the variables of the Z3 files based on the
 * variables used in the Requirements Table
 */
public class PostconditionContainsVariableVisitor implements RTVisitor<Boolean> {

	private Set<Variable> variables;

	public PostconditionContainsVariableVisitor(Set<Variable> variables) {
		this.variables = variables;
	}

	@Override
	public Boolean visit(AndFormula andFormula) {
		return andFormula.getLeft().accept(this) || andFormula.getRight().accept(this);
	}

	@Override
	public Boolean visit(ArithmeticExpression arithmeticExpression) {
		return arithmeticExpression.getLeft().accept(this) || arithmeticExpression.getRight().accept(this);
	}

	@Override
	public Boolean visit(Constant constant) {
		return false;
	}

	@Override
	public Boolean visit(DurFormula durFormula) {
		return durFormula.getF().accept(this);
	}

	@Override
	public Boolean visit(Identifier identifier) {
		for(Variable v: variables) {
			if(v.getName().equals(identifier.getId())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Boolean visit(IsNotStartup isNotStartup) {
		return false;
	}

	@Override
	public Boolean visit(IsStartup isStartup) {
		return false;
	}

	@Override
	public Boolean visit(NegationFormula negationFormula) {
		return negationFormula.getF().accept(this);
	}

	@Override
	public Boolean visit(OrFormula orFormula) {
		return orFormula.getLeft().accept(this) || orFormula.getRight().accept(this);
	}

	@Override
	public Boolean visit(PrevExpression prevExpression) {
		return prevExpression.getId().accept(this);
	}

	@Override
	public Boolean visit(RelationalExpression relationalExpression) {
		return relationalExpression.getExp1().accept(this)||relationalExpression.getExp2().accept(this);
	}

	@Override
	public Boolean visit(Requirement requirement) {
		return requirement.getPostcondition().accept(this);
	}

	@Override
	public Boolean visit(True true1) {
		return false;
	}

	@Override
	public Boolean visit(UnaryExpression unaryExpression) {
		return unaryExpression.getExp().accept(this);
	}

	@Override
	public Boolean visit(Variable variable) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Boolean visit(Variables variables) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Boolean visit(RT rqTable) {
		return rqTable.getRequirements().accept(this);
	}

	@Override
	public Boolean visit(Requirements requirements) {
		Boolean result = false;

		for (Requirement rq : requirements.getRequirements()) {
			result=result || rq.accept(this);
		}
		return result;
	}
	
	@Override
	public Boolean visit(TimestampDefinition timestampDefinition) {
		throw new UnsupportedOperationException();
	}
}
