package aop;

public class Student {
    private String nameSurname;
    private int course;
    private double avgGrade;
    
    public Student(String nameSurname, int course, double avgGrade) {
        this.nameSurname = nameSurname;
        this.course = course;
        this.avgGrade = avgGrade;
    }
    
    public void setNameSurname(String name) {
        this.nameSurname = name;
    }
    
    public void setCourse(int course) {
        this.course = course;
    }
    
    public void setAvgGrade(double grade) {
        this.avgGrade = grade;
    }
    
    public String getNameSurname(){
        return nameSurname;
    }
    
    public int getCourse(){
        return course;
    }
    
    public double getAvgGrade(){
        return avgGrade;
    }
    
    @Override
    public String toString () {
        return "Student{" +
        "nameSurname='" + nameSurname + '\'' +
        ", course=" + course +
        ", avgGrade=" + avgGrade + '}';
    }
}
