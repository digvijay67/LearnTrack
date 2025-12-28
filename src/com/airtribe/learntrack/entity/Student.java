package com.airtribe.learntrack.entity;

public class Student extends Person {

    private String course;

    public Student(int id, String name, String email, long phone, String course) {
        super(id, name, email, phone); // Person constructor call
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Name: " + name +
                ", Email: " + email +
                ", Phone: " + phone +
                ", Course: " + course +
                ", Status: " + (active ? "Active" : "Inactive");
    }
}
