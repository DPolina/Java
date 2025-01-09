package com.palina.springproject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component // Default beanID - dog.
@Scope("singleton")
public class Dog implements Pet{
    private String name;
    
    public Dog(){
        System.out.println("[Dog bean is created]");
    }
    
    @Override
    public void say(){
        System.out.println("Bow-Wow");
    }
    
    public void init() {
        System.out.println("[Class Dog: init method]");
    }
    
    public void destroy() {
        System.out.println("[Class Dog: destroy method]");
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}
