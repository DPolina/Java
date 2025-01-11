package aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewLoggingAspect {
    
    @Around("execution(public String returnBook())")
    public Object aroundReturnBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) 
            throws Throwable{
        System.out.println("aroundReturnBookLoggingAdvice: An attempt to return a book to the Library.");
        
        long begin = System.currentTimeMillis();
        
        Object targetMethodResult = null;
        
        // Methods of processing exceptions
        try {
            targetMethodResult = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            System.out.println("aroundReturnBookLoggingAdvice: Exceprion is thrown: " + e);
            //targetMethodResult = "Unknown book name"; // 1-st method: Default value
            throw e; // 2-nd method: Throwing exception further
        }
        
        long end = System.currentTimeMillis();
        System.out.println("aroundReturnBookLoggingAdvice: A book is successfully returned to the Library");
        System.out.println("aroundReturnBookLoggingAdvice: returnBook() method ended in " 
                + (end - begin) + " millisecons");
        return targetMethodResult;
    }
}
