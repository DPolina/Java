import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Main {
    
    public static Scanner numscan = new Scanner(System.in);
    public static Scanner wordscan = new Scanner(System.in);
    public static int[] numbers = new int[50];
    public static String[] myFriends = { "Huxley", "King", "Anderson", "Dickens", "Kipling", "Collins", "Tolkien", "Twain", "Austen", "Rowling", "Burgess", "Pinter", "Gaskell", "Conan Doyle", "Chesterton"};

    public static void main(String[] args) {
        fillArray(numbers);
        System.out.print("Unsorted Array: ");
        printArray(numbers);
        bubbleSort(numbers);
        System.out.print("\nSorted Array: ");
        printArray(numbers);
        
        System.out.print("\n\nUnsorted Array: ");
        printArray(myFriends);
        bubbleSort(myFriends);
        System.out.print("\nSorted Array: ");
        printArray(myFriends);
        
        System.out.print("\n\nEnter a last name: ");
        String name = wordscan.nextLine();
        if (binarySearch(myFriends, name) == -1) {
            System.out.println("Sorry, I did not find your name.");
        } else {
            System.out.println("This is the " + (binarySearch(myFriends, name) + 1) + "th person in the sorted list.");
        }
        
    } // end main
    
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                System.out.print(array[i]);
            } else {
                System.out.print(array[i] + ", ");
            }
            
        }
    } // end printArray (int)
    
    public static void printArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                System.out.print(array[i]);
            } else {
                System.out.print(array[i] + ", ");
            }
            
        }
    } // end printArray (String)
    
    public static void fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = Randomizer.nextInt(1, 1000);
        }
    } // end fillArray
    
    public static void bubbleSort(int[] array) {
        boolean swap = true;
        while (swap) {
            swap = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] < array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swap = true;
                }
            }
        }
    } // end bubbleSort (int)
    
    public static void bubbleSort(String[] array) {
        boolean swap = true;
        while (swap) {
            swap = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i].compareToIgnoreCase(array[i + 1]) > 0) {
                    String temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swap = true;
                }
            }
        }
    } // end bubbleSort (String)
    
    public static int binarySearch(String[] array, String string) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high)
        {
            int mid = (low + high) / 2;
            if (array[mid].equalsIgnoreCase(string)) {
                return mid;
            } else if(array[mid].compareToIgnoreCase(string) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    } // end binarySearch (String)
    
} // end class
