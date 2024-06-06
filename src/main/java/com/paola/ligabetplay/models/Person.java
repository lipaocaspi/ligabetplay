package com.paola.ligabetplay.models;

public class Person {
    int id;
    String name;
    int age;
    String nationality;

    public Person () {}

    public Person(int id, String name, int age, String nationality) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.nationality = nationality;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
