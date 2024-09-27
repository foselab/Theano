package requirements2Z3.rqt;

import requirements2Z3.visitors.RTVisitor;

public class Requirement {

	private PFormula precondition;
	private PFormula postcondition;
	
	public Requirement(PFormula precondition,PFormula postcondition) {
		this.setPrecondition(precondition);
		this.setPostcondition(postcondition);
	}
	
	public <T> T accept(RTVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public PFormula getPrecondition() {
		return precondition;
	}

	public void setPrecondition(PFormula precondition) {
		this.precondition = precondition;
	}

	public PFormula getPostcondition() {
		return postcondition;
	}

	public void setPostcondition(PFormula postcondition) {
		this.postcondition = postcondition;
	}
}
