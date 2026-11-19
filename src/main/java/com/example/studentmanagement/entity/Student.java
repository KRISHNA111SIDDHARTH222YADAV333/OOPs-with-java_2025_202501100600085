package com.example.studentmanagement.entity;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Student")
public class Student {

    @Id
    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "student_name", nullable = false)
    private String studentName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "programming_score")
    private BigDecimal programmingScore;

    @Column(name = "mathematics_score")
    private BigDecimal mathematicsScore;

    @ElementCollection
    @CollectionTable(name = "student_skills", joinColumns = @JoinColumn(name = "student_id"))
    @Column(name = "skill", nullable = false)
    private List<String> skills = new ArrayList<>();

    public Student() {
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public BigDecimal getProgrammingScore() {
        return programmingScore;
    }

    public void setProgrammingScore(BigDecimal programmingScore) {
        this.programmingScore = programmingScore;
    }

    public BigDecimal getMathematicsScore() {
        return mathematicsScore;
    }

    public void setMathematicsScore(BigDecimal mathematicsScore) {
        this.mathematicsScore = mathematicsScore;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills == null ? new ArrayList<>() : new ArrayList<>(skills);
    }
}
