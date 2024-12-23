import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Main {
    
    public static Scanner numscan = new Scanner(System.in);
    public static Scanner wordscan = new Scanner(System.in);

    public static void main(String[] args) {
        
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        
        System.out.println("MENU: \n1) Size the array \n2) Fill the array with randon (and possibly duplicate) numbers \n3) Print the array \n4) Swap array elements \n5) Search the array for a value \n6) Count occurrences of a value in the array \n7) Scramble the array \n8) Fill the array with unique (no duplicates) random values \n9) Sum the array \n10) Print menu \n11) Exit");
        while (true) {
            System.out.print("\nWhat manipulations do you want to do with the array? \nAction: ");
            int action = numscan.nextInt();
            while ((action < 1) || (action > 11)) {
                System.out.print("Please, choose from the suggested options. \nWhat manipulations do you want to do with the array? \nAction: ");
                action = numscan.nextInt();
            }
            if (action == 1) {
                System.out.println("Size: " + numbers.size());
            } else if ((action == 2) || (action == 8)) {
                System.out.println("\nGenerating the array: ");
                System.out.print("Array of what size do you want to generate? \nSize: ");
                int sizeOfArray = numscan.nextInt();

                System.out.print("What range of numbers do you want to generate? \nMin: ");
                int minValue = numscan.nextInt();
                System.out.print("Max: ");
                int maxValue = numscan.nextInt();
                int range = maxValue - minValue + 1;
                while ((maxValue < minValue) || ((range < sizeOfArray) && (action == 8))) {
                    if (maxValue < minValue) {
                        System.out.println("Max value can't be less than Min value.");
                    } 
                    if ((range < sizeOfArray) && (action == 8)) {
                        System.out.println("For this kind of array range can't be less than its size.");
                    }
                    System.out.print("What range of numbers do you want to generate? \nMin: ");
                    minValue = numscan.nextInt();
                    System.out.print("Max: ");
                    maxValue = numscan.nextInt();
                    range = range = maxValue - minValue + 1;
                } 
                if (action == 2) {
                    for (int i = 0; i < sizeOfArray; i++) {
                        numbers.add(Randomizer.nextInt(minValue, maxValue));
                    } // fills the array with random (and possibly duplicate) numbers
                } else {
                    numbers.clear();
                    while (numbers.size() < sizeOfArray) {
                        for (int i = 0; i <= numbers.size(); i++) {
                            boolean repeats = false;
                            int n = Randomizer.nextInt(minValue, maxValue);
                            for (int k = 0; k < numbers.size(); k++) {
                                if (n == numbers.get(k)) {
                                    repeats = true;
                                }
                            }
                            if (repeats == false) {
                                numbers.add(n);
                            }
                        }
                    } // fills the array with unique (no uplicates) random values
                }
            } else if (action == 3) {
                if (numbers.isEmpty()) {
                    System.out.println("Array is empty. You can fill the array by doing actions 2 or 8.");
                } else {
                    System.out.print("Array: ");
                    for (int i = 0; i < numbers.size(); i ++) {
                        System.out.print(numbers.get(i) + " ");
                    }
                    System.out.println("");
                }
            } else if (action == 4) {
                String swap = "y";
                if (numbers.isEmpty()) {
                    System.out.println("Array is empty. You can fill the array by doing actions 2 or 8.");
                } else {
                    do {
                        System.out.println("Which numbers do you want to swap? (Enter index)");
                        System.out.print ("1) ");
                        int firstIdx = numscan.nextInt();
                        System.out.print ("2) ");
                        int secondIdx = numscan.nextInt();
                        while ((firstIdx >= numbers.size()) || (firstIdx < 0) || (secondIdx >= numbers.size()) || (secondIdx < 0)) {
                            if ((firstIdx >= numbers.size()) || (firstIdx < 0)) {
                                System.out.print ("Number with the index of " + firstIdx + " is not found. \n");
                            }
                            if ((secondIdx >= numbers.size()) || (secondIdx < 0)) {
                                System.out.print ("Number with the index of " + secondIdx + " is not found. \n");
                            }
                            System.out.println("\nWhich numbers do you want to swap? (Enter index)");
                            System.out.print ("1) ");
                            firstIdx = numscan.nextInt();
                            System.out.print ("2) ");
                            secondIdx = numscan.nextInt();
                        }
                        System.out.println("Switching numbers " + numbers.get(firstIdx) + " and " + numbers.get(secondIdx));
                        Collections.swap(numbers, firstIdx, secondIdx);


                        do {
                            System.out.print("\nContinue swapping? (y/n) ");
                            swap = wordscan.nextLine().toLowerCase();
                        } while (!(swap.equals("y") || swap.equals("n")));
                        if (!(swap.equals("y"))) {
                            break;
                        }
                    } while (swap.equalsIgnoreCase("y")); // Swapping elements in the array
                }
            } else if (action == 5) {
                if (numbers.isEmpty()) {
                    System.out.println("Array is empty. You can fill the array by doing actions 2 or 8.");
                } else {
                    do {
                        int counter = 0;
                        System.out.print("\nWhat number do you want to search for? \nNumber: ");
                        int number = numscan.nextInt();

                        System.out.print("Index: ");
                        for (int i = 0; i < numbers.size(); i++) {
                            if (numbers.get(i) == number) {
                                System.out.print(i + " ");
                                counter += 1;
                            }
                        }
                        if (counter == 0) {
                            System.out.println("-1");
                        } 
                        
                        String search;
                        do {
                            System.out.print("\nContinue searching? (y/n) ");
                            search = wordscan.nextLine().toLowerCase();
                        } while (!(search.equals("y") || search.equals("n")));
                        if (!(search.equals("y"))) {
                            break;
                        }
                    } while (true); // Searching for elements in the array
                }
            } else if (action == 6) {
                if (numbers.isEmpty()) {
                    System.out.println("Array is empty. You can fill the array by doing actions 2 or 8.");
                } else {
                    do {
                        int repeats = 0;
                        System.out.print("\nWhat number do you want to check for repeats? \nNumber: ");
                        int number = numscan.nextInt();
                        
                        for (int i = 0; i < numbers.size(); i++) {
                            if (numbers.get(i) == number) {
                                repeats += 1;
                            }
                        }
                        System.out.print("Repeats: " + repeats);

                        String check;
                        do {
                            System.out.print("\nContinue checking? (y/n) ");
                            check = wordscan.nextLine().toLowerCase();
                        } while (!(check.equals("y") || check.equals("n")));
                        if (!(check.equals("y"))) {
                            break;
                        }
                    } while (true); // Searching for elements in the array
                }
            } else if (action == 7) {
                if (numbers.isEmpty()) {
                    System.out.println("Array is empty. You can fill the array by doing actions 2 or 8.");
                } else {
                    for (int i = 0; i < numbers.size(); i++) {
                        Collections.swap(numbers, numbers.get(i), Randomizer.nextInt(0, numbers.size() - 1));
                    }
                    System.out.println("Scrambling is completed.");
                }
            } else if (action == 9) {
                if (numbers.isEmpty()) {
                    System.out.println("Array is empty. You can fill the array by doing actions 2 or 8.");
                } else {
                    int sum = 0;
                    for (int i = 0; i < numbers.size(); i++) {
                        sum += numbers.get(i);
                    }
                    System.out.println("Sum: " + sum);
                }
            } else if (action == 10) {
                System.out.println("\nMENU: \n1) Size the array \n2) Fill the array with randon (and possibly duplicate) numbers \n3) Print the array \n4) Swap array elements \n5) Search the array for a value \n6) Count occurrences of a value in the array \n7) Scramble the array \n8) Fill the array with unique (no duplicates) random values \n9) Sum the array \n10) Print menu \n11) Exit");
            } else if (action == 11) {
                break;
            }
        } // end while
    } // end main
} // end class
