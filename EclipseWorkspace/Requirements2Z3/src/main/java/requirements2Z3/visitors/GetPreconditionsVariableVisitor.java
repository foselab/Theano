package requirements2Z3.visitors;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import generated.matlabBaseVisitor;
import generated.matlabParser.PreconditionContext;
import generated.matlabParser.RequirementsdefinitionsContext;

/**
 * This visitor is used to define the variables of the Z3 files based on the
 * variables used in the Requirements Table
 */
public class GetPreconditionsVariableVisitor extends matlabBaseVisitor<Set<PreconditionContext>> {

	private String variable;

	public GetPreconditionsVariableVisitor(String variable) {
		this.variable = variable;
	}

	@Override
	public Set<PreconditionContext> visitRequirementsdefinitions(RequirementsdefinitionsContext ctx) {
		return this.visitChildren(ctx);
	}

	@Override
	public Set<PreconditionContext> visitTerminal(TerminalNode node) {
		return new HashSet<>();
	}

	@Override
	public Set<PreconditionContext> visitChildren(RuleNode node) {
		Set<PreconditionContext> ret = new HashSet<>();

		for (int i = 0; i < node.getChildCount(); i++) {

			ret.addAll(node.getChild(i).accept(this));
		}

		return ret;
	}

	protected Set<PreconditionContext> aggregateResult(Set<PreconditionContext> aggregate,
			Set<PreconditionContext> nextResult) {

		Set<PreconditionContext> ret = new HashSet<>();
		ret.addAll(aggregate);
		ret.addAll(nextResult);
		return ret;
	}

	@Override
	public Set<PreconditionContext> visitPrecondition(PreconditionContext ctx) {
		Set<PreconditionContext> ret = new HashSet<>();

		Set<String> variables = new HashSet<>();
		variables.add(this.variable);

		if (ctx.accept(new PreconditionContainsVariableVisitor(variables))) {
			ret.add(ctx);
		}
		return ret;
	}

}
