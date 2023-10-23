package requirements2Z3.visitors;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
public class GetRequirementsVariableVisitor extends matlabBaseVisitor<List<RequirementContext>> {

	private String variable;

	public GetRequirementsVariableVisitor(String variable) {
		this.variable = variable;
	}

	@Override
	public List<RequirementContext> visitRequirementsdefinitions(RequirementsdefinitionsContext ctx) {
		return this.visitChildren(ctx);
	}

	@Override
	public List<RequirementContext> visitTerminal(TerminalNode node) {
		return new ArrayList<>();
	}

	@Override
	public List<RequirementContext> visitChildren(RuleNode node) {
		List<RequirementContext> ret = new ArrayList<>();

		for (int i = 0; i < node.getChildCount(); i++) {

			ret.addAll(node.getChild(i).accept(this));
		}

		return ret;
	}

	protected List<RequirementContext> aggregateResult(List<RequirementContext> aggregate,
			List<RequirementContext> nextResult) {

		List<RequirementContext> ret = new ArrayList<>();
		ret.addAll(aggregate);
		ret.addAll(nextResult);
		return ret;
	}
	
	

	@Override
	public List<RequirementContext>  visitRequirement(RequirementContext ctx)  {
		List<RequirementContext> ret = new ArrayList<>();

		Set<String> variables = new HashSet<>();
		variables.add(this.variable);

		if (ctx.accept(new PreconditionContainsVariableVisitor(variables))) {
			ret.add(ctx);
		}
		return ret;
	}

}
