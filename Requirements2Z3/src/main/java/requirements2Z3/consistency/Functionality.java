package requirements2Z3.consistency;

import requirements2Z3.rqt.RT;
import requirements2Z3.visitors.translators.RT2Z3Visitor;
import requirements2Z3.z3formulae.Z3Formula;

public interface Functionality<V extends RT2Z3Visitor> {

	public abstract String printPositiveResult();
	
	public abstract String printNegativeResult();
	
	public abstract Z3Formula getEncodingActivity(V z3visitor, RT tree);
}
