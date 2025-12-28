package com.airtribe.learntrack.constants;

public class MenuOptions {

    public static void printMainMenu() {
        System.out.println("\n===== LearnTrack Menu =====");
        System.out.println("1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Deactivate Student");

        System.out.println("4. Add Course");
        System.out.println("5. View All Courses");
        System.out.println("6. Deactivate Course");

        System.out.println("7. Enroll Student in Course");
        System.out.println("8. View All Enrollments");
        System.out.println("9. Complete Enrollment");
        System.out.println("10. Cancel Enrollment");

        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
    }
}
