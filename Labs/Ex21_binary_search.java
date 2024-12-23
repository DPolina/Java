import java.util.Scanner;
import java.util.concurrent.TimeUnit; // We want to time how long linear vs binary search takes.
// There are methods in this class we can use to do that.

public class Ex7_Binary_Search {
    public static void main(String[] args) {
        Scanner numscan = new Scanner(System.in);
        
        String[] jbFlavours = {"red", "orange", "yellow", "green", "purple", "pink", "black", "white"};
        int[] score = {1, 5, 6, 9, 8, 10, 3, 5}; // out of 10
        
        System.out.println("How tasty of a jellybean do you want to give to your friend?");
        int tastiness = numscan.nextInt();
        
        // Linear search:
        long startTime = System.nanoTime(); // This is the start time (in nanoseconds) of the search.
        int steps = 0; // I want to keep track of how many steps it takes to perform the search.
        int foundIndex = -1;
        for (int i=0; i<score.length; i++) {
            steps++; // Increasing the step count everytime the for loop checks for a match.
            if (tastiness == score[i]) {
                foundIndex = i;
                break;
            }
        }
        long endTime = System.nanoTime();// This is the end time of the search
        
        if (foundIndex == -1){
            System.out.println("Sorry, I could not find a jellybean of that level of tastiness.");
        } else {
            System.out.println("Ah, yes. The " + jbFlavours[foundIndex] + " jellybean is the one you are looking for.");
        }
        
        System.out.println("Linear search took " + steps + " steps to finish and took "+(endTime-startTime) + " nanoseconds to run.");
        System.out.println();
        
        // Binary search: First, we need to get our arrays ordered:
        ArrayUtil.printArray(jbFlavours);
        ArrayUtil.printArray(score);
        
        // Begin bubblesort
        boolean wasUnordered = true;
        while(wasUnordered){
            wasUnordered = false;        
            for (int i=0; i<score.length-1; i++) {
                if (score[i] > score[i+1]){
                    int temp1 = score[i];
                    score[i] = score[i+1];
                    score[i+1] = temp1;
                    wasUnordered = true;
                    
                    String temp2 = jbFlavours[i];
                    jbFlavours[i] = jbFlavours[i+1];
                    jbFlavours[i+1] = temp2;
                }
            }
        }
        // End bubble sort
        ArrayUtil.printArray(jbFlavours);
        ArrayUtil.printArray(score);
        
        System.out.println();
        
        System.out.println("How tasty of a jellybean do you want to give to your friend?");
        tastiness = numscan.nextInt();
        
        // Begin binary search
        /** *******Binary search********
         * - The binary search algorithm starts at the middle of a sorted data 
         * set of numbers and eliminates half of the data; this process repeats 
         * until the desired value is found or all elements have been eliminated.
         * - Data must be in sorted order to use the binary search algorithm.
         * - Binary search is often more efficient than sequential/linear search 
         * when applied to sorted data.
         */
        startTime = System.nanoTime(); //Getting a start time.
        int startIndex = 0; // This line defines the index where we start looking 
        int endIndex = score.length-1;
        int midIndex = (endIndex + startIndex)/2; // calculates the middle index in the array.
        foundIndex = -1;
        steps = 0;//Reseting steps to 0.
        while (endIndex > startIndex){ // Keep going while the endIndex is not startIndex. 
            // If they are equal and you did not find what you were looking for, your search query is not in the array.
            steps++; // Increases the step count everytime search needs to check for a match.
            midIndex = (endIndex + startIndex)/2;
            if (tastiness > score[midIndex]){// Checks provided value against middle element in the array. If it is greater...
                startIndex = midIndex + 1; // ... redefine the start of your search to be right after the midpoint.
            } else if (tastiness < score[midIndex]) {
                endIndex = midIndex - 1; // If less than, redefine the end point to be right before the midpoint.
            } else {
                foundIndex = midIndex; //Otherwise, congrats! You found the search query.
                break;
            }
        }
        endTime = System.nanoTime();
        
        if (foundIndex == -1){
            System.out.println("Sorry, I could not find a jellybean of that level of tastiness.");
        } else {
            System.out.println("Ah, yes. The " + jbFlavours[foundIndex] + " jellybean is the one you are looking for.");
        }
        
        System.out.println("Binary search took " + steps + " steps to finish and took " + (endTime-startTime) + " nanoseconds to run.");
        
    }// end main
}// end class

