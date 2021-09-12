package ch3;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class MethodReplacementDemo {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring/app-context-xml.xml");
		ctx.refresh();
		
		ReplacementTarget replacementTarget = ctx.getBean("replacementTarget", ReplacementTarget.class);
		ReplacementTarget standardTarget = ctx.getBean("standardTarget", ReplacementTarget.class);
		
		displayInfo(replacementTarget);
		displayInfo(standardTarget);
		
		ctx.close();
	}
	
	private static void displayInfo(ReplacementTarget target) {
		System.out.println(target.formatMessage("Thanks for playing, try again!"));
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start("perfTest");
		for(int x = 0; x < 100000; ++x) {
			String out = target.formatMessage("No filter in my head");
		}
		stopWatch.stop();
		
		System.out.println("100000 invocations took: "+stopWatch.getTotalTimeMillis()+" ms");
	}
}
