package requirements2Z3.visitors;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import generated.matlabBaseVisitor;
import generated.matlabParser.RequirementContext;
import generated.matlabParser.RequirementsdefinitionsContext;
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
 * 
 * Returns the Requirement whose precondition uses that variable
 */
public class GetRequirementsVariableVisitor implements RTVisitor<List<Requirement>> {

	private Variable variable;

	public GetRequirementsVariableVisitor(Variable variable) {
		this.variable = variable;
	}


	@Override
	public List<Requirement> visit(AndFormula andFormula) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Requirement> visit(ArithmeticExpression arithmeticExpression) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Requirement> visit(Constant constant) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Requirement> visit(DurFormula durFormula) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Requirement> visit(Identifier identifier) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Requirement> visit(IsNotStartup isNotStartup) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Requirement> visit(IsStartup isStartup) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Requirement> visit(NegationFormula negationFormula) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Requirement> visit(OrFormula orFormula) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Requirement> visit(PrevExpression prevExpression) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Requirement> visit(RelationalExpression relationalExpression) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Requirement> visit(Requirement requirement) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Requirement> visit(True true1) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Requirement> visit(UnaryExpression unaryExpression) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Requirement> visit(Variable variable) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Requirement> visit(Variables variables) {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Requirement> visit(RQTable rqTable) {
		return rqTable.getRequirements().accept(this);
	}

	@Override
	public List<Requirement> visit(Requirements requirements) {
		
		List<Requirement> retRequirements=new ArrayList<Requirement>();
		
		Set<Variable> variables = new HashSet<>();
		variables.add(this.variable);
		
		for(Requirement r: requirements.getRequirements()) {
			if(
					r.accept(new PreconditionContainsVariableVisitor(variables)) ||
					r.accept(new PostconditionContainsVariableVisitor(variables))
					) {
				retRequirements.add(r);
			}
		}
		return retRequirements;
	}
	
	@Override
	public List<Requirement> visit(TimestampDefinition timestampDefinition) {
		throw new UnsupportedOperationException();
	}
}
