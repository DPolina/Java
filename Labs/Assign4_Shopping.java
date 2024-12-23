
import java.util.Scanner;

public class Main{
    
    // public static int generateNum(int minValue, int maxValue) {
    //    return (int) (Math.random()*(maxValue - minValue) + minValue);
    // }

    public static void main(String[] args) {
        
        Scanner numscan = new Scanner(System.in);
        Scanner wordscan = new Scanner(System.in);

        double checkout = 0.00; 
        int choice;
        int headphonesInStock, powerBanksInStock, keyboardsInStock, controllersInStock, mousesInStock, camerasInStock, microphonesInStock, walkieTalkiesInStock;
        double headphonesPrice, powerBanksPrice, keyboardsPrice, controllersPrice, mousesPrice, camerasPrice, microphonesPrice, walkieTalkiesPrice;
        String name;
        int inStock = -1;
        double gst, totalPrice;
        int numBought = 0;
        String gadgets = "";
        
        System.out.println("Welcome to Techno!");
        System.out.println("What is your name?");
        name = wordscan.nextLine();
        
        headphonesInStock = 8;
        powerBanksInStock = 8;
        keyboardsInStock = 8;
        controllersInStock = 8;
        mousesInStock = 8;
        camerasInStock = 8;
        microphonesInStock = 8;
        walkieTalkiesInStock = 8;
        
        headphonesPrice = 80.49;
        powerBanksPrice = 29.99;
        keyboardsPrice = 49.00;
        controllersPrice = 34.99;
        mousesPrice = 15.00;
        camerasPrice = 699.99;
        microphonesPrice = 36.00;
        walkieTalkiesPrice = 78.49;
        
        while (true) {
            
            System.out.println("What would you like to buy, " + name + "?");
            System.out.println("1. Bluetooth headphones $" + headphonesPrice + " (" + headphonesInStock + " in stock)");
            System.out.println("2. INIU Power Bank $" + powerBanksPrice + ". (" + powerBanksInStock + " in stock)");
            System.out.println("3. Gaming Keyboard $" + keyboardsPrice + ". (" + keyboardsInStock + " in stock)");
            System.out.println("4. Wireless Switch Controller $" + controllersPrice + ". (" + controllersInStock + " in stock)");
            System.out.println("5. Computer Mouse with $" + camerasPrice + ". (" + mousesInStock + " in stock)");
            System.out.println("6. Canon Cameras $" + camerasPrice + ". (" + camerasInStock + " in stock)");
            System.out.println("7. Computer Microphone $" + microphonesPrice + ". (" + microphonesInStock + " in stock)");
            System.out.println("8. Walkie Talkie Long Range $" + walkieTalkiesPrice + ". (" + walkieTalkiesInStock + " in stock)");
            System.out.println("0. Go to the checkout.");
            choice = numscan.nextInt();
            if (choice == 0) {
                break;
            }
            
            do {
                if (inStock != -1 && numBought > inStock) {
                    if (inStock == 1) {
                            gadgets = gadgets.substring(0, gadgets.length()-1);
                        }
                    System.out.println("Only " + inStock + " " + gadgets + " left in stock. Choose smaller amount.");
                } else {
                    System.out.println("How many are you going to buy?");
                }
                numBought = numscan.nextInt();
                
                switch (choice) {
                    case 1:
                        gadgets = "bluetooth headphones";
                        inStock = headphonesInStock;
                        if (numBought <= inStock) {
                            checkout += (headphonesPrice * numBought);
                            headphonesInStock = headphonesInStock - numBought;
                        }
                        break;
                    case 2:
                        gadgets = "power banks";
                        inStock = powerBanksInStock;
                        if (numBought <= inStock) {
                            checkout += (powerBanksPrice * numBought);
                            powerBanksInStock = powerBanksInStock - numBought;
                        }
                        break;
                    case 3:
                        gadgets = "gaming keyboards";
                        inStock = keyboardsInStock;
                        if (numBought <= inStock) {
                            checkout += (keyboardsPrice * numBought);
                            keyboardsInStock = keyboardsInStock - numBought;
                        }
                        break;
                    case 4:
                        gadgets = "wireless switch controllers";
                        inStock = headphonesInStock;
                        if (numBought <= inStock) {
                            checkout += (controllersPrice * numBought);
                            controllersInStock = controllersInStock - numBought;
                        }
                        break;
                    case 5:
                        gadgets = "computer mouses";
                        inStock = mousesInStock;
                        if (numBought <= inStock) {
                            checkout += (mousesPrice * numBought);
                            mousesInStock = mousesInStock - numBought;
                        }
                        break;
                    case 6:
                        gadgets = "Canon cameras";
                        inStock = camerasInStock;
                        if (numBought <= inStock) {
                            checkout += (camerasPrice * numBought);
                            camerasInStock = camerasInStock - numBought;
                        }
                        break;
                    case 7:
                        gadgets = "computer microphones";
                        inStock = microphonesInStock;
                        if (numBought <= inStock) { 
                            checkout += (microphonesPrice * numBought);
                            microphonesInStock = microphonesInStock - numBought;
                        }
                        break;
                    case 8:
                        gadgets = "Walkie Talkies";
                        inStock = walkieTalkiesInStock;
                        if (numBought <= inStock) {
                            checkout += (walkieTalkiesPrice * numBought);
                            walkieTalkiesInStock = walkieTalkiesInStock - numBought;
                        }
                        break;
                    default: 
                        System.out.println("You get nothing.");
                        break;
    
                } //end switch
                
            } while (numBought > inStock);

        } //end while
        
        gst = Math.round(checkout * 0.05 * 100.0) / 100.0;
        totalPrice = checkout + gst;
        if (totalPrice > 0.0) {
            System.out.println("Thank you for shopping, " + name + ", your total comes to $" + totalPrice + " including gst of $" + gst + ".");
        }
        System.out.println("Have a good day!");
        
    }//end main

}//end class
