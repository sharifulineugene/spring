package ch4;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.annotation.PostConstruct;

public class SingerWithJSR250 {
    private static final String DEFAULT_NAME="Eric Capton";
    private String name;
    private int age = Integer.MIN_VALUE;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "SingerWithInterface{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @PostConstruct
    public void init() throws Exception{
        System.out.println("Initializing bean");
        if(name == null) {
            System.out.println("Using default name");
            name = DEFAULT_NAME;
        }
        if(age == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("You must set the age property of any beans of type "+ SingerWithJSR250.class);
        }
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-xml.xml");
        ctx.refresh();

        getBean("singerOne", ctx);
        getBean("singerTwo", ctx);
        getBean("singerThree", ctx);
    }

    public static SingerWithJSR250 getBean(String name, ApplicationContext ctx) {
        try {
            SingerWithJSR250 bean = ctx.getBean(name, SingerWithJSR250.class);
            System.out.println(bean);
            return bean;
        } catch(BeanCreationException ex) {
            System.out.println("An error occured in bean configuration: "
                    + ex.getMessage());
            return null;
        }
    }
}
