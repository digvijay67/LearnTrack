package com.airtribe.learntrack;

import com.airtribe.learntrack.service.*;
import com.airtribe.learntrack.constants.MenuOptions;
import com.airtribe.learntrack.exception.InvalidInputException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        EnrollmentService enrollmentService = new EnrollmentService(studentService, courseService);

        while (true) {
            MenuOptions.printMainMenu();
            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Enter a number.");
                continue;
            }

            try {
                switch (choice) {

                    case 1 -> {
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter email: ");
                        String email = sc.nextLine();
                        System.out.print("Enter phone: ");
                        long phone = Long.parseLong(sc.nextLine());
                        System.out.print("Enter course: ");
                        String course = sc.nextLine();
                        studentService.addStudent(name, email, phone, course);
                    }
                    case 2 -> studentService.listStudents();
                    case 3 -> {
                        System.out.print("Enter Student ID to deactivate: ");
                        int id = Integer.parseInt(sc.nextLine());
                        studentService.deactivateStudent(id);
                    }


                    case 4 -> {
                        System.out.print("Enter course title: ");
                        String title = sc.nextLine();
                        System.out.print("Enter course description: ");
                        String description = sc.nextLine();
                        System.out.print("Enter duration in weeks: ");
                        int duration = Integer.parseInt(sc.nextLine());
                        courseService.addCourse(title, description, duration);
                    }
                    case 5 -> courseService.listCourses();
                    case 6 -> {
                        System.out.print("Enter Course ID to deactivate: ");
                        int id = Integer.parseInt(sc.nextLine());
                        courseService.deactivateCourse(id);
                    }


                    case 7 -> {
                        System.out.print("Enter Student ID: ");
                        int sid = Integer.parseInt(sc.nextLine());
                        System.out.print("Enter Course ID: ");
                        int cid = Integer.parseInt(sc.nextLine());
                        enrollmentService.enrollStudent(sid, cid);
                    }
                    case 8 -> enrollmentService.listEnrollments();
                    case 9 -> {
                        System.out.print("Enter Enrollment ID to complete: ");
                        int eid = Integer.parseInt(sc.nextLine());
                        enrollmentService.completeEnrollment(eid);
                    }
                    case 10 -> {
                        System.out.print("Enter Enrollment ID to cancel: ");
                        int eid = Integer.parseInt(sc.nextLine());
                        enrollmentService.cancelEnrollment(eid);
                    }

                    case 0 -> {
                        System.out.println("Bye!");
                        return;
                    }

                    default -> System.out.println("Invalid choice");
                }
            } catch (InvalidInputException | NumberFormatException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
