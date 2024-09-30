package requirements2Z3.visitors.translators;

import requirements2Z3.encodings.Encoder;
import requirements2Z3.rqt.Identifier;
import requirements2Z3.rqt.IsNotStartup;
import requirements2Z3.rqt.IsStartup;
import requirements2Z3.rqt.PrevExpression;
import requirements2Z3.rqt.Variable;
import requirements2Z3.z3formulae.Z3Formula;

public abstract class UnboundedVisitor extends RT2Z3Visitor {

	public UnboundedVisitor(Encoder encoder) {
		super(encoder);
	}

	@Override
	public Z3Formula visit(Identifier identifier) {
		return this.getEncoder().getTracePosition(identifier.getId(), "i");
	}
	

	@Override
	public Z3Formula visit(Variable v) {
		return this.getEncoder().getTracePosition(v.getName(), "i"); 
	}
	
	@Override
	public Z3Formula visit(PrevExpression p) {
		return this.getEncoder().getPrevValue(p.getId().getId(), "i");
	}

	@Override
	public Z3Formula visit(IsStartup s) {
		return this.getEncoder().getIsStartup("tau", "i");
	}

	@Override
	public Z3Formula visit(IsNotStartup ns) {
		return Z3Formula.getNot(this.getEncoder().getIsStartup("tau", "i"));
	}
}
