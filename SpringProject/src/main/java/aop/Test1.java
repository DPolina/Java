package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);
        
        UniversityLibrary uniLib = context.getBean("universityLibrary", UniversityLibrary.class);
        Book book = context.getBean("book", Book.class);
        //SchoolLibrary schoolLib = context.getBean("schoolLibrary", SchoolLibrary.class);
        uniLib.getBook(book);
        //uniLib.getMagazine();
        //schoolLib.getBook();
        //uniLib.returnBook();
        
        context.close();
    }
}
