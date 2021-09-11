package ch3;

import org.springframework.context.support.GenericXmlApplicationContext;

import ch2.decoupled.MessageRenderer;

public class DeclareSpringComponents {
	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring/app-context-annotation.xml");
		ctx.refresh();
		MessageRenderer messageRenderer = ctx.getBean("renderer", MessageRenderer.class);
		messageRenderer.render();
		ctx.close();
	}
}
