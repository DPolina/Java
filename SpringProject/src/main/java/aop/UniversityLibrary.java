package aop;

import org.springframework.stereotype.Component;

@Component
public class UniversityLibrary extends AbstractLibrary {
    
    //@Override
    public void getBook(Book book) {
        System.out.println("We take a book from a University Library: " + book.getName());
    }
    
    public void returnBook() {
        System.out.println("We return a book to a University Library");
    }
    
    public void getMagazine() {
        System.out.println("We take a magazine from a University Library.");
    }
}
