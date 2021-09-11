package ch3.annotated;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ch2.decoupled.HelloWorldMessageProvider;
import ch2.decoupled.MessageProvider;
import ch2.decoupled.MessageRenderer;
import ch2.decoupled.StandardOutMessageRenderer;

@Configuration
public class HelloWorldConfiguration {
	@Bean
	public MessageProvider provider() {
		return new HelloWorldMessageProvider();
	}
	
	@Bean
	public MessageRenderer renderer() {
		MessageRenderer renderer = new StandardOutMessageRenderer();
		renderer.setMessageProvider(provider());
		return renderer;
	}
}
