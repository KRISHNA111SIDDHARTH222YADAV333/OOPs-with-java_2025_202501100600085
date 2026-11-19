package com.example.studentmanagement.service;

import com.example.studentmanagement.entity.Student;
import com.example.studentmanagement.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    void meritListUsesAvailableScoresAndOrdersTiesByStudentId() {
        Student oneScore = student(3, "90", null);
        Student lower = student(2, "80", "80");
        Student tieWithHigherId = student(4, "90", "90");
        Student tieWithLowerId = student(1, "90", "90");
        Student noScores = student(5, null, null);
        when(studentRepository.findAll())
                .thenReturn(List.of(noScores, tieWithHigherId, lower, oneScore, tieWithLowerId));

        List<Student> meritList = studentService.getMeritList();

        assertEquals(List.of(1, 3, 4, 2, 5),
                meritList.stream().map(Student::getStudentId).toList());
    }

    private static Student student(Integer id, String programmingScore, String mathematicsScore) {
        Student student = new Student();
        student.setStudentId(id);
        student.setProgrammingScore(decimal(programmingScore));
        student.setMathematicsScore(decimal(mathematicsScore));
        return student;
    }

    private static BigDecimal decimal(String value) {
        return value == null ? null : new BigDecimal(value);
    }
}
