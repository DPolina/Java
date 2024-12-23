import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner wordscan = new Scanner(System.in);
        Scanner numscan = new Scanner(System.in);
        
        String drink, name;
        int age;
        
        System.out.println("What is your name, alcoholic?");
        name = wordscan.nextLine();
        System.out.println("How old are you, " + name + "?");
        age = numscan.nextInt();
        
        if (age >= 18) {
            do {
                System.out.println("You prefer pop or beer?");
                drink = wordscan.nextLine().toLowerCase();
                if (drink.contains("pop")) {
                    drink = "pop";
                } else if (drink.contains("beer")) {
                    drink = "beer"; 
                }
            } while ((drink.equals("pop") || drink.equals("beer")) == false);
        } else {
            drink = "pop";
        }
        
        for (int i = 99; i > 0; i--) {
            String bottle = "bottles";
            if (i == 1) {
                bottle = bottle.substring(0, bottle.length()-1);
            }
            System.out.println(i + " " + bottle + " of " + drink + " on the wall,");
            System.out.println(i + " " + bottle + " of " + drink + ".");
            System.out.println("If one of those bottles should happen to fall,");
            if (i - 1 == 1) {
                bottle = bottle.substring(0, bottle.length()-1);
            } else if (i - 1 == 0) {
                bottle = "bottles";
            }
            System.out.println((i - 1) + " " + bottle + " of " + drink + " on the wall.");
            System.out.println("");
        }
        
    }
}
