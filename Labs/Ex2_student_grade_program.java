import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner numscan = new Scanner(System.in);
        Scanner wordscan = new Scanner(System.in);
        
        // Global variables;
        String name;
        String course;
        int percantage;
        String letter;
        boolean run = true;
        
        while (run == true) {
            System.out.println("What is your name?");
            name = wordscan.nextLine();
            System.out.println("What percentage did you get?");
            percantage = numscan.nextInt();
            System.out.println("What course are you having?");
            course = wordscan.nextLine();

            if(percantage < 50) {
                letter = "an F";
            } else if (percantage >= 50 && percantage < 80) {
                letter = "an C";
            } else {
                letter = "an A";
            }

            System.out.println(name + ", your mark in " + course + " is " + letter + ".");
            System.out.println();

            System.out.println("Beep, boop. Can I ask you a question?");
            String reply = wordscan.nextLine();

            if (reply.equals("Yes")) {
                System.out.print("On a scale og 1 to 10, how good of a ");
                System.out.println("computer am I, 10 being the best.");
                int rating = numscan.nextInt();

                if (rating >= 10) {
                System.out.println("Wow! *blushes in binary*");
                } else if (rating <= 10 && rating >= 5) {
                    System.out.println("That's not too bad. I'll keep trying my best, and I know I'll get better!");
                } else {
                    System.out.println("I'm sorry... *cries in binary*");
                }
            } else {
                System.out.println("Oh, okay");
            }
            System.out.println("Would you like to check the grades of another student?");
            String answer = wordscan.nextLine().toLowerCase();
            if (answer.startsWith("n")) {
                break;
            }
        } // end of while
    } // end main
} // end class

