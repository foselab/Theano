package requirements2Z3.rqt;

import requirements2Z3.visitors.RQTableVisitor;

public class True extends PFormula {

	@Override
	public <T> T accept(RQTableVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
