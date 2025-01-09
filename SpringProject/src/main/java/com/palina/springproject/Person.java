package com.palina.springproject;

public class Person {
    private Pet pet;
    private String surname;
    private int age;
    
    // DI using constructor:
//    public Person(Pet pet) {
//        System.out.println("Person bean is created");
//        this.pet = pet;
//    }
    
    public Person() {
        System.out.println("[Person bean is created]");
    }
    
    // DI using setters:
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
