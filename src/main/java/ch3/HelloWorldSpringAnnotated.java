package ch3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ch2.decoupled.MessageRenderer;
import ch3.annotated.HelloWorldConfiguration;

public class HelloWorldSpringAnnotated {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ch3.annotation.HelloWorldConfiguration.class);
		MessageRenderer mr = ctx.getBean("renderer", MessageRenderer.class);
		mr.render();
	}
}
