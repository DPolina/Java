package com.palina.springproject;

public class Test1 {

    public static void main(String[] args) {
        //Pet pet = new Dog();
        Pet pet = new Cat();
        pet.say();
    }
}

// Чтобы каждый раз не менять код, для того, чтобы вызвать метод say для каждого
// отдельного Pet (чтобы не было необходимости в перекомпиляции кода), надо вынести 
// эти детали (например, какое животное будет говорить) в отдельный файл - 
// конфигурационный файл. В дальнейшем меняться будет этот файл, а не код.

// В config-файле мы опишем, что из себя представляют объекты. Созданием же этих
// объектов будет заниматься Spring Framework.

// Spring Container is responsible for creating and managing objects according to 
// the config-file. Container contains all created object. We acces Container to 
// get objects.

// We won't create objects in Test1. Instead, we'll get them from Spring Container.