package requirements2Z3.encodings;

import org.apache.commons.lang3.StringUtils;

import requirements2Z3.encodings.step.StepEncoder;
import requirements2Z3.z3formulae.Z3Expression;
import requirements2Z3.z3formulae.Z3Formula;

/**
 * Returns the encoding of a Variable Step trace
 */
public class UnboundedEncoder extends Encoder {


	/**
	 * Creates a UnboundedVariableStepTraceEncoder
	 */
	public UnboundedEncoder(StepEncoder stepEncoder) {
		super(stepEncoder);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getMonotonicityConstraint() {
		return "And("
					+ "ForAll(j,Implies(j>=0,("+this.getStepEncoder().getTracePositionMonotonicConstraint("tau", String.valueOf("j"))+"))"
							+ "),"
					+ this.getTracePosition("tau","0")+"==0"
				+ ")";
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Z3Formula getIsStartup(String signalname, String position) {
		if (!StringUtils.isNumeric(position)) {
			return Z3Formula.getPredicate(this.getTracePosition("tau", position),
					Z3Formula.getRelationalOperator("=="), Z3Formula.getConstant("0"));
		} else {
			throw new IllegalArgumentException("The position to be considered by the unbounded encoding should not be numeric");
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	public Z3Expression getPrevValue(String signalname, String position) {
		if (!StringUtils.isNumeric(position)) {
			return Z3Formula.getConstant("((" + position + "==0)*("
					+ this.getTracePosition(signalname, position) + ")+(" + position + ">0)*("
					+ this.getTracePosition(signalname, position + "-1") + "))");
		} else {
			
			throw new IllegalArgumentException("The position for the unbounded encoding can not be numeric");
		}
	}
}
