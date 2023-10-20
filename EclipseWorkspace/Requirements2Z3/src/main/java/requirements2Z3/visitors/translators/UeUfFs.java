package requirements2Z3.visitors.translators;

import generated.matlabParser.Dur_expressionContext;
import generated.matlabVisitor;
import requirements2Z3.encodings.Encoder;

public class UeUfFs extends UnboundedVisitor implements matlabVisitor<String> {

	public UeUfFs(Encoder encoder) {
		super(encoder);
	}

	@Override
	public String visitDur_expression(Dur_expressionContext ctx) {

		String constant = ctx.getChild(5).getText();

		String part1 = "tau[i]>=" + constant;
		String part2 = constant + ">=Ts";
		String part3 = "ForAll(k,Implies(And(i-" + constant + "/Ts<=k,k<=i)," + ctx.getChild(2).accept(this) + "))";

		return "And(" + part1 + "," + part2 + "," + part3 + ")";

	}

}
