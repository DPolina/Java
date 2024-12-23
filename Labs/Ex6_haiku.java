import java.util.Scanner;
import java.util.Calendar;

public class Haiku {
    
    public static int generateNum(int minValue, int maxValue) {
        return (int) (Math.random()*(maxValue - minValue) + minValue);
    }
    
    public static void main(String[] args) {
        
        Scanner wordscan = new Scanner(System.in);
        Scanner numscan = new Scanner(System.in);
        
        String line1, line2, line3, name, place, division, birthday, news = "";
        int age, year, mark, prize, duration;
        
        System.out.println("Welcome to So You Think You Can Haiku!");
        // 1
        System.out.println("What is your name?");
        name = wordscan.nextLine();

        System.out.println(name + ", how old are you? ");
        age = numscan.nextInt();
        
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR) - age;
        
        if (age < 18) {
            division = "Junior Division";
        } else {
            division = "Senior Division";
        }
        
        System.out.println("You are in " + division + ".");
        
        System.out.println("Enter the first line of haiku:");
        line1 = wordscan.nextLine();
        
        System.out.println("Enter the second line of haiku:");
        line2 = wordscan.nextLine();
        
        System.out.println("Enter the last line of haiku:");
        line3 = wordscan.nextLine();
        
        System.out.println("That was a pretty good haiku for someone born in " + year + ".");
        
        mark = generateNum(1, 10);
        
        System.out.println("Your mark out of 10 is " + mark + ".");
        
        System.out.println("How many years have you been writing the haiku?");
        duration = numscan.nextInt();
        
        System.out.println("Where do you work?");
        place = wordscan.nextLine();
        
        String letters1 = line2.substring(line2.length() - 3);
        String letters2 = line3.substring(line3.length() - 3);
        
        prize = duration * mark * 500;
        
        if (letters1.equals(letters2)) {
            prize = prize * 2;
            
            news = " Your haiku will be published in Wiebe-itorial Haiku Digest, the premiere haiku flyer stuffed into nearby neighbourhood mailboxes.";
        }
        
        System.out.println(name + ", that was a pretty good haiku for someone who works at " + place + ". Now, thanks to your great haiku writing skills, you get PRIZEMONEY: " + prize + "$!" + news);
    }
}
