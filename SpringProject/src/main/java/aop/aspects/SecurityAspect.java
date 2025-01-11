package aop.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(20)
public class SecurityAspect {
    
    @Before("aop.aspects.MyPointcuts.allAddMethods()") // This Pointcut is created in different aspect class
    public void beforeAddSecurityAdvice() {
        System.out.println("beforeAddSecurityAdvice: Verification of the rights to get an item.");
        System.out.println("-------------------------------------------");
    }
}
