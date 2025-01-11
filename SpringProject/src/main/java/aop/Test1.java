package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class);
        
        UniversityLibrary uniLib = context.getBean("universityLibrary", UniversityLibrary.class);
        Book book = context.getBean("book", Book.class);
        //SchoolLibrary schoolLib = context.getBean("schoolLibrary", SchoolLibrary.class);
        //uniLib.getBook(book);
        //uniLib.getBook();
        //uniLib.getMagazine();
        //uniLib.returnMagazine();
        //uniLib.addBook();
        //schoolLib.getBook();
        //uniLib.returnBook();
        
        uniLib.getBook();
        uniLib.addBook("Peter Parker", book);
        uniLib.addMagazine();
        
        context.close();
    }
}
