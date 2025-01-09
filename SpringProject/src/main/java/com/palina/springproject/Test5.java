package com.palina.springproject;

import org.springframework.context.support.ClassPathXmlApplicationContext;

// init and destroy methods
public class Test5 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = 
                    new ClassPathXmlApplicationContext("applicationContext2.xml");

        Dog myDog = context.getBean("myPet", Dog.class);
        myDog.say();
        Dog yourDog = context.getBean("myPet", Dog.class);
        yourDog.say();

        context.close();
    }
}

// - У данных методов access modifier может быть любым
// - У данных методов return type может быть любым. Но из-за того, что 
//   возвращаемое значение мы никак не можем использовать, чаще всего return 
//   type - это void.
// - Называться данные методы могут как угодно.
// - В данных методах не должно быть параметров.
