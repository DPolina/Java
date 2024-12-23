
public class Main {//at a halloween party (with social distancing, of course)
    // this code will awardd a prize to one of the attendees, checking first to make sure they are present.
    
    public static void main(String[] args) { 
        
        String[] registrants = {"Frankenstein", "The Mummy", "Bloody Mary", "WWotW", "Casper", "Zombie"};
        boolean[] checkedIn = new boolean[6];
        
        checkedIn[2] = true; // Bloody mary reporting for fun.
        checkedIn[1] = true; // The Mummy is here.
        checkedIn[5] = true; // Zombie is present and checked in.
        
        // for (int i = 0; i < registrants.length; i++) {    
        //     System.out.printf("%s: ", registrants[i]);    <---- How dhould I  do this?
        // }
        
        printArray(registrants);
        printArray(checkedIn);
        
        int winner = (int)(Math.random()*registrants.length);
        while (!checkedIn[winner]) {
            winner = (int)(Math.random()*registrants.length);
        }
        System.out.println("Our winner of pumpkin desert is " + registrants[winner] + "!");
        
    } // end main
    
    public static void printArray(String[] arrays) { // I define a printArray method to print a string
        for (int i = 0; i < arrays.length; i++) {
            System.out.print(arrays[i] + ", ");
        }
        System.out.println();
   } // end printArray (string input)

    public static void printArray(boolean[] arrays) { // I define a printArray method to print a string
        for (int i = 0; i < arrays.length; i++) {
            System.out.print(arrays[i] + ", ");
        }
        System.out.println();
   } // end printArray (boolean input)

} // end class
    
    