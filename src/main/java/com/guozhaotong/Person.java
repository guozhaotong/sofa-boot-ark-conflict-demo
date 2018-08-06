package com.guozhaotong;

public class Person {
    private String name;
    private int age;
    private String description;

    public Person(String name, int age, String description) {
        this.name = name;
        this.age = age;
        this.description = description;
    }

    public Person() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return "Person{name='" + this.name + '\'' + ", age=" + this.age + ", description='" + this.description + '\'' + '}';
    }
}
