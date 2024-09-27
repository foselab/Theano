package requirements2Z3.rqt;

import java.util.HashSet;
import java.util.Set;

import requirements2Z3.visitors.RTVisitor;

public class Requirements {
	
	private Set<Requirement> requirements;
	
	public Requirements() {
		this.requirements=new HashSet<Requirement>();
	}
	
	public void add(Requirement r) {
		this.requirements.add(r);
	}

	public Set<Requirement> getRequirements(){
		return this.requirements;
	}
	
	public <T> T accept(RTVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
