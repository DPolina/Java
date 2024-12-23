import java.util.Scanner;

public class Assign5_Translator_Drazdouskaya {
    
    public static Scanner numscan = new Scanner(System.in);
    public static Scanner wordscan = new Scanner(System.in);
    public static void main(String[] args) {
        
        String[] english = {
            "Port",
            "Bow",
            "Point of sail",
            "Helm",
            "Keel",
            "Heeling",
            "Tack",
            "Jib",
            "Windward",
            "Leeward",
            "Lines",
            "Mainsail",
            "Headsail",
            "Head to wind",
            "Close hauled",
            "Beam reach",
            "Broad reach",
            "Running downwind",
            "Mainsheet",
            "Boom",
            "Kicking strap",
            "Burgee",
            "Tracking",
            "Topping lift",
            "Tiller",
            "Forestay",
            "Boom",
            "Mast",
            "Batten",
            "Tell tails",
            "Sprit",
            "Sprit halyard",
            "Wind pennant",
            "Daggerboard",
            "Boomvang",
            "Gunningham",
            "Hiking stick"
        };
        
        String[] russian = {
            "Levyj bort",
            "Nos korablya",
            "Tochka plavanya",
            "Rul'",
            "Kil'",
            "Kren",
            "Gals",
            "Kliver",
            "Navetrennyj",
            "Podvetrennyj",
            "Shnur",
            "Glavnyj parus",
            "Prednyj parus",
            "Leventik",
            "Behjdevind",
            "Galfind",
            "Bagshtag",
            "Fordewind",
            "Shkoty",
            "Gik",
            "Remen' otkrenivaniya",
            "Flazhok",
            "Lavirovka",
            "Topenant",
            "Rumpel'",
            "Shtag",
            "Gik",
            "Machta",
            "Lata",
            "Koldunchiki",
            "Shprint",
            "Otyazhka shprinta",
            "Fluger",
            "Shvert",
            "Otyazhka gika",
            "Gunninhem",
            "Udlinnitel' rumpelya"
        };
        
        String answer;
        System.out.println("Welcome to English-Russian translator for yachtsmen!");
        while (true) {
            System.out.println("Please, choose the language you want to tranlate from: \n1) English \n2) Russian");
            int language = numscan.nextInt();
            if (language == 1) {
                while (true) {
                    System.out.println("This translator works for the following English words: ");
                    for (int i = 0; i < english.length; i++) {
                        System.out.printf("%2d. %s\n", i + 1, english[i]);
                    }
                    System.out.print("Enter the English word you want to translate: ");
                    String word = wordscan.nextLine();
                    int idx = -1;
                    for (int i = 0; i < english.length; i++) {
                        if (word.equalsIgnoreCase(english[i])) {
                            idx = i;
                            break;
                        } 
                    }
                    if (idx < 0) {
                        System.out.print("Not found. ");
                        System.out.print("Please, enter the English word you want to translate: ");
                    } else {
                        System.out.println("English: " + english[idx] + ",\nRussian: " + russian[idx]);
                    } 
                    System.out.println("Continue? (C - Continue; Q - Quit; S - Switch language)");
                    answer = wordscan.nextLine();
                    while (!(answer.equalsIgnoreCase("Q") || answer.equalsIgnoreCase("S") || answer.equalsIgnoreCase("C"))) {
                        System.out.println("Invalid value");
                        answer = wordscan.nextLine();
                    }
                    if (answer.equalsIgnoreCase("Q") || answer.equalsIgnoreCase("S")) {
                        break;
                    } 
                } // end while
                if (answer.equalsIgnoreCase("Q")) {
                    break;
                }
            } else if (language == 2) {
                while (true) {
                    System.out.println("This translator works for the following Russian words: ");
                    for (int i = 0; i < russian.length; i++) {
                        System.out.printf("%2d. %s\n", i + 1, russian[i]);
                    }
                    System.out.print("Enter the Russian word you want to translate: ");
                    String word = wordscan.nextLine();
                    int idx = -1;
                    for (int i = 0; i < russian.length; i++) {
                        if (word.equalsIgnoreCase(russian[i])) {
                            idx = i;
                            break;
                        } 
                    }
                    if (idx < 0) {
                        System.out.print("Not found. ");
                        System.out.print("Please, enter the Russian word you want to translate: ");
                    } else {
                        System.out.println("Russian: " + russian[idx] + ",\nEnglish: " + english[idx]);
                    } 
                    System.out.println("Continue? (C - Continue; Q - Quit; S - Switch language)");
                    answer = wordscan.nextLine();
                    while (!(answer.equalsIgnoreCase("Q") || answer.equalsIgnoreCase("S") || answer.equalsIgnoreCase("C"))) {
                        System.out.println("Invalid value");
                        answer = wordscan.nextLine();
                    }
                    if (answer.equalsIgnoreCase("Q") || answer.equalsIgnoreCase("S")) {
                        break;
                    } 
                    
                } 
                // end while
                if (answer.equalsIgnoreCase("Q")) {
                    break;
                } 
                
            } else {
                System.out.print("Invalid value. ");
            } // end if
            
        }// end while
        
    } // end main
        
} // end class
