package com.airtribe.learntrack.util;

public class InputValidator {

    // Check string (name, course, etc.)
    public static boolean isValidString(String input) {
        return input != null && !input.trim().isEmpty();
    }

    // Check email (basic validation)
    public static boolean isValidEmail(String email) {
        if (email == null) return false;
        return email.contains("@") && email.contains(".");
    }

    // Check phone number (basic)
    public static boolean isValidPhone(long phone) {
        return phone >= 1000000000L && phone <= 9999999999L;
    }

    // Check ID (studentId, courseId)
    public static boolean isValidId(int id) {
        return id > 0;
    }
}
