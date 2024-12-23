import java.util.ArrayList;
import java.util.Scanner;

public class GeometryMain {
    
    public static Scanner numscan = new Scanner(System.in);
    public static Scanner wordscan = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        ArrayList<Circle> circles = new ArrayList<Circle>();
        ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>();
        
        Circle c1 = new Circle("large pizza", 0.5);
        Circle c2 = new Circle("Tower of Pizza", 20, 80);
        circles.add(c1);
        circles.add(c2);
        
        Rectangle r1 = new Rectangle("paper", 0.216, 0.28);
        Rectangle r2 = new Rectangle("printer", 0.36, 0.32, 0.24);
        rectangles.add(r1);
        rectangles.add(r2);
        
        for (int i = 0; i < circles.size(); i++) {
            System.out.println("");
            System.out.println(circles.get(i).getName() + " has the following properties:");
            circles.get(i).printArea();
            circles.get(i).printCircumference();
            circles.get(i).printVolume();
        }
        
        for (int i = 0; i < rectangles.size(); i++) {
            System.out.println("");
            System.out.println(rectangles.get(i).getName() + " has the following properties:");
            rectangles.get(i).printArea();
            rectangles.get(i).printPerimeter();
            rectangles.get(i).printVolume();
        }
        
        String search;
        while (true) {
            boolean match = false;
            
            System.out.println("");
            System.out.println("What figure do you want to search for?");
            String figure = wordscan.nextLine().toLowerCase();
            
            for (int i = 0; i < circles.size(); i++) {
                if (circles.get(i).getName().equals(figure)) {
                    System.out.println("");
                    System.out.println(circles.get(i).getName() + " has the following properties:");
                    circles.get(i).printArea();
                    circles.get(i).printCircumference();
                    circles.get(i).printVolume();
                    match = true;
                }
                if (rectangles.get(i).getName().equals(figure)) {
                    System.out.println("");
                    System.out.println(rectangles.get(i).getName() + " has the following properties:");
                    rectangles.get(i).printArea();
                    rectangles.get(i).printPerimeter();
                    rectangles.get(i).printVolume();
                    match = true;
                }
            }
            if (match == false) {
                System.out.println("Figure is not found.");
            }
            do {
                System.out.println("Continue searching? (y/n)");
                search = wordscan.nextLine().toLowerCase();
            } while (!(search.equals("y") || search.equals("n")));
            if (!(search.equals("y"))) {
                break;
            }
        }
    }
}
