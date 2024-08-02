package requirements2Z3.rqt;

import requirements2Z3.visitors.RQTableVisitor;

public class NegationFormula extends PFormula {

	private final PFormula f;

	public NegationFormula(PFormula f) {
		this.f = f;
	}

	public PFormula getF() {
		return f;
	}
	
	public <T> T accept(RQTableVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
