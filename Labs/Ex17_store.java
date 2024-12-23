import java.util.Scanner; 

public class Main {
    
    public static void main(String[] args) {
        
        Scanner numscan = new Scanner(System.in);
        Scanner wordscan = new Scanner(System.in);
        
        int num = 10;
        double add = 0.00;
        double toPay = 0.00;
        int choice, bought;
        double discount = 0.00, subtotal = 0.00;
        String stillShopping;
        String minusTen = "";
        String printDiscount = "";
        boolean isMember = false;
        
        String[] products = {
            "Guitars",
            "Pianos",
            "Keyboards",
            "Trumpets",
            "Saxophones",
            "Drums",
            "Banjos",
            "Maracas",
            "Flutes",
            "Xylophones"
        };
        double[] price = {
            750.00,
            1399.00, 
            600.50,
            550.00,
            700.00,
            1200.00,
            499.99,
            79.99,
            325.00,
            175.00
        };
        int[] numBought = new int[num];
        double[] totalPrice = new double[num];
        
        do {
            for (int idx = 0; idx < products.length; idx++) {
                System.out.printf("%d. %-10s%5s%.2f", idx, products[idx], "$", price[idx]);
                System.out.println("");
            }
            
            System.out.println("");
            System.out.println("Please, enter the ID number of the product you would like to purchase.");
            choice = numscan.nextInt();
            if (choice == -1) {
                System.out.print("You've got Secret Members's Discount: -10% for all products! ");
                System.out.println("What would you like to buy?");
                minusTen = " - 10% ";
                choice = numscan.nextInt();
                isMember = true;
            } 
            while (choice > 9 || choice < 0) { 
                System.out.print("Invalid ID. ");
                System.out.println("Please enter the number from 0 to 9.");
                choice = numscan.nextInt();
            }; 
            System.out.printf("You chose product id number: %d. How many %s would you like to buy?", choice, products[choice]);
            System.out.println("");
            
            bought = numscan.nextInt();
            numBought[choice] = bought;
            discount = price[choice] * 0.1;
            totalPrice[choice] = numBought[choice] * (price[choice] - discount);
            add = totalPrice[choice];
            toPay += add;
            System.out.printf("%s:%5d x %.2f%s totals %.2f;", products[choice], bought, price[choice], minusTen, totalPrice[choice]);
            System.out.println("");
            System.out.println("");
            System.out.println("Continue shopping?");
            stillShopping = wordscan.nextLine().toLowerCase();
            
            if (stillShopping.startsWith("n")) {
                break;
            }
            
        } while (true);
        
        System.out.printf("%-20s%-11s%-10s%-16s", "Product", "Price", "Qty", "Total");
        System.out.println("");
        for (int idx = 0; idx < products.length; idx++) {
            if (numBought[idx] != 0) {
                System.out.printf("%-20s$%-10.2f%-10d$%-15.2f", products[idx], price[idx], numBought[idx], totalPrice[idx]);
                System.out.println("");
                subtotal += totalPrice[idx];
            }
        }
        
        if (isMember) {
            discount = subtotal * 0.1;
            subtotal = subtotal - discount;
        }
        
        double gst = subtotal * 0.05;
        double total = subtotal + gst;
        System.out.printf("%-30s%10s %-15s\n", " ", " ", "----------");
        
        if (isMember) {
            System.out.printf("%-30s%10s %-15s\n", " ", " ", "Membership discount (10%) applied");
            System.out.printf("%-30s%10s $%-15.2f\n", " ", "Discount: ", discount);
        }
        
        System.out.printf("%-30s%10s $%-15.2f\n", " ", "Subtotal: ",subtotal);
        System.out.printf("%-30s%10s $%-15.2f\n", " ", "GST: ", gst);
        System.out.printf("%-30s%10s $%-15.2f\n1", " ", "Total: ", total);
        
    } // end main
    
    
} // end class
