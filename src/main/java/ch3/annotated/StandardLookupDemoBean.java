package ch3.annotated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import ch3.DemoBean;

@Component("standardLookupBean")
public class StandardLookupDemoBean implements DemoBean{
	@Autowired
	@Qualifier("singer")
	private Singer mySinger;

	@Override
	public ch3.Singer getMySinger() {
		return mySinger;
	}

	@Override
	public void doSomething() {
		mySinger.sing();
	}
}
