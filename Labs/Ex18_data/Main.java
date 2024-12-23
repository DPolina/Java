
public class Main { // Ex5_Countries_Files

    public static void main(String[] args) {

        String[] countriesList;
        int[] popList;
        
        countriesList = Files.loadStringArr("Data/Populations/countries.txt"); 
        // The Files class has methods for loading arrays. Just specify the 
        // file location.
        popList = Files.loadIntArr("Data/Populations/populations.txt");
        ArrayUtil.printArray(countriesList); // Using the ArrayUtil class again to print arrays. 
        ArrayUtil.printArray(popList);
        
        popList[0] += 1000;
        Files.saveFile("Data/Populations/populations.txt", popList);
        // The Files class also has methods for 
        
        //print all the countries with population over 1 billion
        for(int i=0; i<popList.length; i++){
            if( popList[i] > 1000000000 ){
                System.out.println(countriesList[i] + "  " + popList[i]);
            }
        }
        //Count the number of countries ending in the letter a
        int countAs = 0;
        for(int i=0; i<countriesList.length; i++){
            if( countriesList[i].endsWith("a") ){
                countAs++;
            }
        }
        System.out.println("Number of countries ending in A is " + countAs);
        
        //Print the name of the country with the smalled population
        int lowestIndex = 0;
        for(int i=0; i<popList.length; i++){
            if( popList[i] < popList[lowestIndex] ){
                lowestIndex = i;
            }
        }
        System.out.print("The smallest country is " + countriesList[lowestIndex]);
        System.out.println(" with a pop of " + popList[lowestIndex]);
        
    }//end main
    
}//end class
// NP and the compulational...
