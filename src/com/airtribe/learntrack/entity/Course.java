package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.enums.CourseStatus;

public class Course {

    private int id;
    private String title;
    private String description;
    private int durationInWeeks;
    private CourseStatus status;

    public Course(int id, String title, String description, int durationInWeeks) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.durationInWeeks = durationInWeeks;
        this.status = CourseStatus.ACTIVE;
    }


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public CourseStatus getStatus() {
        return status;
    }


    public void activate() {
        this.status = CourseStatus.ACTIVE;
    }

    public void deactivate() {
        this.status = CourseStatus.INACTIVE;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Title: " + title +
                ", Duration: " + durationInWeeks + " weeks" +
                ", Status: " + status;
    }
}

