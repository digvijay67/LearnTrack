package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.CourseRepository;
import com.airtribe.learntrack.util.IdGenerator;
import com.airtribe.learntrack.util.InputValidator;

import java.util.List;

public class CourseService {

    private CourseRepository repository = new CourseRepository();

    // Add new course
    public void addCourse(String title, String description, int durationInWeeks) {

        if (!InputValidator.isValidString(title)) {
            System.out.println("Invalid course title");
            return;
        }

        if (!InputValidator.isValidString(description)) {
            System.out.println("Invalid course description");
            return;
        }

        if (durationInWeeks <= 0) {
            System.out.println("Invalid course duration");
            return;
        }

        int id = IdGenerator.getNextCourseId();
        Course course = new Course(id, title, description, durationInWeeks);

        repository.save(course);
        System.out.println("Course added successfully");
    }

    // List all courses
    public void listCourses() {
        List<Course> courses = repository.findAll();

        if (courses.isEmpty()) {
            System.out.println("No courses available");
            return;
        }

        for (Course c : courses) {
            System.out.println(c);
        }
    }

    // Find course by ID
    public Course findCourseById(int id) {
        Course course = repository.findById(id);

        if (course == null) {
            throw new EntityNotFoundException("Course with ID " + id + " not found");
        }
        return course;
    }

    // Deactivate course
    public void deactivateCourse(int id) {
        Course course = findCourseById(id);
        course.deactivate();
        System.out.println("Course deactivated");
    }

    // Activate course
    public void activateCourse(int id) {
        Course course = findCourseById(id);
        course.activate();
        System.out.println("Course activated");
    }
}