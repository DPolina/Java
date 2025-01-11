package aop;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class University {
    private List<Student> students = new ArrayList<>();
    
    public void addStudents() {
        Student st1 = new Student("Peter Parker", 1, 9.8);
        Student st2 = new Student("Luke Skywalker", 2, 5.8);
        Student st3 = new Student("John Snow", 4, 8.1);
        students.add(st1);
        students.add(st2);
        students.add(st3);
    }
    
    public List<Student> getStudents() {
        System.out.println("[Beginning of method getStudents()]");
        System.out.println(students.get(3)); // This will throw an exception.
        System.out.println("Information from method getStudents(): ");
        System.out.println(students);
        return students;
    }
}
