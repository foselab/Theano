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
import generated.matlabParser.GContext;
import generated.matlabParser.ComposedExpressionContext;
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
import requirements2Z3.z3formulae.Z3Expression;
import requirements2Z3.z3formulae.Z3Formula;

public abstract class Table2Z3Visitor implements matlabVisitor<Z3Formula> {

	private final Encoder encoder;

	public Table2Z3Visitor(Encoder encoder) {
		this.encoder = encoder;
	}

	@Override
	public Z3Expression visitTerminal(TerminalNode node) {
		if (node.getSymbol().getType() == matlabLexer.CONSTANT) {
			return Z3Formula.getConstant(node.getText());
		}
//		if (node.getSymbol().getType() == matlabLexer.NE_OP) {
//			return "!=";
//		}
		if (node.getSymbol().getType() == matlabLexer.CR) {
			return Z3Formula.getEmpty();
		}
		return Z3Formula.getVariable(node.getText());
	}

	@Override
	public Z3Formula visitPrimaryExpression(PrimaryExpressionContext ctx) {
		return ctx.getChild(1).accept(this);
	}
	
	public Z3Formula visitG(GContext ctx) {
		return ctx.getChild(1).accept(this);
	}
	
	public Z3Formula visitComposedExpression(ComposedExpressionContext ctx) {
		return ctx.getChild(1).accept(this);
	}

	@Override
	public Z3Formula visitVariablesdefinitions(VariablesdefinitionsContext ctx) {
		return Z3Formula.getEmpty();
	}

	@Override
	public Z3Formula visitRequirementsdefinitions(RequirementsdefinitionsContext ctx) {

		Z3Formula f = Z3Formula.getTrue();

		f = Z3Formula.getAnd(f, ctx.getChild(2).accept(this));
		for (int i = 3; i < ctx.getChildCount() - 2; i++) {
			f = Z3Formula.getAnd(f, ctx.getChild(i).accept(this));
		}
		return f;
	}

	@Override
	public Z3Formula visitTypeSpecifier(TypeSpecifierContext ctx) {
		return null;
	}

	@Override
	public Z3Formula visit(ParseTree tree) {
		Z3Formula b = Z3Formula.getEmpty();

		for (int i = 0; i < tree.getChildCount(); i++) {

			Z3Formula f = tree.getChild(i).accept(this);

			if (!f.equals(Z3Formula.getEmpty())) {
				if (b.equals(Z3Formula.getEmpty())) {
					b = f;
				} else {
					throw new IllegalArgumentException("Can not change " + b);
				}
			}
		}
		return b;
	}

	@Override
	public Z3Formula visitChildren(RuleNode node) {
		Z3Formula b = Z3Formula.getEmpty();

		for (int i = 0; i < node.getChildCount(); i++) {

			Z3Formula f = node.getChild(i).accept(this);

			if (!f.equals(Z3Formula.getEmpty())) {
				if (b.equals(Z3Formula.getEmpty())) {
					b = f;
				} else {
					throw new IllegalArgumentException("Can not change " + b);
				}
			}
		}
		return b;
	}

	@Override
	public Z3Formula visitErrorNode(ErrorNode node) {
		return Z3Formula.getVariable(node.getText());
	}

	@Override
	public Z3Formula visitPrimary_expression(Primary_expressionContext ctx) {
		Z3Formula b = Z3Formula.getEmpty();

		for (int i = 0; i < ctx.getChildCount(); i++) {

			Z3Formula f = ctx.getChild(i).accept(this);

			if (!f.equals(Z3Formula.getEmpty())) {
				if (b.equals(Z3Formula.getEmpty())) {
					b = f;
				} else {
					throw new IllegalArgumentException("Can not change " + b);
				}
			}
		}
		return b;
	}

	@Override
	public Z3Formula visitPostfix_expression(Postfix_expressionContext ctx) {
		Z3Formula b = Z3Formula.getEmpty();

		for (int i = 0; i < ctx.getChildCount(); i++) {

			Z3Formula f = ctx.getChild(i).accept(this);

			if (!f.equals(Z3Formula.getEmpty())) {
				if (b.equals(Z3Formula.getEmpty())) {
					b = f;
				} else {
					throw new IllegalArgumentException("Can not change " + b);
				}
			}
		}
		return b;
	}

	@Override
	public Z3Formula visitIndex_expression(Index_expressionContext ctx) {
		Z3Formula b = Z3Formula.getEmpty();

		for (int i = 0; i < ctx.getChildCount(); i++) {

			Z3Formula f = ctx.getChild(i).accept(this);

			if (!f.equals(Z3Formula.getEmpty())) {
				if (b.equals(Z3Formula.getEmpty())) {
					b = f;
				} else {
					throw new IllegalArgumentException("Can not change " + b);
				}
			}
		}
		return b;
	}

	@Override
	public Z3Formula visitUnary_expression(Unary_expressionContext ctx) {
		Z3Formula b = Z3Formula.getEmpty();

		for (int i = 0; i < ctx.getChildCount(); i++) {

			Z3Formula f = ctx.getChild(i).accept(this);

			if (!f.equals(Z3Formula.getEmpty())) {
				if (b.equals(Z3Formula.getEmpty())) {
					b = f;
				} else {
					throw new IllegalArgumentException("Can not change " + b);
				}
			}
		}
		return b;
	}

	@Override
	public Z3Formula visitUnary_operator(Unary_operatorContext ctx) {
		Z3Formula b = Z3Formula.getEmpty();

		for (int i = 0; i < ctx.getChildCount(); i++) {

			Z3Formula f = ctx.getChild(i).accept(this);

			if (!f.equals(Z3Formula.getEmpty())) {
				if (b.equals(Z3Formula.getEmpty())) {
					b = f;
				} else {
					throw new IllegalArgumentException("Can not change " + b);
				}
			}
		}
		return b;
	}

	@Override
	public Z3Formula visitMultiplicative_expression(Multiplicative_expressionContext ctx) {
		Z3Formula b = Z3Formula.getEmpty();

		for (int i = 0; i < ctx.getChildCount(); i++) {

			Z3Formula f = ctx.getChild(i).accept(this);

			if (!f.equals(Z3Formula.getEmpty())) {
				if (b.equals(Z3Formula.getEmpty())) {
					b = f;
				} else {
					throw new IllegalArgumentException("Can not change " + b);
				}
			}
		}
		return b;
	}

	@Override
	public Z3Expression visitAdditive_expression(Additive_expressionContext ctx) {

		if(ctx.getChildCount()==1) {
			return (Z3Expression) ctx.getChild(0).accept(this); 
		}
		
		if(ctx.getChildCount()==3) {
			return Z3Formula.getExpression( 
					(Z3Expression) ctx.getChild(0).accept(this), 
					ctx.getChild(1).getText(), 
					(Z3Expression) ctx.getChild(2).accept(this));
			
		}
		throw new IllegalArgumentException("No option available ");
	}

	@Override
	public Z3Formula visitRelational_expression(Relational_expressionContext ctx) {
		
		if(ctx.getChildCount()==1) {
			return ctx.getChild(0).accept(this);
		}
		if(ctx.getChildCount()==3) {
			return Z3Formula.getPredicate(
					(Z3Expression) ctx.getChild(0).accept(this), 
					Z3Formula.getRelationalOperator(ctx.getChild(1).getText()), 
					(Z3Expression) ctx.getChild(2).accept(this));
		}
		
		throw new IllegalArgumentException("No option available ");
	}

	@Override
	public Z3Formula visitEquality_expression(Equality_expressionContext ctx) {
		
		if(ctx.getChildCount()==1) {
			return ctx.getChild(0).accept(this); 
		}

		Z3Formula b = Z3Formula.getEmpty();
		ctx.getChild(2).accept(this);
		
		if(ctx.getChildCount()==3) {
			return Z3Formula.getPredicate(
					(Z3Expression) ctx.getChild(0).accept(this), 
					Z3Formula.getRelationalOperator(ctx.getChild(1).getText()), 
					(Z3Expression) ctx.getChild(2).accept(this));
			
		}

		throw new IllegalArgumentException("No option avalilable");
	}

	@Override
	public Z3Formula visitAnd_expression(And_expressionContext ctx) {
		if (ctx.getChildCount() == 1) {
			return ctx.getChild(0).accept(this);
		} else {
			Z3Formula part1 = ctx.getChild(0).accept(this);
			Z3Formula part2 = ctx.getChild(2).accept(this);
			return Z3Formula.getAnd(part1, part2);
		}
	}

	@Override
	public Z3Formula visitOr_expression(Or_expressionContext ctx) {
		if (ctx.getChildCount() == 1) {
			return ctx.getChild(0).accept(this);
		} else {
			return Z3Formula.getOr(ctx.getChild(0).accept(this), ctx.getChild(2).accept(this));
		}
	}

	@Override
	public Z3Formula visitExpression(ExpressionContext ctx) {
		Z3Formula b = Z3Formula.getEmpty();

		for (int i = 0; i < ctx.getChildCount(); i++) {
			if (ctx.getChild(i).accept(this) != null) {
				Z3Formula f = ctx.getChild(i).accept(this);

				if (!f.equals(Z3Formula.getEmpty())) {
					if (b.equals(Z3Formula.getEmpty())) {
						b = f;
					} else {
						throw new IllegalArgumentException("Can not change " + b);
					}
				}
			}
		}
		return b;
	}

	@Override
	public Z3Formula visitAssignment_expression(Assignment_expressionContext ctx) {
		Z3Formula b = Z3Formula.getEmpty();

		for (int i = 0; i < ctx.getChildCount(); i++) {

			Z3Formula f = ctx.getChild(i).accept(this);

			if (!f.equals(Z3Formula.getEmpty())) {
				if (b.equals(Z3Formula.getEmpty())) {
					b = f;
				} else {
					throw new IllegalArgumentException("Can not change " + b);
				}
			}
		}
		return b;
	}

	@Override
	public Z3Formula visitStatement(StatementContext ctx) {
		Z3Formula b = Z3Formula.getEmpty();

		for (int i = 0; i < ctx.getChildCount(); i++) {

			Z3Formula f = ctx.getChild(i).accept(this);

			if (!f.equals(Z3Formula.getEmpty())) {
				if (b.equals(Z3Formula.getEmpty())) {
					b = f;
				} else {
					throw new IllegalArgumentException("Can not change " + b);
				}
			}
		}
		return b;
	}

	@Override
	public Z3Formula visitStatement_list(Statement_listContext ctx) {
		Z3Formula b = Z3Formula.getEmpty();

		for (int i = 0; i < ctx.getChildCount(); i++) {

			Z3Formula f = ctx.getChild(i).accept(this);

			if (!f.equals(Z3Formula.getEmpty())) {
				if (b.equals(Z3Formula.getEmpty())) {
					b = f;
				} else {
					throw new IllegalArgumentException("Can not change " + b);
				}
			}
		}
		return b;
	}

	public abstract Z3Expression visitPrev_expression(Prev_expressionContext ctx);

	public abstract Z3Formula visitDur_expression(Dur_expressionContext ctx);

	@Override
	public Z3Formula visitVariabledefinition(VariabledefinitionContext ctx) {
		return Z3Formula.getEmpty();
	}

	@Override
	public Z3Expression visitVariableName(VariableNameContext ctx) {
		return Z3Formula.getVariable(ctx.getText());
	}

	@Override
	public Z3Expression visitIo(IoContext ctx) {
		return Z3Formula.getVariable(ctx.getText());
	}

	@Override
	public Z3Formula visitRequirement(RequirementContext ctx) {
		Z3Formula b = Z3Formula.getImplies(ctx.getChild(0).accept(this), ctx.getChild(2).accept(this));

		return b;
	}

	@Override
	public Z3Formula visitPrecondition(PreconditionContext ctx) {
		Z3Formula b = Z3Formula.getEmpty();

		for (int i = 0; i < ctx.getChildCount(); i++) {

			Z3Formula f = ctx.getChild(i).accept(this);
			

			if (!f.equals(Z3Formula.getEmpty())) {
				if (b.equals(Z3Formula.getEmpty())) {
					b = f;
				} else {
					throw new IllegalArgumentException("Can not change " + b);
				}
			}
		}
		return b;
	}

	@Override
	public Z3Formula visitPostcondition(PostconditionContext ctx) {
		Z3Formula b = Z3Formula.getEmpty();

		for (int i = 0; i < ctx.getChildCount(); i++) {

			Z3Formula f = ctx.getChild(i).accept(this);

			if (!f.equals(Z3Formula.getEmpty())) {
				if (b.equals(Z3Formula.getEmpty())) {
					b = f;
				} else {
					throw new IllegalArgumentException("Can not change " + b);
				}
			}
		}
		return b;
	}

	public Encoder getEncoder() {
		return encoder;
	}
}
