package requirements2Z3.rqt;

import requirements2Z3.visitors.RTVisitor;

public class True extends PFormula {

	@Override
	public <T> T accept(RTVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
