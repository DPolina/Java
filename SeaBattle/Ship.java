public class Ship {
    
  public String name;
  public int size;
  
  public Ship(String theName, int theSize) {
      this.name = theName;
      this.size = theSize;
  }
  
  public String getName() {
      return this.name;
  }
  
  public int getSize() {
      return this.size;
  }
}