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
public class DefineVariablesVisitor implements RTVisitor<String> {

	@Override
	public String visit(AndFormula andFormula) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String visit(ArithmeticExpression arithmeticExpression) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String visit(Constant constant) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String visit(DurFormula durFormula) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String visit(Identifier identifier) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String visit(IsNotStartup isNotStartup) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String visit(IsStartup isStartup) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String visit(NegationFormula negationFormula) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String visit(OrFormula orFormula) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String visit(PrevExpression prevExpression) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String visit(RelationalExpression relationalExpression) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String visit(Requirement requirement) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String visit(True true1) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String visit(UnaryExpression unaryExpression) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String visit(Variable variable) {
		String id = variable.getName();

		if (!id.equals("tau")) {
			if (variable.getType().equals("Int")) {
				return id + "=Array('" + id + "',I,I)\n";
			}
		}
		return id + "=Array('" + id + "',I,R)\n";

	}

	@Override
	public String visit(Variables variables) {
		StringBuilder b = new StringBuilder();

		for (Variable v : variables.getVariables()) {
			b.append(v.accept(this));
		}
		return b.toString();
	}

	@Override
	public String visit(RT rqTable) {
		if (rqTable.getTd() != null)
			return rqTable.getTd().accept(this) + rqTable.getVariables().accept(this);
		else
			return rqTable.getVariables().accept(this);
	}

	@Override
	public String visit(Requirements requirements) {
		throw new UnsupportedOperationException();
	}

	@Override
	public String visit(TimestampDefinition timestampDefinition) {
		return "Ts = Real('Ts')\n";
	}
}
