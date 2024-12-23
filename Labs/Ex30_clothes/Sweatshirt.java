public class Sweatshirt extends Clothing
{
    public boolean hasHood;
    
    public Sweatshirt(String size, String color, boolean hasHood) {
        super(size, color);
        this.hasHood = hasHood;
    }
    
    public String getColor()
    {
        return super.getColor();
    }
    
    public boolean hasHood()
    {
        return hasHood;
        
    }
    
    public String toString() {
        if (hasHood) {
            return size + ", " + color + ", with hood";
        } else {
            return size + ", " + color + ", without hood" ;
        }
        
    }
}
