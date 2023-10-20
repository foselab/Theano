package requirements2Z3.visitors;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import generated.matlabBaseVisitor;
import generated.matlabParser.RequirementContext;
import generated.matlabParser.RequirementsdefinitionsContext;

/**
 * This visitor is used to define the variables of the Z3 files based on the
 * variables used in the Requirements Table
 */
public class GetRequirementsVariableVisitor extends matlabBaseVisitor<Set<RequirementContext>> {

	private String variable;

	public GetRequirementsVariableVisitor(String variable) {
		this.variable = variable;
	}

	@Override
	public Set<RequirementContext> visitRequirementsdefinitions(RequirementsdefinitionsContext ctx) {
		return this.visitChildren(ctx);
	}

	@Override
	public Set<RequirementContext> visitTerminal(TerminalNode node) {
		return new HashSet<>();
	}

	@Override
	public Set<RequirementContext> visitChildren(RuleNode node) {
		Set<RequirementContext> ret = new HashSet<>();

		for (int i = 0; i < node.getChildCount(); i++) {

			ret.addAll(node.getChild(i).accept(this));
		}

		return ret;
	}

	protected Set<RequirementContext> aggregateResult(Set<RequirementContext> aggregate,
			Set<RequirementContext> nextResult) {

		Set<RequirementContext> ret = new HashSet<>();
		ret.addAll(aggregate);
		ret.addAll(nextResult);
		return ret;
	}

	@Override
	public Set<RequirementContext>  visitRequirement(RequirementContext ctx)  {
		Set<RequirementContext> ret = new HashSet<>();

		Set<String> variables = new HashSet<>();
		variables.add(this.variable);

		if (ctx.accept(new PreconditionContainsVariableVisitor(variables))) {
			ret.add(ctx);
		}
		return ret;
	}

}
