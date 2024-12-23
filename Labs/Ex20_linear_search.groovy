
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner wordscan = new Scanner(System.in);
        Scanner numscan = new Scanner(System.in);

        /**
         * ****** Linear Search *********** a.k.a. sequential search 
         * - Linear searches are SLOW 
         * - They are only search algorithm that works on unsorted data
         * - Designed to find the first or only match
         * - Return the index value often returns a NEGATIVE number to indicate
         * not found
         *
         */
        String[] players = Files.loadStringArr("Data/NHL_Stats/nhl_last_names.txt");
        int[] goals = Files.loadIntArr("Data/NHL_Stats/nhl_goals.txt");
        int[] games = Files.loadIntArr("Data/NHL_Stats/nhl_games_played.txt");

//        for(int i=0; i<players.length; i++){
//            System.out.println(players[i]);
//        }
//        
        System.out.println("What player do you want to find?");
        String playerToFind;
        playerToFind = wordscan.nextLine();

        // linear search for player begins
        int foundIndex = -1; // We use -1 as a default index. It will help with 
        // detecting searches that don't find anything.
        for (int i = 0; i < players.length; i++) {
            if (players[i].equalsIgnoreCase(playerToFind)) {
                foundIndex = i; // Save the index of the player in the array
                break; // Quit immediately so that the computer does not waste
                // time checking the rest of the array after finding what was
                // being searched for.
            }
        }
        
        // The search algorithm in ArrayUtil actually does the same thing.
        foundIndex = ArrayUtil.search(players, playerToFind);
        
        
        if (foundIndex == -1) {
            System.out.println("Player did not play that year.");
        } else {
            System.out.println(players[foundIndex] + " scored " + goals[foundIndex] + " in  " + games[foundIndex] + " games played");
        }

        System.out.println("How many goals?");
        int goalsToFind = numscan.nextInt();

        for (int i = 0; i < goals.length; i++) {
            if (goals[i] == goalsToFind) {
                foundIndex = i;
                break;
            }
        }
        while (foundIndex == -1) { // We can set up a while loop to keep searching until a result is returned.
            System.out.println("Not Found. Please enter again ");
            goalsToFind = numscan.nextInt();
            for (int i = 0; i < goals.length; i++) {
                if (goals[i] == goalsToFind) {
                    foundIndex = i;
                    break;
                }
            }

        } 
        System.out.println(players[foundIndex] + " scored " + goals[foundIndex] + " in  " + games[foundIndex] + " games played");

    }//end main
}
