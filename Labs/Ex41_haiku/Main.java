import java.util.Scanner;

public class Main {
    
    public static Scanner numscan = new Scanner(System.in);
    public static Scanner wordscan = new Scanner(System.in); 
    public static String[] haiku;
   
    public static void main(String[] args) {
        
        int number;
        do {
            System.out.print("Which haiku would you like to sort? (1/2/3) ");
            number = numscan.nextInt(); 
        
            switch (number) {
                default: continue;
                case 1: haiku = Files.loadStringArr("./Root/data/HaikuPoem1.txt"); break;
                case 2: haiku = Files.loadStringArr("./Root/data/HaikuPoem2.txt"); break;
                case 3: haiku = Files.loadStringArr("./Root/data/HaikuPoem3.txt"); break;
            }
        } while (haiku == null);
        
        printHaiku("ORIGINAL HAIKU", haiku);
        selectionSort(haiku);
        printHaiku("SORTED HAIKU", haiku);
        
        while (true) {
            System.out.print("\nWhich word would you like to change? ");
            String word1 = wordscan.nextLine().toLowerCase().trim();
            int wordPos = findIdx(haiku, word1);
            if ((word1.equalsIgnoreCase("")) || (wordPos == -1)) {
                System.out.print("Sorry, the word is not found. ");
            } else {
                System.out.print("Enter a new word: ");
                String word2 = wordscan.nextLine().toLowerCase();
                haiku[wordPos] = haiku[wordPos].replace(word1, word2);
                printHaiku("CHANGED HAIKU", haiku);
                System.out.println("");
            }
            if (search() == false) {
                break;
            }
        }
        
        String save;
        do {
            System.out.print("\nDo you want to save haiku? (y/n) ");
            save = wordscan.nextLine().toLowerCase();
        } while (!(save.equals("y") || save.equals("n")));
        
        if (save.equalsIgnoreCase("y")) {
            Files.saveFile("HaikuPoem1", haiku);
            System.out.println("\nHaiku saved.");
        }
        
    } // end main
    
    public static void printHaiku(String title, String[] array) {
        System.out.println("\n" + title + "\n");
        for (int i = 0; i < array.length; i++) {
            String firstLetter = array[i].substring(0, 1);
            array[i] = firstLetter.toUpperCase() + array[i].substring(1);
            if (i == array.length - 1) {
                System.out.println(array[i] + ".");
            } else {
                System.out.println(array[i] + ", ");
            }
            
        }
    } // end printHaiku
    
    public static int findIdx(String[] arr, String word) {
        int idx = -1;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].toLowerCase();
            if ((arr[i].contains(word))) {
                idx = i;
            }
        }
        return idx;
        
    } // end findIdx
    
    public static boolean search() {
        String search;
        do {
            System.out.print("Continue searching? (y/n) ");
            search = wordscan.nextLine().toLowerCase();
        } while (!(search.equals("y") || search.equals("n")));
            
        if (search.equalsIgnoreCase("y")) {
            return true;
        }
        return false;
        
    } // end search
    
    public static String[] selectionSort(String[] arr) {
        
        int currentMinIndex;
        for (int i = 0; i < arr.length - 1; i++) {
            
            currentMinIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                
                if(arr[j].compareToIgnoreCase(arr[currentMinIndex]) < 0) {
                    
                    currentMinIndex = j;
                }
            }
            if (i != currentMinIndex) {
                
                String temp = arr[currentMinIndex];
                arr[currentMinIndex] = arr[i];
                arr[i] = temp;
            }
        }
        
        return arr;
        
    } // end selectionSort
    
    public static void printArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                System.out.print(array[i]);
            } else {
                System.out.print(array[i] + ", ");
            }
            
        }
    } // end printArray (String)
    
    public static void bubbleSort(String[] array) {
        boolean swap = true;
        while (swap) {
            swap = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i].compareToIgnoreCase(array[i + 1]) > 0) {
                    String temp1 = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp1;
                    
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
