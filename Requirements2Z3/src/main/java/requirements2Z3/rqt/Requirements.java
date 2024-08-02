package requirements2Z3.rqt;

import java.util.HashSet;
import java.util.Set;

import requirements2Z3.visitors.RQTableVisitor;

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
	
	public <T> T accept(RQTableVisitor<T> visitor) {
		return visitor.visit(this);
	}
}
