package requirements2Z3.rqt;

import requirements2Z3.visitors.RTVisitor;

public class TimestampDefinition {

	private final double constant;

	public TimestampDefinition(double constant) {
		this.constant=constant;
	}

	public double getConstant() {
		return constant;
	}

	public <T> T accept(RTVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
