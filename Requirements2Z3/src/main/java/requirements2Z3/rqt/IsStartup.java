package requirements2Z3.rqt;

import requirements2Z3.visitors.RQTableVisitor;

public class IsStartup extends PFormula {
	
	public <T> T accept(RQTableVisitor<T> visitor) {
		return visitor.visit(this);
	}

	@Override
	public String toString() {
		return "isStartup";
	}
}
