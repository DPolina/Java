import java.util.Arrays;

public class Main {
    
    public static void main(String[] args) {
        
        int[] array1 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] array2 = {5, 6, 4, 8, 9, 7, 3, 1, 2};
        
        System.out.print("First array: ");
        System.out.println(Arrays.toString(array1));
        System.out.print("Second array: ");
        System.out.println(Arrays.toString(array2));
        System.out.println();

        System.out.print("\nFirst array sorted: ");
        System.out.println(Arrays.toString(array1));
        // sort first array
        selectionSort(array1);
        System.out.print("Second array sorted: ");
        System.out.println(Arrays.toString(array2));
        // sort second array
        selectionSort(array2);
    }
    
    // Selection sort takes in an array of integers and
    // returns a sorted array of the same integers.
    
    public static int[] selectionSort(int[] arr) {
        
        public static int swaps = 0;
        int currentMinIndex;
        
        for (int i = 0; i < arr.length - 1; i++) {
            currentMinIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                
                if(arr[j] < arr[currentMinIndex]) {
                    currentMinIndex = j;
                }
            }
            
            // swap numbers if needed
            if (i != currentMinIndex) {
                
                int temp = arr[currentMinIndex];
                arr[currentMinIndex] = arr[i];
                arr[i] = temp;
                swaps += 1;
            }
        }
        
        // Print out the number of swaps that took place here
        // before returning arr
        System.out.println("Swaps: " + swaps);
        
        return arr;
    }
}