import java.util.*;

public class CoinsMain {
    
    public static void main(String[] args) {
        
        Coin coin1 = new Coin("2 Pence (2001)", 12.93, "copper plated steel", 1.72347);
        Coin coin2 = new Coin("100 Francs (1958)", 12.00, "copper-nickel", 23.50);
        Coin coin3 = new Coin("10 Rubles (1992)", 11.0, "copper-nickel clad steel", 0.17);
        Coin coin4 = new Coin("500 Yen (1983)", 13.25, "nickel-brass", 6.06);
        
        ArrayList<Coin> allCoins = new ArrayList<Coin>();
        allCoins.add(coin1);
        allCoins.add(coin2);
        allCoins.add(coin3);
        allCoins.add(coin4);

        for (int i = 0; i < allCoins.size(); i++) {
            System.out.println(allCoins.get(i));
        }
        
        System.out.println("");
        
        for (int i = 0; i < allCoins.size(); i++) {
            System.out.println("The surface area of one side of a " + allCoins.get(i).getName() + " is " + allCoins.get(i).getArea() + " millimetres squared.");
            System.out.println("A " + allCoins.get(i).getName() + "’s circumference is " + allCoins.get(i).getCircumference() + " millimetres.");
            System.out.println("");
        }
    }
}
