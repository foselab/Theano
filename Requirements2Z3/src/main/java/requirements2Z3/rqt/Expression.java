package requirements2Z3.rqt;

import requirements2Z3.visitors.RTVisitor;

public abstract class Expression {

	public abstract <T> T accept(RTVisitor<T> visitor);
}
