package requirements2Z3.visitors.translators;

import org.antlr.v4.runtime.tree.TerminalNode;

import generated.matlabLexer;
import generated.matlabParser.Is_not_startupContext;
import generated.matlabParser.Is_startupContext;
import generated.matlabParser.Prev_expressionContext;
import requirements2Z3.encodings.Encoder;
import requirements2Z3.z3formulae.Z3Expression;
import requirements2Z3.z3formulae.Z3Formula;

public abstract class BoundedVisitor extends RT2Z3Visitor  {

	private final int bound;

	private int index;

	public BoundedVisitor(Encoder encoder, int bound) {
		super(encoder);
		this.bound = bound;
		this.index = 0;
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
	public Z3Expression visitTerminal(TerminalNode node) {
		if (node.getSymbol().getType() == matlabLexer.IDENTIFIER) {
			return this.getEncoder().getTracePosition(node.getText(), String.valueOf(this.getIndex()));
		}
		return super.visitTerminal(node);
	}

	@Override
	public Z3Expression visitPrev_expression(Prev_expressionContext ctx) {
		if (this.index == 0) {
			return this.getEncoder().getTracePosition(ctx.getChild(2).getText(), String.valueOf(this.getIndex()));
		} else {
			return this.getEncoder().getTracePosition(ctx.getChild(2).getText(), String.valueOf(this.getIndex() - 1));
		}
	}

	@Override
	public Z3Formula visitIs_startup(Is_startupContext ctx) {
		return this.getEncoder().getIsStartup("tau", String.valueOf(this.getIndex()));
	}

	@Override
	public Z3Formula visitIs_not_startup(Is_not_startupContext ctx) {
		return Z3Formula.getNot(this.getEncoder().getIsStartup("tau", String.valueOf(this.getIndex())));
	}

	public int getBound() {
		return bound;
	}

}
