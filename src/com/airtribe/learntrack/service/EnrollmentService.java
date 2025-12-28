package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Course;
import com.airtribe.learntrack.entity.Enrollment;
import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.EnrollmentRepository;
import com.airtribe.learntrack.util.IdGenerator;

import java.util.List;

public class EnrollmentService {

    private EnrollmentRepository repository = new EnrollmentRepository();
    private StudentService studentService;
    private CourseService courseService;

    public EnrollmentService(StudentService studentService, CourseService courseService) {
        this.studentService = studentService;
        this.courseService = courseService;
    }

    // Enroll student into course
    public void enrollStudent(int studentId, int courseId) {

        Student student = studentService.findStudentById(studentId);
        Course course = courseService.findCourseById(courseId);

        int enrollmentId = IdGenerator.getNextEnrollmentId();
        Enrollment enrollment = new Enrollment(enrollmentId, student, course);

        repository.save(enrollment);
        System.out.println("Student enrolled successfully");
    }

    // View all enrollments
    public void listEnrollments() {
        List<Enrollment> enrollments = repository.findAll();

        if (enrollments.isEmpty()) {
            System.out.println("No enrollments found");
            return;
        }

        for (Enrollment e : enrollments) {
            System.out.println(e);
        }
    }


    public void completeEnrollment(int enrollmentId) {
        Enrollment e = findEnrollmentById(enrollmentId);
        e.complete();
        System.out.println("Enrollment completed");
    }


    public void cancelEnrollment(int enrollmentId) {
        Enrollment e = findEnrollmentById(enrollmentId);
        e.cancel();
        System.out.println("Enrollment cancelled");
    }


    private Enrollment findEnrollmentById(int id) {
        Enrollment e = repository.findById(id);
        if (e == null) {
            throw new EntityNotFoundException("Enrollment with ID " + id + " not found");
        }
        return e;
    }
}

