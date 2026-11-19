package com.example.studentmanagement.controller;

import com.example.studentmanagement.dto.CreateStudentRequest;
import com.example.studentmanagement.dto.UpdateScoresAndSkillsRequest;
import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@Valid @RequestBody CreateStudentRequest request) {
        Student student = studentService.addStudent(request);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{studentId}")
                .buildAndExpand(student.getStudentId())
                .toUri();
        return ResponseEntity.created(location).body(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable Integer studentId) {
        return studentService.getStudent(studentId);
    }

    @PutMapping("/{studentId}")
    public Student updateScoresAndSkills(
            @PathVariable Integer studentId,
            @Valid @RequestBody UpdateScoresAndSkillsRequest request) {
        return studentService.updateScoresAndSkills(studentId, request);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer studentId) {
        studentService.deleteStudent(studentId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/merit-list")
    public List<Student> getMeritList() {
        return studentService.getMeritList();
    }
}
