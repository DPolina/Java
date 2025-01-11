package aop;

import org.springframework.stereotype.Component;

@Component
public class UniversityLibrary extends AbstractLibrary {
    
    //@Override
    public void getBook() {
        System.out.println("We TAKE a BOOK from University Library");
        System.out.println("-------------------------------------------");
    }
//    public void getBook(Book book) {
//        System.out.println("We take a book from University Library: " + book.getName());
//    }
    
//    public void returnBook() {
//        System.out.println("We RETURN a BOOK to University Library");
//        System.out.println("-------------------------------------------");
//    }
    
    public String returnBook() {
        int a = 10/0;
        System.out.println("We RETURN a BOOK to University Library");
        return "War and Piece";
    }
    
    public void getMagazine() {
        System.out.println("We TAKE a MAGAZINE from University Library.");
        System.out.println("-------------------------------------------");
    }
    
    public void returnMagazine() {
        System.out.println("We RETURN a MAGAZINE to University Library.");
        System.out.println("-------------------------------------------");
    }
    
    public void addBook(String person_name, Book book) {
        System.out.println("We ADD a BOOK to University Library");
        System.out.println("-------------------------------------------");
    }
    
    public void addMagazine() {
        System.out.println("We ADD a MAGAZINE to University Library");
        System.out.println("-------------------------------------------");
    }
}
