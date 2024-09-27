package requirements2Z3.rqt;

import requirements2Z3.visitors.RTVisitor;

public abstract class PFormula {
	public abstract <T> T accept(RTVisitor<T> visitor);
}
