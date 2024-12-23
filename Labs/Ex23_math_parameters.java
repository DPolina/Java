
import java.util.Scanner;

public class Main {

    public static Scanner numscan = new Scanner(System.in);
    public static Scanner wordscan = new Scanner(System.in);

    public static void main(String[] args) {

        int circle1 = 10;
        int circle2 = 20;
        printArea(circle1);
        printArea(circle2);
        printCircumference(circle1);
        printCircumference(circle2);
        
        printArea(5, 4, "meters");
        
    }//end main
    
    public static void printArea(int w, int h, String units){
        double area = w*h;
        System.out.println("The area of this rectange is " + area + " square " + units); 
    }//end printArea
    
    public static void printArea( int w, int h ){
        double area = w*h;
        System.out.println("The area of this rectange is " + area); 
    }//end printArea
        
    public static void printArea( int d ){
        //surface area of circle
        double r = d/2.0;
        double area = Math.PI * r * r;
        System.out.println("The area a circle with diameter of " + d + " is " + area);        
    }//end printArea
    
    public static void printCircumference( int d ){
        //circumference of circle
        double r = d/2.0;
        double circumference = Math.PI * r * 2;
        System.out.println("The circumference a circle with diameter of " + d + " is " + circumference);
    }//end circumference
    
}//end class
