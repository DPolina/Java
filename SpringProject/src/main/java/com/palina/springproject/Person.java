package com.palina.springproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("personBin")
public class Person {
    // (3. @Autowired для поля, рефлексия)
    @Autowired
    @Qualifier("dog")
    private Pet pet;
    @Value("${person.surname}")
    private String surname;
    @Value("${person.age}")
    private int age;
    
    // DI using constructor; Annotations:
    // (1. @Autowired для конструктора)
//    @Autowired
//    //public Person(@Qualifier("dog") Pet pet) {
//    public Person(Pet pet) {
//        System.out.println("[Person bean is created]");
//        this.pet = pet;
//    }
    
    public Person() {
        System.out.println("[Person bean is created]");
    }
    
    // DI using setters:
    // (2. @Autowired для сеттера)
    //@Autowired
    //@Qualifier("dog")
    public void setPet(Pet pet) {
        // pet -> setPet (p -> P, set + Pet = setPet)
        System.out.println("[Class Person: set pet]");
        this.pet = pet;
    }
    
    // String Injection
    public void setSurname(String surname) {
        System.out.println("[Class Person: set surname]");
        this.surname = surname;
    }
    
    public String getSurname() {
        return surname;
    }
    
    public void setAge(int age) {
        System.out.println("[Class Person: set age]");
        this.age = age;
    }
    
    public int getAge() {
        return age;
    }
    
    public void callYourPet() {
        System.out.println("Hello, my lovely Pet!");
        pet.say();
    }
}
