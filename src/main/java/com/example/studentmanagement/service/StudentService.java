package com.example.studentmanagement.service;

import com.example.studentmanagement.dto.CreateStudentRequest;
import com.example.studentmanagement.dto.UpdateScoresAndSkillsRequest;
import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.exception.StudentNotFoundException;
import com.example.studentmanagement.repository.StudentRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Comparator;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    public Student addStudent(CreateStudentRequest request) {
        Student student = new Student();
        student.setStudentId(request.studentId());
        student.setStudentName(request.studentName());
        student.setEmail(request.email());
        student.setCourseName(request.courseName());
        student.setProgrammingScore(request.programmingScore());
        student.setMathematicsScore(request.mathematicsScore());
        student.setSkills(request.skills());
        return studentRepository.saveAndFlush(student);
    }

    @Transactional(readOnly = true)
    public List<Student> getAllStudents() {
        return studentRepository.findAll(Sort.by("studentId").ascending());
    }

    @Transactional(readOnly = true)
    public Student getStudent(Integer studentId) {
        return findStudent(studentId);
    }

    @Transactional
    public Student updateScoresAndSkills(Integer studentId, UpdateScoresAndSkillsRequest request) {
        Student student = findStudent(studentId);
        student.setProgrammingScore(request.programmingScore());
        student.setMathematicsScore(request.mathematicsScore());
        student.setSkills(request.skills());
        return studentRepository.save(student);
    }

    @Transactional
    public void deleteStudent(Integer studentId) {
        studentRepository.delete(findStudent(studentId));
    }

    @Transactional(readOnly = true)
    public List<Student> getMeritList() {
        return studentRepository.findAll().stream()
                .sorted(Comparator
                        .comparing(StudentService::averageScore, Comparator.reverseOrder())
                        .thenComparing(Student::getStudentId))
                .toList();
    }

    private Student findStudent(Integer studentId) {
        return studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException(studentId));
    }

    private static BigDecimal averageScore(Student student) {
        BigDecimal sum = BigDecimal.ZERO;
        int scoreCount = 0;
        if (student.getProgrammingScore() != null) {
            sum = sum.add(student.getProgrammingScore());
            scoreCount++;
        }
        if (student.getMathematicsScore() != null) {
            sum = sum.add(student.getMathematicsScore());
            scoreCount++;
        }
        return scoreCount == 0
                ? BigDecimal.ZERO
                : sum.divide(BigDecimal.valueOf(scoreCount), MathContext.DECIMAL128);
    }
}
