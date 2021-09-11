package ch3.annotated;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class InjectSimpleSpel {
	private String name;
	private int age;
	private float height;
	private boolean programmer;
	private Long ageInSeconds;
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public float getHeight() {
		return height;
	}
	
	public boolean isProgrammer() {
		return programmer;
	}
	
	public Long getAgeInSeconds() {
		return ageInSeconds;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public void setProgrammer(boolean programmer) {
		this.programmer = programmer;
	}

	public void setAgeInSeconds(Long ageInSeconds) {
		this.ageInSeconds = ageInSeconds;
	}
	
	@Override
	public String toString() {
		return "InjectSimpleSpel [name=" + name + ", age=" + age + ", height=" + height + ", programmer=" + programmer
				+ ", ageInSeconds=" + ageInSeconds + "]";
	}

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("spring/app-context-spel.xml");
		ctx.refresh();
		InjectSimpleSpel simple = ctx.getBean("injectSimpleSpel", InjectSimpleSpel.class);
		System.out.println(simple);
		ctx.close();
	}
	
}
