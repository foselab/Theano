package requirements2Z3.visitors;

import java.util.HashSet;
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
import requirements2Z3.rqt.PFormula;
import requirements2Z3.rqt.PrevExpression;
import requirements2Z3.rqt.RQTable;
import requirements2Z3.rqt.RelationalExpression;
import requirements2Z3.rqt.Requirement;
import requirements2Z3.rqt.Requirements;
import requirements2Z3.rqt.True;
import requirements2Z3.rqt.UnaryExpression;
import requirements2Z3.rqt.Variable;
import requirements2Z3.rqt.Variables;

/**
 * This visitor is used to define the variables of the Z3 files based on the
 * variables used in the Requirements Table
 * 
 * Returns the preconditions associated with a postcondition that contain that variable
 */
public class GetPreconditionsVariableVisitor implements RQTableVisitor<Set<PFormula>> {

	private Variable variable;

	public GetPreconditionsVariableVisitor(Variable variable) {
		this.variable = variable;
	}

	@Override
	public Set<PFormula> visit(AndFormula andFormula) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<PFormula> visit(ArithmeticExpression arithmeticExpression) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<PFormula> visit(Constant constant) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<PFormula> visit(DurFormula durFormula) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<PFormula> visit(Identifier identifier) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<PFormula> visit(IsNotStartup isNotStartup) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<PFormula> visit(IsStartup isStartup) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<PFormula> visit(NegationFormula negationFormula) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<PFormula> visit(OrFormula orFormula) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<PFormula> visit(PrevExpression prevExpression) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<PFormula> visit(RelationalExpression relationalExpression) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<PFormula> visit(Requirement requirement) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<PFormula> visit(True true1) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<PFormula> visit(UnaryExpression unaryExpression) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<PFormula> visit(Variable variable) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<PFormula> visit(Variables variables) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<PFormula> visit(RQTable rqTable) {
		return rqTable.getRequirements().accept(this);
	}

	@Override
	public Set<PFormula> visit(Requirements requirements) {
		Set<PFormula> preconditions = new HashSet<>();
		Set<Variable> variables = new HashSet<>();
		variables.add(this.variable);

		for (Requirement rq : requirements.getRequirements()) {

			if (rq.getPostcondition().accept(new PostconditionContainsVariableVisitor(variables))) {
				preconditions.add(rq.getPrecondition());
			}
		}
		return preconditions;
	}
}
