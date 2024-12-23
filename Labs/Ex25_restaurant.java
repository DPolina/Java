import java.util.Scanner;

public class Main {

public static double total = 0;
public static Scanner numscan = new Scanner(System.in);
public static Scanner wordscan = new Scanner(System.in);

    public static void main(String[] args) {        
    
        double mainSubtotal;
        int numPeople = 0;        
        String firstName;        
        String phoneNumber;        
        int weight;
    
        System.out.println("What is the subtotal?");        
        mainSubtotal = numscan.nextDouble();     
        
        System.out.println("How many people were there?");        
        numPeople = numscan.nextInt();        
    
        System.out.println("Customer: Excuse me, server, what is your first name?");        
        firstName = wordscan.nextLine();        
    
        System.out.println("Customer: Thank you. What is your phone number?");        
        phoneNumber = wordscan.nextLine();   
    
        addTax(mainSubtotal);        
        addTip(mainSubtotal);        
        splitBill(mainSubtotal, numPeople);        
        hitOn(firstName, phoneNumber);   
        
        System.out.println("Customer: Um, that is your sweetheart!? How much do they weigh?");        
        weight = numscan.nextInt();        
        apologize(weight);    
    
    }//end maind 

    public static void addTax(double mainSubtotal) {

        double gst = mainSubtotal * 0.05;
        total = mainSubtotal + gst;

        System.out.println("");
        System.out.println("Subtotal: $" + mainSubtotal);
        System.out.println("GST: $" + gst);
        System.out.println("Total: $" + total);
    }

    public static void addTip(double mainSubtotal) {
        System.out.println("");
        System.out.println("Leave a TIP, please.");
        double tip = numscan.nextDouble();
        total += tip;
        System.out.println("New total: $" + total);
    }

    public static void splitBill(double mainSubtotal, int numPeople) {
        System.out.println("");
        double subtotal = total / numPeople;
        System.out.println("Total per person: $" + subtotal);
    }

    public static void hitOn(String firstName, String phoneNumber) {
        System.out.println("");
        System.out.println("Hello there!");
        System.out.println("I'll call you later, " + firstName + ", at " + phoneNumber + ".");
        System.out.println("");
    } 

    public static void apologize(double weight) {
        for (int i = 0; i <= weight; i++) {
            System.out.print("I'm sorry! ");
        }
    } 
}
