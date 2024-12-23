import java.util.Scanner;
import java.util.Calendar;

public class Assign5_LifeExpectancy_Drazdouskaya {
    
    public static Scanner numscan = new Scanner(System.in);
    public static Scanner wordscan = new Scanner(System.in);
    public static int age;

    public static void main(String[] args) {
        
        age = getAge();
        
        System.out.println("\nDriving Insurance Application");
        testAge(age);
        
        System.out.println("\nLife Insurance Application");
        System.out.println("Which province do you live in?");
        String province = wordscan.nextLine();
        
        yearsLeft(age, province);
        
    } // end main
    
    public static int getAge() {
        
        System.out.println("What is the year of your birth?");
        int yearOfBirth = numscan.nextInt();
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        int age = currentYear - yearOfBirth;
        
        return age;
        
    } // end getAge
    
    public static void testAge(int age) {
        
        if (age < 16) {
            System.out.println("Driving Eligibility: Learners License only \nVoting Eligibility: No");
        } else if (age >= 18) {
            System.out.println("Driving Eligibility: Full License \nVoting Eligibility: Yes");
        } else {
            System.out.println("Driving Eligibility: Graduated License \nVoting Eligibility: No");
        }
        
    } // end testAge
    
    public static void yearsLeft(int age, String province) {
       
        if (province.equalsIgnoreCase("alberta")) {
            countLifeExpectancy(79, 84);
        } else if (province.equalsIgnoreCase("quebec")) {
            countLifeExpectancy(81, 84);
        } else {
           countLifeExpectancy(78, 82);
        }
        
    } // end yearsLeft 
    
    public static void countLifeExpectancy(int lifeExpectancyMale, int lifeExpectancyFemale) { 
        
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        
        System.out.println("\nWhat is your gender? \n1. Male \n2. Female");
        int gender = numscan.nextInt();
        
        while (gender > 2 || gender < 1) {
            System.out.println("Invalid value. What is your gender? \n1. Male \n2.Female");
            gender = numscan.nextInt();
        }
        
        if (gender == 1) {
            int yearsLeft = lifeExpectancyMale - age;
            int lastYear = currentYear + yearsLeft;
            System.out.println("According to recent statistics, you will likely live for " + yearsLeft + " years, until the year " + lastYear + ".");
        } else {
            int yearsLeft = lifeExpectancyFemale - age;
            int lastYear = currentYear + yearsLeft;
            System.out.println("According to recent statistics, you will likely live for " + yearsLeft + " years, until the year " + lastYear + ".");
        }
    }
    
} // end class
