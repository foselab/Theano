package requirements2Z3.visitors.translators;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import generated.matlabLexer;
import generated.matlabParser.Additive_expressionContext;
import generated.matlabParser.And_expressionContext;
import generated.matlabParser.Assignment_expressionContext;
import generated.matlabParser.Dur_expressionContext;
import generated.matlabParser.Equality_expressionContext;
import generated.matlabParser.ExpressionContext;
import generated.matlabParser.Index_expressionContext;
import generated.matlabParser.IoContext;
import generated.matlabParser.Multiplicative_expressionContext;
import generated.matlabParser.Or_expressionContext;
import generated.matlabParser.PostconditionContext;
import generated.matlabParser.Postfix_expressionContext;
import generated.matlabParser.PreconditionContext;
import generated.matlabParser.Prev_expressionContext;
import generated.matlabParser.PrimaryExpressionContext;
import generated.matlabParser.Primary_expressionContext;
import generated.matlabParser.Relational_expressionContext;
import generated.matlabParser.RequirementContext;
import generated.matlabParser.RequirementsdefinitionsContext;
import generated.matlabParser.StatementContext;
import generated.matlabParser.Statement_listContext;
import generated.matlabParser.TypeSpecifierContext;
import generated.matlabParser.Unary_expressionContext;
import generated.matlabParser.Unary_operatorContext;
import generated.matlabParser.VariableNameContext;
import generated.matlabParser.VariabledefinitionContext;
import generated.matlabParser.VariablesdefinitionsContext;
import generated.matlabVisitor;
import requirements2Z3.encodings.Encoder;

public abstract class Table2Z3Visitor implements matlabVisitor<String> {

	private final Encoder encoder;

	public Table2Z3Visitor(Encoder encoder) {
		this.encoder = encoder;
	}

	@Override
	public String visitTerminal(TerminalNode node) {
		if (node.getSymbol().getType() == matlabLexer.CONSTANT) {
			return node.getText();
		}
		if (node.getSymbol().getType() == matlabLexer.NE_OP) {
			return "!=";
		}
		if (node.getSymbol().getType() == matlabLexer.CR) {
			return "";
		}
		return node.getText();
	}

	@Override
	public String visitPrimaryExpression(PrimaryExpressionContext ctx) {
		StringBuilder b = new StringBuilder();

		b.append(ctx.getChild(1).accept(this));

		return b.toString();
	}

	@Override
	public String visitVariablesdefinitions(VariablesdefinitionsContext ctx) {
		return "";
	}

	@Override
	public String visitRequirementsdefinitions(RequirementsdefinitionsContext ctx) {
		StringBuilder b = new StringBuilder();

		b.append("And(");

		b.append(ctx.getChild(2).accept(this));
		for (int i = 3; i < ctx.getChildCount() - 2; i++) {
			b.append("," + ctx.getChild(i).accept(this));
		}
		b.append(")");

		return b.toString();
	}

	@Override
	public String visitTypeSpecifier(TypeSpecifierContext ctx) {
		return "";
	}

	@Override
	public String visit(ParseTree tree) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < tree.getChildCount(); i++) {
			b.append(tree.getChild(i).accept(this));
		}

		return b.toString();
	}

	@Override
	public String visitChildren(RuleNode node) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < node.getChildCount(); i++) {
			b.append(node.getChild(i).accept(this));
		}

		return b.toString();
	}

	@Override
	public String visitErrorNode(ErrorNode node) {
		return node.getText();
	}

	@Override
	public String visitPrimary_expression(Primary_expressionContext ctx) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			b.append(ctx.getChild(i).accept(this));
		}

		return b.toString();
	}

	@Override
	public String visitPostfix_expression(Postfix_expressionContext ctx) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			b.append(ctx.getChild(i).accept(this));
		}

		return b.toString();
	}

	@Override
	public String visitIndex_expression(Index_expressionContext ctx) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			b.append(ctx.getChild(i).accept(this));
		}

		return b.toString();
	}

	@Override
	public String visitUnary_expression(Unary_expressionContext ctx) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			b.append(ctx.getChild(i).accept(this));
		}

		return b.toString();
	}

	@Override
	public String visitUnary_operator(Unary_operatorContext ctx) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			b.append(ctx.getChild(i).accept(this));
		}

		return b.toString();
	}

	@Override
	public String visitMultiplicative_expression(Multiplicative_expressionContext ctx) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			b.append(ctx.getChild(i).accept(this));
		}

		return b.toString();
	}

	@Override
	public String visitAdditive_expression(Additive_expressionContext ctx) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			b.append(ctx.getChild(i).accept(this));
		}

		return b.toString();
	}

	@Override
	public String visitRelational_expression(Relational_expressionContext ctx) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			b.append(ctx.getChild(i).accept(this));
		}

		return b.toString();
	}

	@Override
	public String visitEquality_expression(Equality_expressionContext ctx) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			b.append(ctx.getChild(i).accept(this));
		}

		return b.toString();
	}

	@Override
	public String visitAnd_expression(And_expressionContext ctx) {
		StringBuilder b = new StringBuilder();

		if (ctx.getChildCount() == 1) {
			b.append(ctx.getChild(0).accept(this));
		} else {

			String part1 = ctx.getChild(0).accept(this);
			String part2 = ctx.getChild(2).accept(this);
			if (part1.equals("True")) {
				return part2;
			}
			if (part1.equals("False")) {
				return "False";
			}

			b.append("And(" + part1 + "," + part2 + ")");
		}

		return b.toString();
	}

	@Override
	public String visitOr_expression(Or_expressionContext ctx) {
		StringBuilder b = new StringBuilder();

		if (ctx.getChildCount() == 1) {
			b.append(ctx.getChild(0).accept(this));
		} else {
			b.append("Or(" + ctx.getChild(0).accept(this) + "," + ctx.getChild(2).accept(this) + ")");
		}

		return b.toString();
	}

	@Override
	public String visitExpression(ExpressionContext ctx) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			b.append(ctx.getChild(i).accept(this));
		}

		return b.toString();
	}

	@Override
	public String visitAssignment_expression(Assignment_expressionContext ctx) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			b.append(ctx.getChild(i).accept(this));
		}

		return b.toString();
	}

	@Override
	public String visitStatement(StatementContext ctx) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			b.append(ctx.getChild(i).accept(this));
		}

		return b.toString();
	}

	@Override
	public String visitStatement_list(Statement_listContext ctx) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			b.append(ctx.getChild(i).accept(this));
		}

		return b.toString();
	}

	public abstract String visitPrev_expression(Prev_expressionContext ctx);

	public abstract String visitDur_expression(Dur_expressionContext ctx);

	@Override
	public String visitVariabledefinition(VariabledefinitionContext ctx) {
		return "";
	}

	@Override
	public String visitVariableName(VariableNameContext ctx) {
		return ctx.getText();
	}

	@Override
	public String visitIo(IoContext ctx) {
		return ctx.getText();
	}

	@Override
	public String visitRequirement(RequirementContext ctx) {
		StringBuilder b = new StringBuilder();

		b.append("Implies(" + ctx.getChild(0).accept(this) + "," + ctx.getChild(2).accept(this) + ")");

		return b.toString();
	}

	@Override
	public String visitPrecondition(PreconditionContext ctx) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			b.append(ctx.getChild(i).accept(this));
		}

		return b.toString();
	}

	@Override
	public String visitPostcondition(PostconditionContext ctx) {
		StringBuilder b = new StringBuilder();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			b.append(ctx.getChild(i).accept(this));
		}

		return b.toString();
	}

	public Encoder getEncoder() {
		return encoder;
	}
}
