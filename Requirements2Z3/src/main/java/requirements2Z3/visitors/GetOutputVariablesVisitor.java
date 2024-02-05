package requirements2Z3.visitors;

import java.util.HashSet;
import java.util.Set;

import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import generated.matlabBaseVisitor;
import generated.matlabParser.RequirementsdefinitionsContext;
import generated.matlabParser.VariabledefinitionContext;

/**
 * This visitor is used to define the variables of the Z3 files based on the
 * variables used in the Requirements Table
 */
public class GetOutputVariablesVisitor extends matlabBaseVisitor<Set<String>> {
	
	
	
	@Override
	public Set<String> visitVariabledefinition(VariabledefinitionContext ctx) {
		Set<String> ret=new HashSet<>();
		if(ctx.getChild(4).getChild(0).getText().equals("output")) {
			ret.add(ctx.getChild(0).getChild(0).getText());
		}
		return ret;
	}
	
	@Override
	public Set<String> visitRequirementsdefinitions(RequirementsdefinitionsContext ctx)  {
		return this.visitChildren(ctx);
	}
	
	@Override
	public Set<String> visitTerminal(TerminalNode node) {
		return new HashSet<>();
	}
	
	@Override
	public Set<String> visitChildren(RuleNode node) {
		Set<String> ret=new HashSet<>();

		for (int i = 0; i < node.getChildCount(); i++) {
			
			ret.addAll(node.getChild(i).accept(this));
		}

		return ret;
	}


	protected Set<String> aggregateResult(Set<String> aggregate, Set<String> nextResult) {
		
		Set<String> ret=new HashSet<>();
		ret.addAll(aggregate);
		ret.addAll(nextResult);
		return ret;
	}

}
