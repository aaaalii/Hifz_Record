package com.example.hifzrecord;

public class Student {
    private int id;
    private String name;
    private String  age;
    private String Class;

    public Student() {
    }

    public Student(int id, String name, String age, String clas){
        this.id = id;
        this.name=name;
        this.age=age;
        this.Class = clas;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getClas(){
        return Class;
    }

    public void setClass(String Class) {
        this.Class = Class;
    }
}
