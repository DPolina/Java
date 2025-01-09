package com.palina.springproject;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {
    public static void main(String[] args) {
        //Pet pet = new Dog();
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        //Pet pet = context.getBean("myPet", Pet.class);
        
        //Person person = new Person(pet); // Hardcoded dependecy
        // Dependency Injection:
        Person person = context.getBean("myPerson", Person.class);
        person.callYourPet();
        
        System.out.println(person.getSurname() + ", " + person.getAge());
        
        context.close();
    }
}
