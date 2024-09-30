package requirements2Z3.visitors.translators;

import requirements2Z3.encodings.Encoder;
import requirements2Z3.rqt.Identifier;
import requirements2Z3.rqt.IsNotStartup;
import requirements2Z3.rqt.IsStartup;
import requirements2Z3.rqt.PrevExpression;
import requirements2Z3.rqt.Variable;
import requirements2Z3.z3formulae.Z3Formula;

public abstract class BoundedVisitor extends RT2Z3Visitor  {

	private final int bound;

	private int index;

	public BoundedVisitor(Encoder encoder, int bound) {
		super(encoder);
		this.bound = bound;
		this.index = 0;
	}

	public void setIndex(int index) {
		this.index=index;
	}
	public int getIndex() {
		return index;
	}

	public void increaseIndex() {
		this.index = this.index+1;
	}

	public void resetIndex() {
		this.index = 0;
	}

	
	@Override
	public Z3Formula visit(Identifier identifier) {
			return this.getEncoder().getTracePosition(identifier.getId(), String.valueOf(this.getIndex()));
	}
	
	@Override
	public Z3Formula visit(Variable v) {
		return this.getEncoder().getTracePosition(v.getName(), String.valueOf(this.getIndex()));
	}

	@Override
	public Z3Formula visit(PrevExpression p)
	{
		//if (this.index == 0) {
		//	return this.getEncoder().getTracePosition(prevExpression.getId().getId(), String.valueOf(this.getIndex()));
		//} else {
			return this.getEncoder().getTracePosition(p.getId().getId(), String.valueOf(this.getIndex() - 1));
		//}
	}

	@Override
	public Z3Formula visit(IsStartup s) {
		return this.getEncoder().getIsStartup("tau", String.valueOf(this.getIndex()));
	}
	
	@Override
	public Z3Formula visit(IsNotStartup ns) {
		return Z3Formula.getNot(this.getEncoder().getIsStartup("tau", String.valueOf(this.getIndex())));
	}

	public int getBound() {
		return bound;
	}

}
