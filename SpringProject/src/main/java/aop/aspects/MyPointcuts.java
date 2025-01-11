package aop.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointcuts {
    @Pointcut("execution(* addD*(..))")
    public void allAddMethods(){} // public - for using in another aspect classes.
    //public void allGetMethods(){}
}
