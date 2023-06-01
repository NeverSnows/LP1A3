package com.example.javafx_newproject;

public class Animal {
    private final int age;
    private final String name;
    private final String description;
    private final AnimalType type;

    public Animal( int age, String name, String description, AnimalType type) {
        this.age = age;
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDescription() {
        return description;
    }

    public AnimalType getType() {
        return type;
    }

    public String getFormatedType(){
        return type.toString().charAt(0) + type.toString().substring(1).toLowerCase();
    }
}
