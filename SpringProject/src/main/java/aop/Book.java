package aop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Book {
    @Value("World and Piece")
    private String name;
    
    @Value("Leo Tolstoy")
    private String author;
    
    @Value("1876")
    private int yearOfPublication;
    
    public String getName() {
        return name;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public int getYear() {
        return yearOfPublication;
    }
}
