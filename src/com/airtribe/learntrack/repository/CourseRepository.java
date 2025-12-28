package com.airtribe.learntrack.repository;

import com.airtribe.learntrack.entity.Course;
import java.util.*;

public class CourseRepository {

    private List<Course> courses = new ArrayList<>();

    public void save(Course c) { courses.add(c); }

    public Course findById(int id) {
        for (Course c : courses) {
            if (c.getId() == id) return c;
        }
        return null;
    }

    public List<Course> findAll() {
        return new ArrayList<>(courses);
    }

}
