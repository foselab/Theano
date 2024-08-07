package requirements2Z3.visitors;

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

public class RQTableToStringVisitor implements RQTableVisitor<String>{

	@Override
	public String visit(ArithmeticExpression arithmeticExpression) {
		return arithmeticExpression.getLeft().accept(this)+arithmeticExpression.getOp().getOperator()+arithmeticExpression.getRight().accept(this);
	}

	@Override
	public String visit(Constant constant) {
		return Double.toString(constant.getConstant());
	}

	@Override
	public String visit(DurFormula durFormula) {
		return "dur"+"("+durFormula.getF().accept(this)+")"+durFormula.getOp()+durFormula.getConstant();
	}

	@Override
	public String visit(Identifier identifier) {
		return identifier.getId();
	}

	@Override
	public String visit(IsNotStartup isNotStartup) {
		return isNotStartup.toString();
	}

	@Override
	public String visit(IsStartup isStartup) {
		return isStartup.toString();
	}

	@Override
	public String visit(NegationFormula negationFormula) {
		return "!("+negationFormula.getF().accept(this)+")";
	}

	@Override
	public String visit(OrFormula orFormula) {
		return orFormula.getLeft().accept(this)+"|"+orFormula.getRight().accept(this);
	}
	
	@Override
	public String visit(AndFormula andFormula) {
		return andFormula.getLeft().accept(this)+"&"+andFormula.getRight().accept(this);
	}

	@Override
	public String visit(PrevExpression prevExpression) {
		return "prev("+prevExpression.getId().accept(this)+")";
	}

	@Override
	public String visit(RelationalExpression relationalExpression) {
		return relationalExpression.getExp1().accept(this)+relationalExpression.getOp().toString()+relationalExpression.getExp2().accept(this);
	}

	@Override
	public String visit(Requirement requirement) {
		return "\t"+requirement.getPrecondition().accept(this)+","+requirement.getPostcondition().accept(this);
	}

	@Override
	public String visit(True true1) {
		return "true";
	}

	@Override
	public String visit(UnaryExpression unaryExpression) {
		return unaryExpression.getOp().toString()+unaryExpression.getOp().toString();
	}

	@Override
	public String visit(Variable variable) {
		return "\t"+variable.getName()+","+variable.getType()+","+variable.getInputOutput();
	}

	@Override
	public String visit(Variables variables) {
		StringBuilder builder=new StringBuilder();
		for(Variable v: variables.getVariables()) {
			builder.append(v.accept(this)+"\n");
		}
		return builder.toString();
	}

	@Override
	public String visit(RQTable rqTable) {
		StringBuilder builder=new StringBuilder();
		builder.append(rqTable.getTd().accept(this));
		builder.append("vardef\n"+rqTable.getVariables().accept(this)+"endvardef\n");
		builder.append("reqdef\n"+rqTable.getRequirements().accept(this)+"endreqdef\n");
		
		return builder.toString();
	}

	@Override
	public String visit(Requirements requirements) {
		StringBuilder builder=new StringBuilder();
		for(Requirement v: requirements.getRequirements()) {
			builder.append(v.accept(this)+"\n");
		}
		return builder.toString();
	}

	@Override
	public String visit(TimestampDefinition timestampDefinition) {
		return "Ts="+timestampDefinition.getConstant()+"\n";
	}
}
