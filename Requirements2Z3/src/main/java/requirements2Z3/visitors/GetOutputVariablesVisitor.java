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
import requirements2Z3.rqt.TimestampDefinition;
import requirements2Z3.rqt.True;
import requirements2Z3.rqt.UnaryExpression;
import requirements2Z3.rqt.Variable;
import requirements2Z3.rqt.Variables;

/**
 * This visitor is used to define the variables of the Z3 files based on the
 * variables used in the Requirements Table
 */
public class GetOutputVariablesVisitor implements RQTableVisitor<Set<Variable>> {
	
	@Override
	public Set<Variable> visit(AndFormula andFormula) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<Variable> visit(ArithmeticExpression arithmeticExpression) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<Variable> visit(Constant constant) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<Variable> visit(DurFormula durFormula) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<Variable> visit(Identifier identifier) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<Variable> visit(IsNotStartup isNotStartup) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<Variable> visit(IsStartup isStartup) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<Variable> visit(NegationFormula negationFormula) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<Variable> visit(OrFormula orFormula) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<Variable> visit(PrevExpression prevExpression) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<Variable> visit(RelationalExpression relationalExpression) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<Variable> visit(Requirement requirement) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<Variable> visit(True true1) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<Variable> visit(UnaryExpression unaryExpression) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<Variable> visit(Variable variable) {
		Set<Variable> variablesRet=new HashSet<Variable>();
		if(variable.getInputOutput().equals("output")) {
			variablesRet.add(variable);
		}
		return variablesRet;
	}

	@Override
	public Set<Variable> visit(Variables variables) {
		Set<Variable> variablesRet=new HashSet<Variable>();
		for(Variable v: variables.getVariables()) {
			variablesRet.addAll(v.accept(this));
		}
		return variablesRet;
	}

	@Override
	public Set<Variable> visit(RQTable rqTable) {
		return rqTable.getVariables().accept(this);
	}

	@Override
	public Set<Variable> visit(Requirements requirements) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Set<Variable> visit(TimestampDefinition timestampDefinition) {
		throw new UnsupportedOperationException();
	}
}
