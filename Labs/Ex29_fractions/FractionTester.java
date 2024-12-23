public class FractionTester //extends ConsoleProgram ??
{
    public void run()
    {
        // Implement the Fraction class in Fraction.java
        
        Fraction f1 = new Fraction(1, 3);
        Fraction f2 = new Fraction(4, 3);
        
        System.out.println("BEFORE:");
        System.out.println("first: " + f1);
        System.out.println("second: " + f2);
        
        f1.divide(f2);
        
        System.out.println("");
        System.out.println("AFTER:");
        System.out.println("first: " + f1);
        System.out.println("second: " + f2);
        
        // Then add code here to test out your Fraction class!
    }
}
