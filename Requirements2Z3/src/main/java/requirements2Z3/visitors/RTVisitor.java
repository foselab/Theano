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

public interface RTVisitor<T> {

	public  T visit(AndFormula andFormula);

	public  T visit(ArithmeticExpression arithmeticExpression);

	public  T visit(Constant constant);

	public  T visit(DurFormula durFormula);

	public  T visit(Identifier identifier);

	public  T visit(IsNotStartup isNotStartup);

	public  T visit(IsStartup isStartup);

	public  T visit(NegationFormula negationFormula);

	public  T visit(OrFormula orFormula);

	public  T visit(PrevExpression prevExpression);

	public  T visit(RelationalExpression relationalExpression);

	public  T visit(Requirement requirement);

	public  T visit(True true1);

	public  T visit(UnaryExpression unaryExpression);

	public  T visit(Variable variable);

	public  T visit(Variables variables);

	public  T visit(RQTable rqTable);

	public  T visit(Requirements requirements);

	public T visit(TimestampDefinition timestampDefinition);
}