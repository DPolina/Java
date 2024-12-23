
public class Main {

    public static void main(String[] args) {
        
        int[] array = {0,2,0,0,0,0,1,2,10,2,1}; // distribution of grades on an assignment. 
       // First element represents number of students that got between 0% and 9%, 
       // the second 10-19%, and so on. Last space for students that got 100%.
        System.out.println("Data distribution");
        
        for(int counter = 0; counter < array.length; counter++){
            if(counter == 10){
                System.out.printf("%5d:", 100);
                // % indicates where in the string you want to place your value.
                // 5 indicates how many spaces you want your value to take up
                // d indicates your argument is an integer (in base-10, decimal)
                // So, the "%5d" is for the format of your output. 
                // The ":" is literally just a colon you want to print.
            }
            else{
                System.out.printf("%02d-%02d:", counter*10, counter*10+9);
            }           
            // The '0' in front of the 2 indicates that if the number is less 
            // than two digits in length, fill those empty digits with 0s.
            // Good website to learn more:https://www.javatpoint.com/java-string-format
                
                for(int stars = 0; stars < array[counter]; stars++) { // This loop just prints the stars.
                    System.out.print("*");
                    }//end inner loop
                System.out.println();
        }//end outer for loop
        }
    }
