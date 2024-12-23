import java.util.Scanner;
//Method - a function aka subroutine, procedure

public class Main {

    public static Scanner numscan = new Scanner(System.in);
    public static Scanner wordscan = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        //findName();
        //doneHomework();
        //openWebpage("https://apod.nasa.gov/apod/astropix.html");
        printArt();
        printArt();
        
        rollTwo();
        rollTwo();
        
        System.out.println("");
        correctOpinion();
        correctOpinion();
        correctOpinion();
        
        System.out.println("");
        testCapital("Edmonton");
        testCapital("Calgary");
        
        System.out.println("");
        testCapitalGrade("Edmonton", 2);
        testCapitalGrade("Calgary", 1);
        
    }//end main
    //all methods go here
    /*
    public static returnType methodName ( parameters ){
        returntype - a value you send back to the program (int, double, string, boolean, void, etc.)
        parameters - values you send into the method, a.k.a. arguments
        PUBLIC is a type of Accessibility Indicator. It means that this method (or variable) is
            useable by any other Java class in the project. Other Accessibility Indicators (such as
            PRIVATE or PROTECTED) limit the useability by other classes. (e.g. using the printArray method from the 
            ArrayUtil.java class worked in other classes because the printArray method was public)
        STATIC is tough to explain until we start talking about creating instances in object-oriented programming 
            in Comp. Sci. 30. STATIC is an indicator that this method does not require an instance of its class to be
            created before using it. (Don't worry about it too much.)
    }
    */
    
    public static void doneHomework(){        
        while(true){
            System.out.println("Have I finished my homework yet?");
            String answer = wordscan.nextLine();
            if( answer.equalsIgnoreCase("no") ){
                System.out.println("Keep working!");
            } else {
                return; // 'return' finishes the current method it is in, returning to the rest of the program.
            }    
        }//end while loop     
    }//end  doneHomework
    
    public static void openWebpage(String url){
        try{
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
        } catch ( Exception e ){
            System.out.println(e);
        }
    }//end openWebpage
    
    public static void findName(){
        String firstName;
        String lastName;
        String thing;
        System.out.println("What is your first name?");
        firstName = wordscan.nextLine();
        System.out.println("What is your last name?");
        lastName = wordscan.nextLine();
        System.out.println("Name a cool animal/object.");
        thing = wordscan.nextLine();
        System.out.println("Your wrestler name is " + firstName + " ''The " + thing + "'' "+ lastName);
        
    }//end findName
    
    public static void printArt() {
        System.out.printf("%15s\n%15s\n%15s\n%15s\n%15s\n%15s\n%15s\n%15s\n", "        *       ", "    *****    ", "  *********  ", "*************", "*****************", "        *       ", "        *       ", " ");
    }
    
    public static void rollTwo() {
        int roll1 = (int)(Math.random()*6 + 1);
        int roll2 = (int)(Math.random()*6 + 1);
        System.out.println("The 1-st was " + roll1);
        System.out.println("The 2-nd was " + roll2);
        if (roll1 > roll2) {
            System.out.println("The higher number was " + roll1);
        } else {
            System.out.println("The higher number was " + roll2);
        }
        
    }
    
    public static void correctOpinion() {
        System.out.println("What is your favorite color?");
        String color = wordscan.nextLine();
        if (color.equalsIgnoreCase("pink")) {
            System.out.println("That is the correct answer. Good job being right.");
        } else if (color.equalsIgnoreCase("red")) {
            System.out.println("Sorry. Incorrect. I think there is something wrong with you. I am so sorry that this is how you had to find out you are a broken human being.");
        } else {
            System.out.println("Partially correct. I can give you part marks for not being silly and selecting " + color + ", but you need to improve your taste in jellybeans. This is important.");
        }
    }
    
    public static void testCapital(String answer) {
        if (answer.equalsIgnoreCase("edmonton")) {
            System.out.println("You are correct.");
        } else {
            System.out.println("Back to grade 2 for you!");
        }
    }
    
    public static void testCapitalGrade(String capital, int grade) {
        if (capital.equalsIgnoreCase("edmonton")) {
            System.out.println("You are correct.");
        } else {
            System.out.println("Back to grade " + grade + " for you!");
        } 
    }
    
} // end class
