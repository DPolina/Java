public class Circle {
    
    private String name;
    private double radius;
    private double height;
    
    public Circle(String theName, double theRadius) {
        name = theName;
        radius = theRadius;
        height = 0;
    }
    
    public Circle(String theName, double theRadius, double theHeight) {
        name = theName;
        radius = theRadius;
        height = theHeight;
    }
    
    public String getName() {
        return name;
    }
    
    public void printArea() {
        double area = 2 * 3.14 * radius * (height + radius);
        System.out.println(name + "'s Area is equal to " + area + " meters squared.");
    }
    
    public void printCircumference() {
        double circumference = 2 * 3.14 * radius;
        System.out.println(name + "'s Circumference is equal to " + circumference + " meters.");
    }
    
    public void printVolume() {
        double volume = 3.14 * radius * radius * height;
        if (volume == 0) {
            System.out.println(name + " is not a cylinder. Volume can not be computed.");
        } else {
            System.out.println(name + " is a cylinder. It has a volume of " + volume + " cubic meters.");
        }
    }
}
