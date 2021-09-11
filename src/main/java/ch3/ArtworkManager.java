package ch3;

import java.util.Collection;

import org.springframework.stereotype.Component;

public class ArtworkManager {
	private Collection<ArtworkSender> senders;
	public ArtworkManager(Collection<ArtworkSender> senders) {
		this.senders = senders;
	}
	
}
