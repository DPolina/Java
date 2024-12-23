public class House extends Rectangle {
    
    public double yardWidth;
    public double yardLength;
    
    public House(String name, double width, double length, double height, double theYardWidth, double theYardLength) {
        super(name, width, length, height);
        this.yardWidth = theYardWidth;
        this.yardLength = theYardLength;
    }
    
    public void printArea() {
        double houseArea = 2 * ( width * length + width * height + length * height);
        double yardArea = yardWidth * yardLength;
        System.out.println("The house area is " + houseArea + " meters squared.");
        System.out.println("The yard area is " + yardArea + " meters squared.");
    }
    
    public void printVolume() {
        double houseVolume = width * length * height;
        if (houseVolume == 0) {
            System.out.println(name + " is not a building. Volume can not be computed.");
        } else {
            System.out.println("The volume of " + name + " is " + houseVolume + " cubic meters.");
        }
    }
}