package aop.aspects;

import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Component
@Aspect
public class LoggingAspect { // Аспект-класс для логирования
    
    // То, что в скобках - Pointcut.
    //@Before("execution(public void getBook())")       // Works for all classes
    //@Before("execution(public void aop.UniversityLibrary.getBook())") // Only for UniLibrary
    //@Before("execution(public void get*())")          // Works for all methods which names start with "get"
    //@Before("execution(public void getBook(String))") // Only with String parameter
    //@Before("execution(public void *(*))")            // Any method with any single parameter
    //@Before("execution(public void *(..))")             // Any method with any number of parameters
    
    @Before("execution(public void getBook(aop.Book))") 
    public void beforeGetBookAdvice(){
        System.out.println("beforeGetBookAdvice: Attempt to get a book.");
        // Advice - метод в аспект-классе, который определяет, что должно 
        // произойти при вызове метода getBook.
    }
    
    @Before("execution(* returnBook())") // For all return types
    // @Before("execution(public void returnBook())")
    public void beforeReturnBookAdvice(){
        System.out.println("beforeReturnBookAdvice: Attempt to return a book.");
    }
}