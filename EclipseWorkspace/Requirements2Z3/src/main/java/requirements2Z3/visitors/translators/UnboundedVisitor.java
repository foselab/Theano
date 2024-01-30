package requirements2Z3.visitors.translators;

import org.antlr.v4.runtime.tree.TerminalNode;

import generated.matlabLexer;
import generated.matlabParser.Is_not_startupContext;
import generated.matlabParser.Is_startupContext;
import generated.matlabParser.Prev_expressionContext;
import requirements2Z3.encodings.Encoder;
import requirements2Z3.z3formulae.Z3Expression;
import requirements2Z3.z3formulae.Z3Formula;

public abstract class UnboundedVisitor extends Table2Z3Visitor {

	public UnboundedVisitor(Encoder encoder) {
		super(encoder);
	}

	@Override
	public Z3Expression visitTerminal(TerminalNode node) {
		if (node.getSymbol().getType() == matlabLexer.IDENTIFIER) {
			return this.getEncoder().getTracePosition(node.getText(), "i"); 
		}
		return super.visitTerminal(node);
	}
	
	@Override
	public Z3Expression visitPrev_expression(Prev_expressionContext ctx) {
		return this.getEncoder().getPrevValue(ctx.getChild(2).getText(), "i");
	}

	@Override
	public Z3Formula visitIs_startup(Is_startupContext ctx) {
		return this.getEncoder().getIsStartup("tau", "i");
	}

	@Override
	public Z3Formula visitIs_not_startup(Is_not_startupContext ctx) {
		return Z3Formula.getNot(this.getEncoder().getIsStartup("tau", "i"));
	}
}
