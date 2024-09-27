package requirements2Z3.rqt;

import requirements2Z3.visitors.RTVisitor;

public class Variable {

	private final String name;

	private final String type;

	private final String inputOutput;

	public Variable(String name, String type, String inputOutput) {
		this.name = name;
		this.type = type;
		this.inputOutput = inputOutput;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getInputOutput() {
		return inputOutput;
	}

	public <T> T accept(RTVisitor<T> visitor) {
		return visitor.visit(this);
	}

}
