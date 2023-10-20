package requirements2Z3.visitors.translators;

import generated.matlabParser.Dur_expressionContext;
import generated.matlabVisitor;
import requirements2Z3.encodings.Encoder;

public class UeArVs extends UnboundedVisitor implements matlabVisitor<String> {

	public UeArVs(Encoder encoder) {
		super(encoder);
	}


	@Override
	public String visitDur_expression(Dur_expressionContext ctx) {
		String constant=ctx.getChild(5).getText();
		return "Exists(j,And(j<=i,tau[i]-tau[j]>="+constant+",ForAll(k,Implies(And(j<=k,k<=i),"+ctx.getChild(2).accept(this)+"))))";
	}
	
}
