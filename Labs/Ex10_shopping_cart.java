
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        
        Scanner numscan = new Scanner(System.in);
        Scanner wordscan = new Scanner(System.in);

        /* Switch is a way of replacing if...else if...*/
        double checkout = 0.00; // Normally, we would use float for decimals. 
        // However, decimals, by default, in Java are doubles. Sometimes Java 
        // will complain if you type something like "float number = 14.2;" 
        // because "14.2" is a double by default, and you are asking "number", 
        // a float, to be a data type it is not. "float number = 14.2f;" would
        // be more appropriate.
        int choice;
        int numBought;
        String stillShopping = "yes";

        while (stillShopping.startsWith("y")) {
            
            System.out.println("What would you like to buy?");
            System.out.println("1. A banana chocolate-chip muffin - $3.00");
            System.out.println("2. A diet root beer - $2.00");
            System.out.println("3. A bag of PC winegums - $2.50");
            System.out.println("4. A Canon RF 100-500mm f/4.5-7.1L IS USM "
                    + "lens - $3700.00");
            choice = numscan.nextInt();
            
            System.out.println("How many are you going to buy?");
            numBought = numscan.nextInt();

            switch (choice) { // a switch statement acts a lot like an if 
                // statement because it is a conditional operation that selects
                // different code based on something. With an if statement, that
                // something are a series of Boolean expressions that, if true, 
                // will run some code. With a switch statement, the decision is
                // made by checking the value of a variable you feed it. The 
                // case corresponding to the value of that variable will then 
                // run.
                case 1:
                    checkout += (3 * numBought);
                    break;// Having this break here means if case 1 runs, 
                    // the code won't even check the other cases. With an if
                    // statement, the computer will still check all of the 
                    // cases, just in case one may run.
                case 2:
                    checkout += (2 * numBought);
                    break;
                case 3:
                    checkout += (2.5 * numBought);
                    break;
                case 4:
                    checkout += (3700 * numBought);
                    break;
                default: // The default case is the switch equivalent of the 
                    // "else" in if statements. If no other case is selected, 
                    // the default is run.
                    System.out.println("You get NOTHING! GRRR!");
                    break;

            }//end switch

            System.out.println("Do you want to keep shopping?");
            stillShopping = wordscan.nextLine().toLowerCase();

        }//end while

        System.out.println("That will be $" + checkout);

    }//end main

}//end class
