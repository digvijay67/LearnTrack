package com.airtribe.learntrack.entity;

import com.airtribe.learntrack.enums.EnrollmentStatus;
import java.time.LocalDate;

public class Enrollment {

    private int id;
    private Student student;
    private Course course;
    private LocalDate enrollmentDate;
    private EnrollmentStatus status;

    public Enrollment(int id, Student student, Course course) {
        this.id = id;
        this.student = student;
        this.course = course;
        this.enrollmentDate = LocalDate.now();
        this.status = EnrollmentStatus.ENROLLED;
    }


    public int getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public EnrollmentStatus getStatus() {
        return status;
    }


    public void complete() {
        this.status = EnrollmentStatus.COMPLETED;
    }

    public void cancel() {
        this.status = EnrollmentStatus.CANCELLED;
    }

    @Override
    public String toString() {
        return "Enrollment ID: " + id +
                ", Student: " + student.getName() +
                ", Course: " + course.getTitle() +
                ", Date: " + enrollmentDate +
                ", Status: " + status;
    }
}
