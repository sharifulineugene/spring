package ch3;

public class ContextualizedDependencyLookup implements ManagedComponent{
	private Dependency dependency;
	
	public void performLookup(Container container) {
		this.dependency = (Dependency)container.getDependency("myDependency");
	}
	
	@Override
	public String toString() {
		return dependency.toString();
	}
}
