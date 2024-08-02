package requirements2Z3.rqt;

import requirements2Z3.visitors.RQTableVisitor;

public class PrevExpression extends Expression {

	private final Identifier id;
	
	public PrevExpression(Identifier id) {
		this.id=id;
	}

	public Identifier getId() {
		return id;
	}
	
	@Override
	public <T> T accept(RQTableVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
