import java.util.Scanner;

public class Main {
    public static Scanner numscan = new Scanner(System.in);
    public static Scanner wordscan = new Scanner(System.in);
    //Note: In this module, the only global variables I want you to use are Scanners.
    public static void main(String[] args) {
        double savingsAccount = 1000;
        double chequingAccount = 2000;
        String exit = "no";
        
        while(exit.equalsIgnoreCase("no")){
            System.out.println("Do you want balance, deposit, withdraw?");
            String choice = wordscan.nextLine();
            if(choice.contains("bal")){
                printBalance(savingsAccount);
            } else if (choice.contains("dep")){
                savingsAccount = deposit(savingsAccount); 
                //Note: We assign the balance we calculated in deposit()
                //      to savingsAccount.
            } else {
                savingsAccount = withdraw(savingsAccount);
               //Note: We assign the balance we calculated in withdraw()
               //      to savingsAccount.
            }
            System.out.println("Do you want to exit?");
            exit = wordscan.nextLine();

        }//end while       
    }//end main
    
    public static double withdraw(double balance){ 
        // Note: Method has a double returnType corresponding to the balance 
        //       we will return at the end of the method.
        System.out.println("How much do you want to withdraw?");
        double amount = numscan.nextDouble();
        if( amount + 0.5 <= balance ){
            balance -= amount;
            balance -= 0.5;
            printBalance(balance);
        } else {
            System.out.println("Insufficient Funds. Beat it loser!");
        }
        return balance; // This value will be returned to the main method where
        // we can assign it to our savingsAccount.
    }//end withdraw
    
    public static double deposit (double balance){
        // Note: Method has a double returnType corresponding to the balance 
        //       we will return at the end of the method.
        System.out.println("How much do you want to deposit?");
        double amount = numscan.nextDouble();
        balance += amount;
        printBalance(balance);
        return balance;// This value will be returned to the main method where
        // we can assign it to our savingsAccount.
    }//end deposit
    
    public static void printBalance (double balance){
        System.out.println("Your balance is $" + balance);
    }//end printBalance
    
}//end class
