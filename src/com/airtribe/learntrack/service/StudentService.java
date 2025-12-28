package com.airtribe.learntrack.service;

import com.airtribe.learntrack.entity.Student;
import com.airtribe.learntrack.exception.EntityNotFoundException;
import com.airtribe.learntrack.repository.StudentRepository;
import com.airtribe.learntrack.util.IdGenerator;
import com.airtribe.learntrack.util.InputValidator;
import java.util.List;

public class StudentService {

    private StudentRepository repository = new StudentRepository();

    public void addStudent(String name, String email, long phone, String course) {

        if (!InputValidator.isValidString(name)) {
            System.out.println("Invalid name");
            return;
        }

        if (!InputValidator.isValidEmail(email)) {
            System.out.println("Invalid email");
            return;
        }

        int id = IdGenerator.getNextStudentId();

        Student student = new Student(id, name, email, phone, course);
        repository.save(student);

        System.out.println("Student added successfully");
    }

    public void listStudents() {
        List<Student> students = repository.findAll();

        if (students.isEmpty()) {
            System.out.println("No students found");
            return;
        }

        for (Student s : students) {
            System.out.println(s);
        }
    }

    public Student findStudentById(int id) {
        Student s = repository.findById(id);

        if (s == null) {
            throw new EntityNotFoundException("Student with ID " + id + " not found");
        }
        return s;
    }

    public void deactivateStudent(int id) {
        Student s = findStudentById(id);
        s.setActive(false);
        System.out.println("Student deactivated");
    }
}
