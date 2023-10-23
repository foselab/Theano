package requirements2Z3.visitors.translators;

import org.antlr.v4.runtime.tree.TerminalNode;

import generated.matlabLexer;
import generated.matlabParser.Is_not_startupContext;
import generated.matlabParser.Is_startupContext;
import generated.matlabParser.Prev_expressionContext;
import requirements2Z3.encodings.Encoder;

public abstract class UnboundedVisitor extends Table2Z3Visitor {

	public UnboundedVisitor(Encoder encoder) {
		super(encoder);
	}

	@Override
	public String visitTerminal(TerminalNode node) {
		if (node.getSymbol().getType() == matlabLexer.IDENTIFIER) {
			return this.getEncoder().getTracePosition(node.getText(), "i"); 
		}
		return super.visitTerminal(node);
	}
	
	@Override
	public String visitPrev_expression(Prev_expressionContext ctx) {
		return this.getEncoder().getPrevValue(ctx.getChild(2).getText(), "i");
	}

	@Override
	public String visitIs_startup(Is_startupContext ctx) {
		return this.getEncoder().getIsStartup("tau", "i");
	}

	@Override
	public String visitIs_not_startup(Is_not_startupContext ctx) {
		return "Not(" + this.getEncoder().getIsStartup("tau", "i") + ")";
	}
}
