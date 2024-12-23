public class Rectangle {
    
    private String name;
    private double width;
    private double length;
    private double height;
    
    public Rectangle(String theName, double theWidth, double theLength, double theHeight) {
        name = theName;
        width = theWidth;
        length = theLength;
        height = theHeight;
    }
    
    public Rectangle(String theName, double theWidth, double theLength) {
        name = theName;
        width = theWidth;
        length = theLength;
        height = 0;
    }
    
    public String getName() {
        return name;
    }
    
    public void printArea() {
        double area = 2 * ( width * length + width * height + length * height);
        System.out.println(name + "'s Area is equal to " + area + " meters squared.");
    }
    
    public void printPerimeter(){ 
        double perimeter = 4 * (width + length + height);
        System.out.println(name + "'s Perimeter is equal to " + perimeter + " meters.");
    }
    
    public void printVolume() {
        double volume = width * length * height;
        if (volume == 0) {
            System.out.println(name + " is not a rectangular prism. Volume can not be computed.");
        } else {
            System.out.println(name + " is a rectangular prism. Volume can not be computed.");
        }
    }
}
