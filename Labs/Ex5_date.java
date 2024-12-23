import java.util.Calendar;

public class Main {

    public static void main(String[] args) {
        
        String date = "September 21, 2001"; // The date the first episode of Jeopardy! with a moustache-less Alex Trebek aired. 
        String month = date.substring(0, 3) +"."; // ".substring()" will return just part of the string. The numbers indicate the first character to keep and the first number to ignore. Note: Often in computing science we start counting at 0, so the first thing in a list has a position of 0, not 1.
        System.out.println("Month is: " + month);
        String day = date.substring(date.indexOf(" ")+1, date.length()-6); // ".indexOf()" method will return the first position of the specified value. In this case, it finds the first space, then returns it's index value.
        // ".length()" method will return how many characters are in your string (including spaces).
        System.out.println("Day is: " + day + "st");
        
        String year = date.substring(date.length()-4);
        System.out.println("Year is: " + year);
        int age = 2020 - Integer.parseInt(year); // "Integer.parseInt()" is method in the Integer class that takes a string and converts it into an integer.
        System.out.println("Alex Trebek's bare upper lip is " + age + " years old.");
        
        Calendar calendar = Calendar.getInstance(); // This line creates a Calendar object [called 'calendar']. Below, you can see how different properties can be retrieved from the calendar object.
        System.out.println("Year: " + calendar.get(Calendar.YEAR));
        System.out.println("Date: " + calendar.get(Calendar.DATE));
        System.out.println("Month: " + calendar.get(Calendar.MONTH)); // Java starts counting months starting with January = 0.
        System.out.println("Day:  " + calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println("Time: " + calendar.getTime());
    }
}
