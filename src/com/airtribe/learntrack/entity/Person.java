package com.airtribe.learntrack.entity;

public abstract class Person {

    protected int id;
    protected String name;
    protected String email;
    protected long phone;
    protected boolean active;


    public Person(int id, String name, String email, long phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.active = true;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public long getPhone() {
        return phone;
    }

    public boolean isActive() {
        return active;
    }


    public void setActive(boolean active) {
        this.active = active;
    }
}
