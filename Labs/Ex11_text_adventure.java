import java.util.Scanner;

public class Main {
    
    public static int generateNum(int minValue, int maxValue) {
        return (int) (Math.random()*(maxValue - minValue) + minValue);
    }

    public static void main(String[] args) {
        
        Scanner numscan = new Scanner(System.in);
        Scanner wordscan = new Scanner(System.in);
        
        String name, gender;
        String playAgain;
        int choice;
        
        do {
            
            System.out.println("Welcome to my Text Adventure!");
            System.out.println("Let's create character!");
            System.out.println("Chose gender:");
            System.out.println("1. Male");
            System.out.println("2. Female");
            System.out.println("3. Other");
            
            choice = numscan.nextInt();
            
            do {
                switch (choice) {
                    case 1:
                        gender = "Male";
                        break;
                    case 2:
                        gender = "Female";
                        break;
                    case 3:
                        gender = "Undefined";
                        break;
                    default:
                        System.out.println("Invalid answer.");
                }
            } while (choice < 1 || choice > 3);
            
            System.out.println("Do you want to Play again?");
            playAgain= wordscan.nextLine().toLowerCase(); 
            
        } while (playAgain.startsWith("y"));
        
    }
}
