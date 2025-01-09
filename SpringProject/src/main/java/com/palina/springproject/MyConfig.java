package com.palina.springproject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySource("classpath:myApp.properties")
//@ComponentScan("com.palina.springproject") // Способ 1
public class MyConfig {
    @Bean // Способ 2
    @Scope("singleton")
    public Pet catBean() { // catBean - и есть beanID
        //System.out.println("!!!");
        return new Cat();
    }
    
    @Bean
    public Person personBean() {
        return new Person(catBean()); // DI
    }
}
