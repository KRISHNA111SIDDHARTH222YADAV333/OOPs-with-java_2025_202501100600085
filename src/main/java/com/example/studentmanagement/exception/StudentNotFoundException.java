package com.example.studentmanagement.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(Integer studentId) {
        super("Student with ID " + studentId + " was not found");
    }
}
