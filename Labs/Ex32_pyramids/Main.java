import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    public static Scanner numscan = new Scanner(System.in);
    public static Scanner wordscan = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        ArrayList<Pyramid> pyramids = new ArrayList<Pyramid>();
        ArrayList<House> houses = new ArrayList<House>();
        
        Pyramid pyraCube = new Pyramid("Pyra-Cube", 2, 2, 2);
        Pyramid pyramidOfGiza = new Pyramid("Pyramid of Giza", 230, 230, 147);
        Pyramid fishCreekLibrary = new Pyramid("Fish Creek Library", 51, 101, 17.5);
        pyramids.add(pyraCube);
        pyramids.add(pyramidOfGiza);
        pyramids.add(fishCreekLibrary);
        
        for (int i = 0; i < pyramids.size(); i++) {
            System.out.println("");
            System.out.println(pyramids.get(i).getName() + " has the following properties:");
            pyramids.get(i).printArea();
            pyramids.get(i).printVolume();
        }
        
        House burjKhalifa = new House("Burj Khalifa", 12, 12, 829.8, 20, 20);
        House cottage = new House("Cottage", 10, 12, 15, 5, 10);
        houses.add(burjKhalifa);
        houses.add(cottage);
        
        for (int i = 0; i < houses.size(); i++) {
            System.out.println("");
            System.out.println(houses.get(i).getName() + " has the following properties:");
            houses.get(i).printArea();
            houses.get(i).printVolume();
        }
    }
}
