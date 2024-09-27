package requirements2Z3.rqt;

import requirements2Z3.visitors.RTVisitor;

public class IsStartup extends PFormula {
	
	public <T> T accept(RTVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return "isStartup";
	}
}
