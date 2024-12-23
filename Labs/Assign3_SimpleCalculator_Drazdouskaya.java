import java.util.Scanner;

public class Assign3_SimpleCalculator_Drazdouskaya {
    
    public static Scanner numscan = new Scanner(System.in);
    public static Scanner wordscan = new Scanner(System.in);
    public static double result = 0;
    
    public static void main (String[] args) {
        
        System.out.println("Welcome to calculator!");
        while (true) {
            System.out.print("Please enter operator ( +, -, *, /, exit ): ");
            String operator = wordscan.nextLine();
            if (operator.equals("+")){
                add();
            } else if (operator.equals ("-")) {
                subtract();
            } else if (operator.equals ("*")) {
                multiply();
            } else if (operator.equals ("/")) {
                divide();
            } else if (operator.equals ("exit")) {
                System.out.println("You chose to EXIT. See you soon!");
                break;
            }
            System.out.print("Thank you. Answer is " + result + ".\n");
            
        } // end while
        
    }//end main
    
    public static double add () {
        System.out.print("You chose to ADD. \nEnter first number: ");
        double firstNumber = numscan.nextDouble();
        System.out.print("Enter second number: ");
        double secondNumber = numscan.nextDouble();
        result = firstNumber + secondNumber;
        return result;
    } // end add
    public static double subtract () {
        System.out.print("You chose to SUBTRACT. \nEnter first number: ");
        double firstNumber = numscan.nextDouble();
        System.out.print("Enter second number: ");
        double secondNumber = numscan.nextDouble();
        result = firstNumber - secondNumber;
        return result;
    } // end subtract
    public static double multiply () {
        System.out.print("You chose to MULTIPLY. \nEnter first number: ");
        double firstNumber = numscan.nextDouble();
        System.out.print("Enter second number: ");
        double secondNumber = numscan.nextDouble();
        result = firstNumber * secondNumber;
        return result;
    } // end multiply
    public static double divide () {
        System.out.print("You chose to DIVIDE. \nEnter first number: ");
        double firstNumber = numscan.nextDouble();
        System.out.print("Enter second number: ");
        double secondNumber = numscan.nextDouble();
        while (secondNumber == 0) {
            System.out.print("Undefined. \nYou can not divide by zero. \nEnter second number: ");
            secondNumber = numscan.nextDouble();
        }
        result = firstNumber / secondNumber;
        return result;
    } // end divide
   
} // end class
