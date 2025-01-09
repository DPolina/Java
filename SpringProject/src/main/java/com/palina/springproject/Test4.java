package com.palina.springproject;

import org.springframework.context.support.ClassPathXmlApplicationContext;

// Bean scope
public class Test4 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = 
                new ClassPathXmlApplicationContext("applicationContext2.xml");
        
        // Дважды запросили bean Dog у контейнера: 
        Dog myDog = context.getBean("myPet", Dog.class);
        myDog.setName("Stella");
        Dog yourDog = context.getBean("myPet", Dog.class);
        yourDog.setName("Caelus");
        
        System.out.println(myDog.getName());
        System.out.println(yourDog.getName());
        // singleton: both lines will say "Caelus".
        // prototype: lines will be different.
        
        System.out.println("Переменные ссылаются на один и тот же объект? - "
                + (myDog == yourDog));
        System.out.println(myDog);
        System.out.println(yourDog);
        
        context.close();
    }  
}
