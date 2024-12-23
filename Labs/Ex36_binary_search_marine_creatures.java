package BinarySearch_Numbers_Drazdouskaya;

import java.util.Scanner;

public class Main {
    
    public static Scanner numscan = new Scanner(System.in);
    public static Scanner wordscan = new Scanner(System.in);
    public static String marineCreatures[] = { "Blue whale", "Dolphin", "Flounder", "Killer whale", "Octopus", "Plankton", "Shrimp", "Squid", "Starfish", "White shark" };
    public static String classes[] = { "an aquatic mammal", "an aquatic mammal", "a fish", "an aquatic mammal", "a cephalopoda", "a plankter", "a cephalopoda", "a crustaceans", "an echinoderms", "a fish" };
    public static boolean endangered[] = { true, false, false, true, false, false, false, false, false, false };
    

    public static void main(String[] args) {
        printArray();
        while (true) {
            System.out.print("\nWhat marine creature are you looking for? ");
            String creature = wordscan.nextLine().toLowerCase();
            if (creature.equalsIgnoreCase("exit")) {
                break;
            }
            String article = "A";
            if ((creature.substring(0, 1).equalsIgnoreCase("a")) || (creature.substring(0, 1).equalsIgnoreCase("e")) ||(creature.substring(0, 1).equalsIgnoreCase("i")) || (creature.substring(0, 1).equalsIgnoreCase("o")) || (creature.substring(0, 1).equalsIgnoreCase("u"))) {
                article = "An";
            }
            if (binarySearch(marineCreatures, creature) == -1) {
                System.out.println("I am sorry this creature is not in our list. Please try again later.");
            } else {
                System.out.print("I found it. " + article + " " + creature + " is " + classes[binarySearch(marineCreatures, creature)] + ". ");
                if (endangered[binarySearch(marineCreatures, creature)] == true) {
                    System.out.println("This species is endangered.");
                } else {
                    System.out.println("This species is not endangered.");
                }
            }
        }
        
    } // end main
    
    public static int binarySearch(String[] array, String name) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high)
        {
            int mid = (low + high) / 2;
            if (array[mid].equalsIgnoreCase(name)) {
                return mid;
            } else if(array[mid].compareToIgnoreCase(name) < 0)
            {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    } // end binarySearch (String)
    
    public static void printArray() {
        for (int i = 0; i < marineCreatures.length; i++) {
            if (i == marineCreatures.length - 1) {
                System.out.print(marineCreatures[i]);
            } else {
                System.out.print(marineCreatures[i] + ", ");
            }
        }
    }
    
} // end class
