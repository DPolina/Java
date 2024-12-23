// import avax.swing.JOptionPane;
import java.util.Scanner;

public class Assign4_Olympics_Drazdouskaya {
    
    public static Scanner numscan = new Scanner(System.in);
    public static Scanner wordscan = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        String longJumpWinner = distanceMedalist();
        System.out.println("The Long Jump Champion is: " + longJumpWinner + ".\n");
        
        String sprintWinner = timeMedalist();
        System.out.println("The 100m sprint champion is: " + sprintWinner + ".\n");
        
        double averageTime = getAverage();
        System.out.printf("The average time is: %.3f seconds.\n", averageTime);
        
        //JOptionPane.showMessageDialog(null, "The average distance/time was : " + getAverage() + "meters. \nGood luck in your next event." );
        
    } // end main
    
    public static String distanceMedalist() {
         
        System.out.println("What is the first participant's name?");
        String name1 = wordscan.nextLine();
        
        System.out.println("What is the first participant's distance (meters)?");
        double distance1 = numscan.nextDouble();
        
        System.out.println("What is the second participant's name?");
        String name2 = wordscan.nextLine();
        
        System.out.println("What is the second participant's distance (meters)?");
        double distance2 = numscan.nextDouble();
        
        String champion;
        
        if (distance1 > distance2) {
            champion = name1;
        } else if (distance1 < distance2) {
            champion = name2;
        } else {
            champion = "TIE";
        }
        
        return champion;
        
    } // end distanceMedalist
    
    public static String timeMedalist() {
        
        System.out.println("What is the first participant's name?");
        String name1 = wordscan.nextLine();
        
        System.out.println("What is the first participant's time (seconds)?");
        double time1 = numscan.nextDouble();
        
        System.out.println("What is the second participant's name?");
        String name2 = wordscan.nextLine();
        
        System.out.println("What is the second participant's time (seconds)??");
        double time2 = numscan.nextDouble();
        
        String champion;
        
        if (time1 < time2) {
            champion = name1;
        } else if (time1 > time2) {
            champion = name2;
        } else {
            champion = "TIE";
        }
        
        return champion;
        
    } // end timeMedalist
    
    public static double getAverage() {
        
        System.out.print("First time, s.     :   ");
        double time1 = numscan.nextDouble();
        
        System.out.print("Second time, s.    :   ");
        double time2 = numscan.nextDouble();
        
        System.out.print("Third time, s.     :   ");
        double time3 = numscan.nextDouble();
        
        double average = (time1 + time2 + time3) / 3;
        
        return average;
        
    } // end getAverage
    
} // end class
