public class TShirt extends Clothing
{
    private String fabric; 
    
    public TShirt(String size, String color, String fabric) {
        super(size, color);
        this.fabric = fabric;
    }
    
    public String getFabric() {
        return this.fabric;
    }
    
    public String toString() {
        return size + ", " + color + " fabric" ;
    }
}
