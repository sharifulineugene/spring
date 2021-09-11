package ch3.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = "ch3.annotation")
@Configuration
public class HelloWorldConfiguration {

}
