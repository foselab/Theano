package requirements2Z3.rqt;

import java.util.HashSet;
import java.util.Set;

import requirements2Z3.visitors.RQTableVisitor;

public class Variables {

	private Set<Variable> vars;
	
	
	public Variables() {
		vars=new HashSet<Variable>();
	}
	
	public void add(Variable v) {
		this.vars.add(v);	
	}
	
	public Set<Variable> getVariables(){
		return this.vars;
	}
	
	public <T> T accept(RQTableVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
