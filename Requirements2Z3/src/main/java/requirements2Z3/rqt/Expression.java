package requirements2Z3.rqt;

import requirements2Z3.visitors.RQTableVisitor;

public abstract class Expression {

	public abstract <T> T accept(RQTableVisitor<T> visitor);
}
