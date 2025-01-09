package com.palina.springproject;

import org.springframework.stereotype.Component;

//@Component("catBean")
//@Component
public class Cat implements Pet {
    
    public Cat(){
        System.out.println("[Cat bean is created]");
    }
    
    @Override
    public void say() {
        System.out.println("Meow");
    }
}

// Если к аннотации @Component не прописать bean id, то бину будет назначен 
// дефолтный id. Дефолтный bean id получается из имени класса, заменяя его 
// первую заглавную букву на прописную. Пример:
// class Cat ----> cat
// class FavoriteSong ----> favoriteSong
// class SQLTest ----> SQLTest