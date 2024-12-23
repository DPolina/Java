public class Jeans extends Clothing
{
    public Jeans(String size) {
        super(size, "blue");
    }
    
    public String getColor() {
        return this.color;
    }
    
    public String toString() {
        return size + ", " + color;
    }
}
