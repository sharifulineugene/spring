package ch3.xml;

import ch2.decoupled.MessageProvider;

public class ConfigurableMessageProvider implements MessageProvider{
	private String message;
	
	public ConfigurableMessageProvider(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}
	
	
}
