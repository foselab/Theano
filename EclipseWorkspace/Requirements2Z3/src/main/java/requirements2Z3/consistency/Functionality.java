package requirements2Z3.consistency;

import org.antlr.v4.runtime.tree.ParseTree;

import requirements2Z3.visitors.translators.Table2Z3Visitor;

public interface Functionality<V extends Table2Z3Visitor> {

	public abstract String printPositiveResult();
	
	public abstract String printNegativeResult();
	
	public abstract String getEncodingActivity(V z3visitor, ParseTree tree);
}
