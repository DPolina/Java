package aop;

import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test3 {
    public static void main(String[] args) {
        System.out.println("[Main method starts]");
        AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(MyConfig.class);
        
        UniversityLibrary uniLib = context.getBean("universityLibrary", UniversityLibrary.class);
        String bookName = uniLib.returnBook();
        System.out.println("The book " + bookName + " is returned to a Library");
        
        context.close();
        System.out.println("[Main method ends]");
    }
}
