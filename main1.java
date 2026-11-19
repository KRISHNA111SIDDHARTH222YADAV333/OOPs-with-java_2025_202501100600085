
import java.util.*;

class Student {
    private int studentId;
    private String studentName;
    private String email;
    private String courseName;
    private double programmingScore;
    private double mathematicsScore;
    private List<String> technicalSkills;

    
    public Student() {
        technicalSkills = new ArrayList<>();
    }

    
    public Student(int studentId, String studentName,
                   String email, String courseName,
                   double programmingScore,
                   double mathematicsScore,
                   List<String> technicalSkills) {

        this.studentId = studentId;
        this.studentName = studentName;
        this.email = email;
        this.courseName = courseName;
        this.programmingScore = programmingScore;
        this.mathematicsScore = mathematicsScore;
        setTechnicalSkills(technicalSkills);
    }

    
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
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

    public double getProgrammingScore() {
        return programmingScore;
    }

    public void setProgrammingScore(double programmingScore) {
        this.programmingScore = programmingScore;
    }

    public double getMathematicsScore() {
        return mathematicsScore;
    }

    public void setMathematicsScore(double mathematicsScore) {
        this.mathematicsScore = mathematicsScore;
    }

    public List<String> getTechnicalSkills() {
        return new ArrayList<>(technicalSkills);
    }

    public void setTechnicalSkills(List<String> technicalSkills) {
        this.technicalSkills = technicalSkills == null
                ? new ArrayList<>()
                : new ArrayList<>(technicalSkills);
    }

    
    @Override
    public String toString() {
        return "Student ID: " + studentId +
               "\nName: " + studentName +
               "\nEmail: " + email +
               "\nCourse: " + courseName +
               "\nProgramming Score: " + programmingScore +
               "\nMathematics Score: " + mathematicsScore +
               "\nTechnical Skills: " + technicalSkills;
    }

    // equals Method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Student)) return false;

        Student s = (Student) obj;
        return studentId == s.studentId;
    }


    @Override
    public int hashCode() {
        return Objects.hash(studentId);
    }
}


public class main1 {
    public static void main(String[] args) {

        List<String> skills = Arrays.asList(
            "Java", "Python", "SQL"
        );

        Student s1 = new Student(
            101,
            "Rahul",
            "rahul@gmail.com",
            "B.Tech",
            85,
            90,
            skills
        );

        System.out.println(s1);
    }
}
