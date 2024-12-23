
public class Main {

    public static void main(String[] args) {
        
        int[] allCards = new int[11]; // create an array for 11 cards
        for(int i = 0; i < allCards.length; i++){
            allCards[i] = (int)(Math.random()*13 + 2); // give each card a random value between 2 and 14 
            // (Values 2-10 refer to the numbered cards, 11 is a jack, 12 is a queen, 13 is a king, and 14 is an ace)
        }
        String[] allSuits = {"clubs", "clubs","clubs","clubs","hearts","hearts","hearts","hearts","diamonds", "diamonds", "spades"};
        ArrayUtil.printArray(allCards);
        ArrayUtil.printArray(allSuits);
        
        // Algorithm #4: Print number of red cards
        int redCards = 0;
        for(int i = 0; i < allCards.length; i++ ){//iterating through/traversing a list
            if (allSuits[i].equals("hearts")  ||   allSuits[i].equals("diamonds")) {
                redCards++;
            }           
        }
        System.out.println("Number of red cards: " + redCards);
        
        // Algorithm #3 - SumIF
        // add all the hearts
        int heartsTotal = 0;
        for(int i = 0; i < allCards.length; i++){
            if(allSuits[i].equals("hearts")){
                heartsTotal += allCards[i];
            }
        }
        System.out.println("Total of all hearts is: " + heartsTotal);
          
        //Algorithm #1 - Add the contents 
        int totalOfCards = 0;
        for(int i = 0; i < allCards.length; i++){
            totalOfCards += allCards[i];
        }
        System.out.println("Total of my hand is: " + totalOfCards);
        
        //Algorithm #2 - CountIF
        //count the Aces
        int numOfAces = 0;
        for(int i = 0; i < allCards.length; i++){
            if(allCards[i] == 14){
                numOfAces++;
            }
        }
        System.out.println("My hand contains " + numOfAces + " Aces.");
        
        // Algorithm #5: Count the odd numbered cards
        int odds = 0;
        for(int i = 0; i < allCards.length; i++){
            if (allCards[i]%2 == 1){
                odds++;
            }
        }
        System.out.println("My hand contains " + odds + " odd cards");
    
    }//end main
    
}//end class
