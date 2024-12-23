import java.util.Scanner;

public class Main {
    
    public static Scanner numscan = new Scanner(System.in);
    public static Scanner wordscan = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("Welcome to Triangle Tester program! \n");
        while (true) {
            System.out.println("Please, enter the following information: ");
            System.out.print("\nFirst angle, deg.   :  ");
            double angle1 = numscan.nextDouble();
            System.out.print("Second angle, deg.  :  ");
            double angle2 = numscan.nextDouble();
            System.out.print("Third angle, deg.   :  ");
            double angle3 = numscan.nextDouble();
            
            while (angle1 <= 0|| angle2 <= 0 || angle3 <= 0) {
                System.out.println("ERROR! Numbers should be greater than zero. \n\nPlease, enter the following information: ");
                System.out.print("\nFirst angle, deg.   :  ");
                angle1 = numscan.nextDouble();
                System.out.print("Second angle, deg.  :  ");
                angle2 = numscan.nextDouble();
                System.out.print("Third angle, deg.   :  ");
                angle3 = numscan.nextDouble();
            }
            
            if (isTriangle(angle1, angle2, angle3) == true) {
                String triangle = "true";
                System.out.printf("Is triangle         :  %s", triangle);
                triangleType(angle1, angle2, angle3);
            } else {
                String triangle = "false";
                System.out.printf("Is triangle         :  %s\n\n", triangle);
            }
            
        }// end while
    } // end main
    
    public static boolean isTriangle(double angle1, double angle2, double angle3) {
        if (angle1 + angle2 + angle3 == 180) {
            return true;
        } else {
            return false;
        }
    } // end isTriangle
    
    public static void triangleType(double angle1, double angle2, double angle3) {
        String typeOfTriangle;
        String isRight = "";
        
        if (angle1 == angle2 && angle2 == angle3) {
            typeOfTriangle = "equilateral";
        } else if (angle1 == angle2 || angle2 == angle3 || angle1 == angle3) {
            typeOfTriangle = "isosceles";
        } else if (angle1 == 90 || angle2 == 90 || angle1 == 90) {
            typeOfTriangle = "right triangle";
        }  else {
            typeOfTriangle = "scalene";
        }
        if (angle1 == 90 || angle2 == 90 || angle3 == 90) {
            isRight = "right, ";
        }
        System.out.println("\nTriangle type       :  " + isRight + typeOfTriangle + ".\n");
        
    } // end triangleType
    
}// end class
