package ch3.annotated;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

import ch3.DemoBean;

@Component("abstractLookupBean")
public class AbstractLookupDemoBean implements DemoBean{
	@Lookup("singer")
	public ch3.Singer getMySinger() {
		return null;
	}

	@Override
	public void doSomething() {
		getMySinger().sing();
	}
	
}
