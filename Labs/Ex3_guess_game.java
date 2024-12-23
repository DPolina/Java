import java.util.Scanner;

public class Main {

    public static int generateNum(int limit, int offset) {
        return (int) (Math.random()*limit + offset);
    }

    public static void main(String[] args) {
        
        Scanner numscan = new Scanner(System.in);
        Scanner wordscan = new Scanner(System.in);
        
        int userGuess, compNum;
        int record = 100;
        
        compNum = generateNum(100,1);
        //System.out.println("Debug: Computer number = " + compNum);
        int counter = 0;
        
        while (true) {
            counter = counter + 1;
            System.out.print("Your number: " + " ");
            userGuess = numscan.nextInt();  
            
            if (userGuess > compNum) {
                System.out.println("You should guess lower.");
            } else if (userGuess < compNum) {
                System.out.println("You should guess higher.");
            } else {
                System.out.println("Congratulatons!");
                System.out.println("(You won in " + counter + " moves)");
                if (counter < record) {
                    record = counter;
                }
                System.out.println("The highest score is " + record + ".");
                System.out.println("Would you like to play again?");
                String answer = wordscan.nextLine().toLowerCase();
                if (answer.startsWith("n")) {
                    System.out.println("Thanks for playing!");
                    break;
                } else {
                  compNum = generateNum(100,1);
                  counter = 0;
                  // System.out.println("Debug: Computer number = " + compNum);
                }
            }
        }
    } //end main
}

