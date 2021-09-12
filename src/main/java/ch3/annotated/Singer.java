package ch3.annotated;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class Singer extends ch3.Singer{
	private String lyric = "blablabla@"+hashCode();
	public void sing() {
		System.out.println(lyric);
	}
}
