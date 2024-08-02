package requirements2Z3.rqt;

import requirements2Z3.visitors.RQTableVisitor;

public class Identifier extends Expression {

	private final String id;
	
	public Identifier(String id) {
		this.id=id;
	}

	public String getId() {
		return id;
	}
	
	public <T> T accept(RQTableVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
