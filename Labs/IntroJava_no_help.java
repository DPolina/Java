import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner wordscan = new Scanner(System.in);
        Scanner numscan = new Scanner(System.in);
        
        String name, capital, province, feelAboutTheTest;
        int points;
        int amountOfTerritories, year;
        
        while (true) {
            points = 0;
            System.out.println("What is your name?");
            name = wordscan.nextLine();
            System.out.println("1) Iqualuit is the capital of which territory?");
            capital = wordscan.nextLine().toLowerCase();
            if (capital.contains("nunavut")) {
               points += 1;
               System.out.println("That's correct answer!");
            } else { 
                points += 0;
                System.out.println("That's wrong answer.");
            }
            System.out.println("2) How many provinces and territories are there in Canada?");
            amountOfTerritories = numscan.nextInt();
            if (amountOfTerritories == 13) {
               points += 1;
               System.out.println("That's correct answer!");
            } else { 
                points += 0;
                System.out.println("That's wrong answer.");
            }
            System.out.println("3) Name one province that is in the 'praries'.");
            province = wordscan.nextLine().toLowerCase();
            if (province.contains("alberta") || province.contains("ssakatchewan") || province.contains("manitoba")) {
               points += 1;
               System.out.println("That's correct answer!");
            } else { 
                points += 0;
                System.out.println("That's wrong answer.");
            }
            System.out.println("4) Name one year during which Stephen Harper was prime minister.");
            year = numscan.nextInt();
            if (year >= 2006 && year <= 2015) {
               points += 1;
               System.out.println("That's correct answer!");
            } else { 
                points += 0;
                System.out.println("That's wrong answer.");
            }
            
            System.out.println(name + ", you recieved " + points + " out of 4.");
            System.out.println("This test was created and marked by Palina Drazdouskaya.");
            System.out.println("How did you feel about today's test?");
            feelAboutTheTest = wordscan.nextLine().toLowerCase();
            if (feelAboutTheTest.contains("good") || feelAboutTheTest.contains("great")) {
                System.out.println("You must be a genius!");
            } else if (feelAboutTheTest.contains("fine") || feelAboutTheTest.contains("ok")) {
                System.out.print("I'm glad you did ok. ");
                System.out.println("Feel free to ask for a Facts about Canada study guide next time to help you prepare.");
            } else if (feelAboutTheTest.endsWith("failed")) {
                System.out.print("Well, then you should sign up for summer school, quickly. ");
                System.out.println("Random facts about Canada 20 is filling up fast.");
            } else {
                System.out.println("Thank you for taking the test.");
            }
        } // end while
    } // end class
} // end maiin
