package ch3.annotation;

import org.springframework.stereotype.Component;

import ch2.decoupled.MessageProvider;

@Component("provider")
public class HelloWorldMessageProvider implements MessageProvider{
	public String getMessage() {
		return "Hello World!";
	}
}
