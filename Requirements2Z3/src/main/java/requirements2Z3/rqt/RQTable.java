package requirements2Z3.rqt;

import requirements2Z3.visitors.RQTableVisitor;

public class RQTable {

	private final Requirements requirements;
	private final Variables variables;
	
	public RQTable(Variables variables, Requirements requirements) {
		this.requirements=requirements;
		this.variables=variables;
	}
	
	public <T> T accept(RQTableVisitor<T> visitor) {
		return visitor.visit(this);
	}

	public Requirements getRequirements() {
		return requirements;
	}

	public Variables getVariables() {
		return variables;
	}
}
