package requirements2Z3.rqt;

import requirements2Z3.visitors.RTVisitor;

public class PrevExpression extends Expression {

	private final Identifier id;
	
	public PrevExpression(Identifier id) {
		this.id=id;
	}

	public Identifier getId() {
		return id;
	}
	
	@Override
	public <T> T accept(RTVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
