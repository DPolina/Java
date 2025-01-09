package com.palina.springproject;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConficWithAnnotations1 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = 
            new ClassPathXmlApplicationContext("applicationContext3.xml");
        // DI using annotations:
        Person person = context.getBean("personBin", Person.class);
        person.callYourPet();
        
//        Cat myCat = context.getBean("catBean", Cat.class);
//        //Cat myCat = context.getBean("cat", Cat.class);
//        myCat.say();:

        System.out.println(person.getSurname() + ", " + person.getAge());

        context.close();
    }
}
