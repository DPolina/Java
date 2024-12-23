import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner wordscan = new Scanner(System.in);
        Scanner numscan = new Scanner(System.in);
        
        String name, car, genre, animal, animals, animalChanged, flavor, sport, answer, ending, endings;
        int points = 0; // 5 points per question max;
        
        while (true) {
            points = 0;
            System.out.println("What is your name, stranger?");
            name = wordscan.nextLine();
            System.out.println("1) What kind of car do you drive?");
            car = wordscan.nextLine().toLowerCase();
            
            if (car.startsWith("n")) {
                System.out.println("Oh, my mum drives the same!");
                points = points + 2;
            } else if (car.startsWith("t") || car.startsWith("c")) {
                System.out.println("Nice choice.");
                points = points + 2;
            } else if (car.startsWith("h") || car.startsWith("w")) {
                System.out.println("Ok.");
                points = points + 1;
            } else if (car.startsWith("j") || car.startsWith("v")) {
                System.out.println("You deserve my respect.");
                points = points + 4;
            } else if (car.startsWith("r")) {
                System.out.println("Brutal guy!");
                points = points + 3;
            }  else if (car.contains("bike") || car.contains("bicycle")) {
                System.out.println("Just like me!");
                points = points + 5;
            } else {
                points = points + 0;
            }
            
            System.out.println("2) What is you favorite book/movie genre?");
            genre = wordscan.nextLine().toLowerCase();
            
            if (genre.contains("detective")) {
                System.out.println("Oh, I like it too!");
                points = points + 4;
            } else if (genre.startsWith("t") || genre.contains("adventure")) {
                System.out.println("Great!");
                points = points + 3;
            }  else if (genre.startsWith("h") || genre.startsWith("r") || genre.startsWith("f")) {
                System.out.println("Wow!");
                points = points + 2;
            } else if (genre.contains("doc")) {
                System.out.println("Not bad.");
                points = points + 1;
            } else if (genre.contains("anime")) {
                System.out.println("You are not alone!");
                points = points + 5;
            } else {
                System.out.println("I had no doubt.");
                points = points + 0;
            }
            
            System.out.println("3) What is you favorite animal?");
            animal = wordscan.nextLine().toLowerCase();
            
            ending = animal.substring(animal.length()-1);
            endings = animal.substring(animal.length()-2);
            if (ending.equals("s") || ending.equals("x") || ending.equals("z") || endings.equals("ch") || endings.equals("sh")) {
                animals = animal + "es";
            } else if (ending.equals("f")) {
                animalChanged = animal.substring(0, animal.length()-1);
                ending = "ves";
                animals = animalChanged + ending;
            } else if (animal.equals("giraffe")) {
                animals = "giraffes";
            } else if (endings.equals("fe")) {
                animalChanged = animal.substring(0, animal.length()-2);
                ending = "ves";
                animals = animalChanged + ending;
            } else if (endings.equals("ff") || endings.equals("ay") || endings.equals("ey") || endings.equals("iy") || endings.equals("oy") ||endings.equals("uy")) {
                animals = animal + "s";
            } else if (animal.equals("mouse")) {
                animals = "mice";
            } else if (animal.equals("fish")|| animal.equals("deer") || animal.equals("sheep") || animal.equals("salmon") || animal.equals("cod")) {
                animals = animal;
            } else if (ending.equals("y")) {
                animalChanged = animal.substring(0, animal.length()-1);
                ending = "ies";
                animals = animalChanged + ending;
            } else {
                animals = animal + "s";
            }
            
            if (animal.endsWith("y")) {
                 System.out.println("Oh, " + animals + " are cute!" );
            } else if (animal.contains("wolf") || animal.contains("crow") || animal.contains("cougar") || animal.contains("cat") || animal.contains("horse")) {
                System.out.println("Oh, I adore " + animals + "!");
                points = points + 5;
            } else if (animal.contains("dolphin") || animal.contains("dog") || animal.contains("tiger") || animal.contains("rabbit") | animal.contains("lion") | animal.contains("leo")) {
                System.out.println("That's good.");
                points = points + 4;
            } else if (animal.contains("shark") || animal.contains("fish") || animal.contains("cheetah") || animal.contains("panda") || animal.contains("saur")) {
                System.out.println("Gotcha!");
                points = points + 3;
            } else if (animal.contains("bear") || animal.contains("parrot") || animal.contains("elk") || animal.contains("raccoon") || animal.contains("owl") | animal.contains("eagle") | animal.contains("jaguar")) {
                System.out.println("Why not?");
                points = points + 2;
            } else if (animal.contains("crocodile") || animal.contains("rat") || animal.contains("monkey") || animal.contains("snake") || animal.contains("turtle") || animal.contains("mouse") || animal.contains("lizard") || animal.contains("spider")) {
                System.out.println("My God, you seriously like " + animals + "?");
                points = points + 1;
            } else {
                System.out.println("I didn't expect this...");
                points = points + 0;
            }
            
            System.out.println("4) What is your favorite jelly beans flavor?");
            flavor = wordscan.nextLine().toLowerCase();
            
            if (flavor.startsWith("m")) {
                System.out.println("Please, stop reading my thoughts!");
                points = points + 5;
            } else if (flavor.startsWith("s") || flavor.startsWith("p")) {
                System.out.println("You definitely have a taste.");
                points = points + 4;
            } else if (flavor.startsWith("a") || flavor.startsWith("l") || flavor.startsWith("o")) {
                System.out.println("Must be sour.");
                points = points + 3;
            } else if (flavor.startsWith("k") || flavor.startsWith("g") || flavor.startsWith("t")) {
                System.out.println("Delicious!");
                points = points + 2;
            } else if (flavor.startsWith("c") || flavor.startsWith("w") || flavor.startsWith("b")) {
                System.out.println("Yum-yum.");
                points = points + 1;
            } else {
                System.out.println(name + ", you surprised me.");
                points = points + 0;
            }
            
            System.out.println("5) What sport do you prefer?");
            sport = wordscan.nextLine().toLowerCase();
            
            if (sport.startsWith("s")) {
                System.out.println("S - Super!");
                points = points + 5;
            } else if (sport.startsWith("f") || sport.startsWith("b")) {
                System.out.println("Cool! I like " + sport + " too.");
                points = points + 4;
            } else if (sport.startsWith("h") || sport.startsWith("v")) {
                System.out.println("Gorgeous!");
                points = points + 3;
            } else if (sport.contains("chess")) {
                System.out.println("Well, " + sport + " is also a sport.");
                points = points + 2;
            } else if (sport.startsWith("r") || sport.startsWith("m") || sport.startsWith("a") || sport.startsWith("j")) {
                System.out.println("Sounds interesting.");
                points = points + 1;
            } else {
                points = points + 0;
            }
            
            if (points > 17) {
                System.out.println("Congratulations! Your coolness level is " + points + " out of 25. You are really cool, bro!");
            } else if (points <= 17 && points > 7 ) {  //  <--------- && is here
                System.out.println("Your coolness level is " + points + " out of 25.");
            } else {
                System.out.println("Your coolness level is only " + points + " points out of 25... Stop crying, life's going on!");
            }
            System.out.println("Would you like to check your coolness level again?");
            answer = wordscan.nextLine().toLowerCase();
            
            while (answer.equalsIgnoreCase("probably") || answer.equalsIgnoreCase("maybe") || answer.equalsIgnoreCase("i'm not sure")) { 
                System.out.println("Would you like to check your coolness level again?"); 
                answer = wordscan.nextLine().toLowerCase();
            }
            if (answer.startsWith("n")) {
                System.out.println("Have a good day, " + name + "!"); 
                break;
            }
        }
    }
}
