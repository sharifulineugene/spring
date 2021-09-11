package ch3.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ch2.decoupled.MessageProvider;
import ch2.decoupled.MessageRenderer;

@Service("renderer")
public class StandardOutMessageRenderer implements MessageRenderer{
	private MessageProvider messageProvider;

	public void render() {
		if(messageProvider == null) {
			throw new RuntimeException("You must set the "
					+ "property messageProvider of class: "
					+ StandardOutMessageRenderer.class.getName());
		}
		System.out.println(messageProvider.getMessage());
	}
	
	@Autowired
	public void setMessageProvider(@Qualifier(value = "provider") MessageProvider provider) {
		this.messageProvider = provider;
	}

	public MessageProvider getMessageProvider() {
		return this.messageProvider;
	}
	
	
}
