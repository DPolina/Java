public class Fraction
{
    private int numerator;
    private int denominator;
    
    public Fraction(int theNumerator, int theDenominator) {
        numerator = theNumerator;
        denominator = theDenominator;
    }
    
    public int getNumerator() {
        return numerator;
    }
    
    public int getDenominator() {
        return denominator;
    }
    
    public void setNumerator(int x) {
        numerator = x;
    }
    
    public void setDenominator(int x) {
        denominator = x;
    }
    
    public void add(Fraction other) {
        numerator = (numerator * other.getDenominator()) + (other.getNumerator() * denominator);
        denominator = denominator * other.getDenominator();
        reduceFraction();
    }
    
    public void subtract(Fraction other) {
        numerator = (numerator * other.getDenominator()) - (other.getNumerator() * denominator);
        denominator = denominator * other.getDenominator();
        reduceFraction();
    }
    
    public void multiply(Fraction other) {
        numerator = numerator * other.getNumerator();
        denominator = denominator * other.getDenominator();
        reduceFraction();
    }
    
    public void divide(Fraction other) {
        numerator = numerator * other.getDenominator();
        denominator = denominator * other.getNumerator();
        reduceFraction();
    }
    
    public void reduceFraction() {
        int n;
        if (numerator >= denominator) {
            n = numerator;
        } else {
            n = denominator;
        }
        for (int i = 1; i <= n; i ++) {
            if ((numerator % i == 0) && (denominator % i == 0)) {
                numerator = numerator / i;
                denominator = denominator / i;
            }
        }
    }
    
    public String toString() {
        return numerator + "/" + denominator;
    }
}
