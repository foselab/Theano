package requirements2Z3.rqt;

import requirements2Z3.visitors.RTVisitor;

public class Constant extends Expression{

	private final double constant;
	
	public Constant(double constant) {
		this.constant=constant;
	}

	public double getConstant() {
		return constant;
	}
	public <T> T accept(RTVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
