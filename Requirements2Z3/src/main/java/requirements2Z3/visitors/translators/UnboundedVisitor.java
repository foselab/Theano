package requirements2Z3.visitors.translators;

import requirements2Z3.encodings.Encoder;
import requirements2Z3.rqt.IsNotStartup;
import requirements2Z3.rqt.IsStartup;
import requirements2Z3.rqt.PrevExpression;
import requirements2Z3.rqt.Variable;
import requirements2Z3.z3formulae.Z3Formula;

public abstract class UnboundedVisitor extends Table2Z3Visitor {

	public UnboundedVisitor(Encoder encoder) {
		super(encoder);
	}

	@Override
	public Z3Formula visit(Variable variable) {
		return this.getEncoder().getTracePosition(variable.getName(), "i"); 
	}
	
	@Override
	public Z3Formula visit(PrevExpression prevExpression) {
		return this.getEncoder().getPrevValue(prevExpression.getId().getId(), "i");
	}

	@Override
	public Z3Formula visit(IsStartup isStartup) {
		return this.getEncoder().getIsStartup("tau", "i");
	}

	@Override
	public Z3Formula visit(IsNotStartup isNotStartup) {
		return Z3Formula.getNot(this.getEncoder().getIsStartup("tau", "i"));
	}
}
