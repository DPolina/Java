import java.util.Scanner;

public class Assign2_HomeReno_Drazdouskaya {
    
    public static Scanner numscan = new Scanner(System.in);
    public static Scanner wordscan = new Scanner(System.in);
    
    public static double width = 0;
    public static double height = 0;
    public static double length = 0;
    public static double doorWidth = 0.8;
    public static double doorHeight = 2;
    public static double windowWidth = 1;
    public static double windowHeight = 0.5;
    public static double hotTubWalkway = 0.61;
    public static double hotTubDepth = 0.914;
    public static double flooringPrice = 43;
    public static double paintingPrice = 25;
    public static double footagePerGallone = 32.516;
    public static double glassingPrice = 68;
    
    public static int numOfDoors = 0;
    public static int numOfWindows = 0;
    
    public static void main(String[] args) {
        
        System.out.println("Welcome to Room Rennovation Calculator!");
        System.out.println("===\n");
        while (true) {
            System.out.println("Please enter the room information below");
            
            System.out.printf("Width, m.                      : ");
            width = numscan.nextDouble();
            System.out.printf("Length, m.                     : ");
            length = numscan.nextDouble();
            System.out.printf("Height, m.                     : ");
            height = numscan.nextDouble();
            System.out.printf("Doors (%.2fx%.2f m), qty       : ", doorWidth, doorHeight);
            numOfDoors = numscan.nextInt();
            System.out.printf("Windows (%.2fx%.2f m), qty     : ", windowWidth, windowHeight);
            numOfWindows = numscan.nextInt();
            
            while (true) {
                System.out.println("MENU \n1. Flooring \n2. Paint \n3. Indoor Hot Tub \n4. Glassing \n0. Exit");
                System.out.print("What is your choice? ");
                int choice = numscan.nextInt();
                if (choice == 1) {
                    flooring(width, length);
                } else if (choice == 2) {
                    paint(width, length, height, numOfWindows, numOfDoors, paintingPrice);
                } else if (choice == 3 ){
                    hotTub(width, length);
                } else if (choice == 4) {
                    windows(windowWidth, windowHeight, numOfWindows);
                } else if (choice == 0) {
                    break;
                } else {
                    System.out.println("Invalid value. What is your choice?");
                    choice = numscan.nextInt();
                }
            } // end while
            System.out.println("Do you have another room to calculate?");
            String calculateAnotherRoom = wordscan.nextLine();
            if (calculateAnotherRoom.equalsIgnoreCase("no")) {
                break;
            }
        } // end while
        
        System.out.println("");
        pigLatin("computer");
        pigLatin("morning");
        pigLatin("human");
        
    } // end main
    
    public static double calcArea (double x, double y) {
        return x * y;
    }
    public static double round (double value) {
        return Math.floor(value * 100) / 100;
    }
    public static void flooring (double width, double length) {
        double totalFloorArea = calcArea(width, length);
        double totalFlooringPrice = totalFloorArea * flooringPrice;
        
        System.out.printf("===\nThe Room Flooring Quote:\n");
        System.out.printf("Room (WxL), m.         :  %8.2f x %.2f\n", width, length);
        System.out.printf("Floor Total, sq.m.     :  %8.2f\n", totalFloorArea);
        System.out.printf("Price, per sq.m.       : $%8.2f\n", flooringPrice);
        System.out.printf("Price Total            : $%8.2f\n", totalFlooringPrice);
        System.out.printf("\n===\n\n");
    }
    public static void paint (double width, double length, double height, int numOfWindows, int numOfDoors, double pricePerUnit) {
        double totalWallArea = calcArea(height, width) * 2 + calcArea(height, length) * 2;
        double areaOfDoors = calcArea(doorWidth, doorHeight) * numOfDoors;
        double areaOfWindows = calcArea(windowWidth, windowHeight) * numOfWindows;
        double areaToPaint = totalWallArea - areaOfDoors - areaOfWindows;
        double numOfGallons = round(areaToPaint / footagePerGallone);
        double totalPaintPrice = round(numOfGallons * paintingPrice);
        
        System.out.printf("===\nThe Room Painting Quote:\n");
        System.out.printf("Room (WxLxH), m.       :  %8.2f x %.2f x %.2f\n", width, length, height);
        System.out.printf("Walls Total, sq.m.     :  %8.2f\n", totalWallArea);
        System.out.printf("Doors Total, sq.m.     : -%8.2f\n", areaOfDoors);
        System.out.printf("Windows Total, sq.m.   : -%8.2f\n", areaOfWindows);
        System.out.printf("Painting Total, sq.m.  : =%8.2f\n", areaToPaint);
        System.out.printf("Total Gallons          :  %8.2f\n", numOfGallons);
        System.out.printf("Paint Gallon Price     : $%8.2f\n", paintingPrice);
        System.out.printf("Total Price            : $%8.2f\n", totalPaintPrice);
        System.out.printf("\n===\n\n");
    }
    public static void hotTub (double width, double length) {
        double diameter;
        if (width < length) {
            diameter = width - 1.219;
        } else {
            diameter = length - 1.219;
        }
        double radius = ((diameter - 0.61) / 2);
        double volume = radius * radius * 3.14 * 0.914; // V = pi*r*r*h
        
        System.out.printf("===\nThe Room Hot Tub Quote:\n");
        System.out.printf("Room (WxL), m.         :  %8.2f x %.2f\n", width, length);
        System.out.printf("Walkway around, m      :  %8.2f\n", hotTubWalkway);
        System.out.printf("Hot Tub Diameter, m.   :  %8.2f\n", diameter); 
        System.out.printf("Water Volume, c.m.     :  %8.2f\n", volume);
        System.out.printf("\n===\n");
        volume = Math.floor(volume * 100) / 100;
        System.out.println("The volume of water to fill it is " + volume + " cubic meters.\n");
    }
    public static void windows (double windowWidth, double windowHeight, int numOfWindows) {
        double totalGlassingPrice = numOfWindows * glassingPrice;
        
        System.out.printf("===\nThe Room Glassing Quote:\n");
        System.out.printf("Windows (%.2fx%.2f m), qty     :  %8d\n", windowWidth, windowHeight, numOfWindows);
        System.out.printf("Glassing Price                 : $%8.2f\n", glassingPrice);
        System.out.printf("Total Price                    : $%8.2f\n", totalGlassingPrice);
        System.out.printf("\n===\n\n");
    }
    
    public static void pigLatin(String english) { 
        String firstLetter = english.substring(0, 1);
        String pigLatin = english.substring(1, english.length()) + firstLetter + "ay";
        System.out.println(english + " = " + pigLatin);
    } // end pigLatin
   
} // end class

