package aop.aspects;

import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//@Component
//@Aspect
public class LoggingAndSecurityAspect { // Аспект-класс для логирования
    
    // То, что в скобках - Pointcut.
    //@Before("execution(public void getBook())")       // Works for all classes
    //@Before("execution(public void aop.UniversityLibrary.getBook())") // Only for UniLibrary
    //@Before("execution(public void get*())")          // Works for all methods which names start with "get"
    //@Before("execution(public void getBook(String))") // Only with String parameter
    //@Before("execution(public void *(*))")            // Any method with any single parameter
    //@Before("execution(public void *(..))")             // Any method with any number of parameters
    //@Before("execution(public void getBook(aop.Book))") 
    
//    @Before("execution(* get*())")
//    public void beforeGetBookAdvice(){
//        System.out.println("beforeGetBookAdvice: Attempt to get an item.");
//    }
//    
//    @Before("execution(* returnBook())") // For all return types
//    // @Before("execution(public void returnBook())")
//    public void beforeReturnBookAdvice(){
//        System.out.println("beforeReturnBookAdvice: Attempt to return a book.");
//    }
    
//    // Defining Pointcut:
//    @Pointcut("execution(* get*())")
//    private void allGetMethods(){} // public - for using in another aspect classes.
//    
//    @Before("allGetMethods()")
//    public void beforeGetLoggingAdvice(){
//        System.out.println("beforeGetLoggingAdvice: Attempt to get an item.");
//    }
//    
//    @Before("allGetMethods()")
//    public void beforeGetSecurityAdvice() {
//        System.out.println("beforeGetSecurityAdvice: Verification of the rights to get an item.");
//    }
    
//    // Combining Pointcuts (Example 1):
//    @Pointcut("execution(* aop.UniversityLibrary.get*())")
//    private void allGetMethodsFromUniversityLibrary(){}
//    
//    @Pointcut("execution(* aop.UniversityLibrary.return*())")
//    private void allReturnMethodsFromUniversityLibrary(){}
//    
//    // Задача: при вызове всех Get и Return методов нужна еще одна сквозная логика (Log #3)
//    // Создаем комбинацию первого и вротого Pointcut-ов:
//    @Pointcut("allGetMethodsFromUniversityLibrary() || allReturnMethodsFromUniversityLibrary()")
//    private void allGetAndReturnMethodsFromUniversityLibrary(){}
//   
//    @Before("allGetMethodsFromUniversityLibrary()")
//    public void beforeGetLoggingAdvise() {
//        System.out.println("beforeGetLoggingAdvise: Writing Log #1.");
//    }
//    
//    @Before("allReturnMethodsFromUniversityLibrary()")
//    public void beforeReturnLoggingAdvise() {
//        System.out.println("beforeGetLoggingAdvise: Writing Log #2.");
//    }
//    
//    @Before("allGetAndReturnMethodsFromUniversityLibrary()")
//    public void beforeGetAndReturnLoggingAdvise() {
//        System.out.println("beforeGetAndReturnLoggingAdvise: Writing Log #3.");
//    }
    
//    // Combining Pointcuts (Example 2):
//    // Создадим Pointcut, который будет подходить для всех методов класса 
//    // UniversityLibrary, кроме метода returnMagazine().
//    // а) Pointcut для всех методов UniversityLibrary:
//    @Pointcut("execution(* aop.UniversityLibrary.*(..))")
//    private void allMethodsFromUniversityLibrary(){}
//    
//    // б) Теперь создадим Pointcut только для returnMagazine():
//    @Pointcut("execution(public void aop.UniversityLibrary.returnMagazine())")
//    private void returnMagazineFromUniversityLibrary(){}
//    
//    // в) Комбинированный Pointcut:
//    @Pointcut("allMethodsFromUniversityLibrary() && !returnMagazineFromUniversityLibrary()")
//    private void AllMethodsExceptReturnMagazineFromUniversityLibrary(){}
//    
//    @Before("AllMethodsExceptReturnMagazineFromUniversityLibrary()")
//    public void beforeAllMethodsExceptReturnMagazineAdvise(){
//        System.out.println("beforeAllMethodsExceptReturnMagazineAdvise: Log #10");
//    }
    
    // Порядок выполнения Poincut-ов можно задать путем помещения Advice-ов в 
    // разные аспект-классы, обозначенные аннотацией 2Order (LoggingAspect and 
    // SecurityAspect).
}   
// Advice - метод в аспект-классе, который определяет, что должно 
// произойти при вызове метода getBook.