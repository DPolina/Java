package aop;

import java.util.List;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UniversityLoggingAspect {
    
//    @Before("execution(* getStudents())")
//    public void beforeGetStudentsLoggingAdvice(){
//        System.out.println("beforeGetStudentsLoggingAdvice: logging the " +
//                "recieving of student list BEFORE getStudents() method.");
//    }
//    
//    // Now this AfterReturning aspect method will return some value.
//    @AfterReturning(pointcut = "execution(* getStudents())", returning = "students")
//    public void afterReturningGetStudentsLoggingAdvice(List<Student>  students){
//        
//        // Let's change the name of the first student in the list.
//        Student firstStudent = students.get(0);
//        String nameSurname = firstStudent.getNameSurname();
//        nameSurname = "Mr. " + nameSurname;
//        firstStudent.setNameSurname(nameSurname);
//        
//        double avgGrade = firstStudent.getAvgGrade();
//        avgGrade = avgGrade + 1;
//        firstStudent.setAvgGrade(avgGrade);
//        
//        System.out.println("afterReturningGetStudentsLoggingAdvice: logging the " +
//                "recieving of student list AFTER getStudents() method.");
//    }
    
//    @AfterThrowing(pointcut = "execution(* getStudents())", throwing = "exception")
//    public void afterThrowingGetStudentsLoggingAdvice(Throwable exception){
//        
//        System.out.println("afterThrowingGetStudentsLoggingAdvice: Logging a throw exception " + exception);
//    }
    
    @After("execution(* getStudents())")
    public void afterGetStudentsLoggingAdvice() {
        System.out.println("afterGetStudentsLoggingAdvice: Logging of a normal "
        + "ending of method GetStudents() or of an exception.");
    }
}
