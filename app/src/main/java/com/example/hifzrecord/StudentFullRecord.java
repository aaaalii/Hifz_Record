package com.example.hifzrecord;

public class StudentFullRecord {

    int id;
    String name, age, sabaqSurah, sabaqStart, sabaqEnd, sabqiSurah, manzilSurah;

    public StudentFullRecord(){}

    public StudentFullRecord(int id, String name, String age, String sabaqSurah, String sabaqStart, String sabaqEnd, String sabqiSurah, String manzilSurah) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sabaqSurah = sabaqSurah;
        this.sabaqStart = sabaqStart;
        this.sabaqEnd = sabaqEnd;
        this.sabqiSurah = sabqiSurah;
        this.manzilSurah = manzilSurah;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "StudentFullRecord{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sabaqSurah='" + sabaqSurah + '\'' +
                ", sabaqStart='" + sabaqStart + '\'' +
                ", sabaqEnd='" + sabaqEnd + '\'' +
                ", sabqiSurah='" + sabqiSurah + '\'' +
                ", manzilSurah='" + manzilSurah + '\'' +
                '}';
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

    public String getSabaqSurah() {
        return sabaqSurah;
    }

    public void setSabaqSurah(String sabaqSurah) {
        this.sabaqSurah = sabaqSurah;
    }

    public String getSabaqStart() {
        return sabaqStart;
    }

    public void setSabaqStart(String sabaqStart) {
        this.sabaqStart = sabaqStart;
    }

    public String getSabaqEnd() {
        return sabaqEnd;
    }

    public void setSabaqEnd(String sabaqEnd) {
        this.sabaqEnd = sabaqEnd;
    }

    public String getSabqiSurah() {
        return sabqiSurah;
    }

    public void setSabqiSurah(String sabqiSurah) {
        this.sabqiSurah = sabqiSurah;
    }

    public String getManzilSurah() {
        return manzilSurah;
    }

    public void setManzilSurah(String manzilSurah) {
        this.manzilSurah = manzilSurah;
    }
}
