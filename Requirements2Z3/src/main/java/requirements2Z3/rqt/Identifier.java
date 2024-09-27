package requirements2Z3.rqt;

import requirements2Z3.visitors.RTVisitor;

public class Identifier extends Expression {

	private final String id;
	
	public Identifier(String id) {
		this.id=id;
	}

	public String getId() {
		return id;
	}
	
	public <T> T accept(RTVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
