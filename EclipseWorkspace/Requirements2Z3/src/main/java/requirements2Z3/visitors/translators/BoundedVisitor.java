package requirements2Z3.visitors.translators;

import org.antlr.v4.runtime.tree.TerminalNode;

import generated.matlabLexer;
import generated.matlabVisitor;
import generated.matlabParser.Is_not_startupContext;
import generated.matlabParser.Is_startupContext;
import generated.matlabParser.Prev_expressionContext;
import requirements2Z3.encodings.Encoder;

public abstract class BoundedVisitor extends Table2Z3Visitor implements matlabVisitor<String> {

	private final int bound;
	
	private int index;
	
	public BoundedVisitor(Encoder encoder, int bound) {
		super(encoder);
		this.bound=bound;
		this.index=0;
	}

	
	
	public int getIndex() {
		return index;
	}
	
	public void increaseIndex() {
		this.index=index++;
	}
	
	public void resetIndex() {
		this.index=0;
	}
	
	@Override
	public String visitTerminal(TerminalNode node) {
		if (node.getSymbol().getType() == matlabLexer.IDENTIFIER) {
			return this.getEncoder().getTracePosition(node.getText(), String.valueOf(this.getIndex())); 
		}
		return super.visitTerminal(node);
	}
	
	@Override
	public String visitPrev_expression(Prev_expressionContext ctx) {

		StringBuilder b = new StringBuilder();
		if (index == 0) {
			this.getEncoder().getTracePosition(ctx.getChild(2).getText(), String.valueOf(this.getIndex()));
		} else {
			this.getEncoder().getTracePosition(ctx.getChild(2).getText(), String.valueOf(this.getIndex()-1));
		}
		return b.toString();
	}
	
	@Override
	public String visitIs_startup(Is_startupContext ctx) {
		return this.getEncoder().getIsStartup("tau", String.valueOf(this.getIndex()));
	}

	@Override
	public String visitIs_not_startup(Is_not_startupContext ctx) {
		return "!(" + this.getEncoder().getIsStartup("tau", String.valueOf(this.getIndex())) + ")";
	}



	public int getBound() {
		return bound;
	}

	

}
