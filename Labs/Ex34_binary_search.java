import java.util.Scanner;

public class Main {
    
    public static int arr[] = { 12, 13, 32, 35, 46, 68, 71, 73, 88, 94, 99, 10 };
    public static Scanner numscan = new Scanner(System.in);
    public static Scanner wordscan = new Scanner(System.in);

    public static void main(String[] args) {
        
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        
        System.out.print("Enter a number: ");
        int number = numscan.nextInt();
        System.out.println("\nI found it at index number: " + binarySearch(arr, number));
        
    } // end main
    
    public static int binarySearch(int[] arr, int number) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high)
        {
            int mid = (low + high) / 2;
            if (arr[mid] == number) {
                return mid;
            } else if(arr[mid] < number)
            {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    } // end binarySearch
    
    public void printArray() {
        
    }
    
} // end class
