package com.example.hifzrecord;

public class Student {
    private int id;
    private String name;
    private int age;
    //private String Class;

    public Student() {
    }

    public Student(String name, int age){
        //this.id = id;
        this.name=name;
        this.age=age;
        //this.Class = Class;
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

//    public String getClasss(){
//        return Class;
//    }
//
//    public void setClass(String Class) {
//        this.Class = Class;
//    }
}
