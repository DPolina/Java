public class Coin {
    
    private double radius;
    private String coinName;
    private String material;
    private double value;
    
    public Coin(String theName, double theRadius, String theMaterial, double theValue) {
        radius = theRadius;
        coinName = theName;
        material = theMaterial;
        value = theValue;
    }
    
    public String getName() {
        return coinName;
    }
    
    public String getMaterial() {
        return material;
    }
    
    public double getValue() {
        return value;
    }
    
    public double getCircumference() {
        return 2 * 3.14 * radius;
    } 
    
    public double getArea() {
        return 3.14 * radius * radius;
    }
    
    public String toString() {
        return coinName + ", " + material + ", " + radius + "mm, " + value + "CAD";
    }
}
