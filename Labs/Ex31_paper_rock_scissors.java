import java.util.Scanner;

public class Main
{
    private static final String USER_PLAYER = "User wins!";
    private static final String COMPUTER_PLAYER = "Computer wins!";
    private static final String TIE = "Tie";
    public static Scanner wordscan = new Scanner(System.in);
    private static boolean stillPlaying = true;
    public static String user;
    public static String computer;
        
    private static String getWinner(String user, String computer)
    {
        if ((user.equalsIgnoreCase(computer)) && (user.equalsIgnoreCase("rock") || user.equalsIgnoreCase("paper") || user.equalsIgnoreCase("scissors"))) {
            return TIE;
        } else if ((user.equalsIgnoreCase("rock") && computer.equalsIgnoreCase("scissors")) || (user.equalsIgnoreCase("paper") && computer.equalsIgnoreCase("rock")) || (user.equals("scissors") && computer.equals("paper"))) {
            return USER_PLAYER;
        } else if ((user.equalsIgnoreCase("scissors") && computer.equalsIgnoreCase("rock")) || (user.equalsIgnoreCase("rock") && computer.equalsIgnoreCase("paper")) || (user.equals("paper") && computer.equals("scissors"))) {
            return COMPUTER_PLAYER;
        } else {
            return "Not found";
        }
    }
    
    public static void main(String[] args)
    {
        while (true) { 
            
            System.out.println("Enter your choice (rock, paper, or scissors):");
            user = wordscan.nextLine();
            System.out.println("User: " + user);
            
            if (user.equalsIgnoreCase("enter")) {
                break;
            } 
            
            int num = Randomizer.nextInt(1, 3);
            if (num == 1) {
                computer = "rock";
            } else if (num == 2) {
                computer = "paper";
            } else if (num == 3) {
                computer = "scissors";
            }
            
            System.out.println("Computer: " + computer);
            
            System.out.println(getWinner(user, computer));
        }
    }
}
