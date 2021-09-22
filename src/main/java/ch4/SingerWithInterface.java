package ch4;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SingerWithInterface implements InitializingBean {
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
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing bean");
        if(name == null) {
            System.out.println("Using default name");
            name = DEFAULT_NAME;
        }
        if(age == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("You must set the age property of any beans of type "+SingerWithInterface.class);
        }
    }

    @Override
    public String toString() {
        return "SingerWithInterface{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-xml.xml");
        ctx.refresh();

        getBean("singerOne", ctx);
        getBean("singerTwo", ctx);
        getBean("singerThree", ctx);
    }

    public static SingerWithInterface getBean(String name, ApplicationContext ctx) {
        try {
            SingerWithInterface bean = ctx.getBean(name, SingerWithInterface.class);
            return bean;
        } catch(BeanCreationException ex) {
            System.out.println("An error occured in bean configuration: "
                    + ex.getMessage());
            return null;
        }
    }
}
