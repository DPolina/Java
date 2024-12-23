public class Clothing
{
    public String color;
    public String size;
    
    public Clothing(String size, String color) {
        this.size = size;
        this.color = color;
    }
    
    public String getSize() {
        return this.size;
    }
    
    public String getColor() {
        return this.color;
    }
    
    public String toString() {
        return size + ", " + color;
    }
}
