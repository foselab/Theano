package requirements2Z3.rqt;

import requirements2Z3.visitors.RQTableVisitor;

public class OrFormula extends PFormula {

	private final PFormula left;

	private final PFormula right;

	public OrFormula(PFormula left, PFormula right) {
		this.left = left;
		this.right = right;
	}

	public PFormula getLeft() {
		return left;
	}

	public PFormula getRight() {
		return right;
	}
	
	@Override
	public <T> T accept(RQTableVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
