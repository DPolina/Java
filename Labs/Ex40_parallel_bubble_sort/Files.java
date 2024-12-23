import java.util.Scanner;

public class Main {
    
    public static Scanner numscan = new Scanner(System.in);
    public static Scanner wordscan = new Scanner(System.in); 
    public static String[] names = { "Hydrogen", "Helium", "Lithium", "Beryllium", "Boron", "Carbon", "Nitrogen", "Oxygen", "Fluorine", "Neon", "Sodium", "Magnesium", "Aluminum", "Silicon", "Phosphorus", "Sulfur", "Chlorine", "Argon", "Potassium", "Calcium", "Scandium", "Titanium", "Vanadium", "Chromium", "Manganese", "Iron", "Cobalt", "Nickel", "Copper", "Zinc", "Gallium", "Germanium", "Arsenic", "Selenium", "Bromine", "Krypton", "Rubidium", "Strontium", "Yttrium", "Zirconium", "Niobium", "Molybdenum", "Technetium", "Ruthenium", "Rhodium", "Palladium", "Silver", "Cadmium", "Indium", "Tin", "Antimony", "Tellurium", "Iodine", "Xenon", "Cesium", "Barium", "Lanthanum", "Cerium", "Praseodymium", "Neodymium", "Promethium", "Samarium", "Europium", "Gadolinium", "Terbium", "Dysprosium", "Holmium", "Erbium", "Thulium", "Ytterbium", "Lutetium", "Hafnium", "Tantalum", "Wolfram", "Rhenium", "Osmium", "Iridium", "Platinum", "Gold", "Mercury", "Thallium", "Lead", "Bismuth", "Polonium", "Astatine", "Radon", "Francium", "Radium", "Actinium", "Thorium", "Protactinium", "Uranium", "Neptunium", "Plutonium", "Americium", "Curium", "Berkelium", "Californium", "Einsteinium", "Fermium", "Mendelevium", "Nobelium", "Lawrencium", "Rutherfordium", "Dubnium", "Seaborgium", "Bohrium", "Hassium", "Meitnerium", "Darmstadtium", "Roentgenium", "Copernicium", "Nihonium", "Flerovium", "Moscovium", "Livermorium", "Tennessine", "Oganesson" };
    public static double[] weights = { 1.007, 4.002, 6.941, 9.012, 10.811, 12.011, 14.007, 15.999, 18.998, 20.18, 22.99, 24.305, 26.982, 28.086, 30.974, 32.065, 35.453, 39.948, 39.098, 40.078, 44.956, 47.867, 50.942, 51.996, 54.938, 55.845, 58.933, 58.693, 63.546, 65.38, 69.723, 72.64, 74.922, 78.96, 79.904, 83.798, 85.468, 87.62, 88.906, 91.224, 92.906, 95.96, 98, 101.07, 102.906, 106.42, 107.868, 112.411, 114.818, 118.71, 121.76, 127.6, 126.904, 131.293, 132.905, 137.327, 138.905, 140.116, 140.908, 144.242, 145, 150.36, 151.964, 157.25, 158.925, 162.5, 164.93, 167.259, 168.934, 173.054, 174.967, 178.49, 180.948, 183.84, 186.207, 190.23, 192.217, 195.084, 196.967, 200.59, 204.383, 207.2, 208.98, 210, 210, 222, 223, 226, 227, 232.038, 231.036, 238.029, 237, 244, 243, 247, 247, 251, 252, 257, 258, 259, 262, 261, 262, 266, 264, 267, 268, 271, 272, 285, 284, 289, 288, 292, 295, 294};
    public static String[] symbols = { "H", "He", "Li", "Be", "B", "C", "N", "O", "F", "Ne", "Na", "Mg", "Al", "Si", "P", "S", "Cl", "Ar", "K", "Ca", "Sc", "Ti", "V", "Cr", "Mn", "Fe", "Co", "Ni", "Cu", "Zn", "Ga", "Ge", "As", "Se", "Br", "Kr", "Rb", "Sr", "Y", "Zr", "Nb", "Mo", "Tc", "Ru", "Rh", "Pd", "Ag", "Cd", "In", "Sn", "Sb", "Te", "I", "Xe", "Cs", "Ba", "La", "Ce", "Pr", "Nd", "Pm", "Sm", "Eu", "Gd", "Tb", "Dy", "Ho", "Er", "Tm", "Yb", "Lu", "Hf", "Ta", "W", "Re", "Os", "Ir", "Pt", "Au", "Hg", "Tl", "Pb", "Bi", "Po", "At", "Rn", "Fr", "Ra", "Ac", "Th", "Pa", "U", "Np", "Pu", "Am", "Cm", "Bk", "Cf", "Es", "Fm", "Md", "No", "Lr", "Rf", "Db", "Sg", "Bh", "Hs", "Mt", "Ds", "Rg", "Cn", "Nh", "Fl", "Mc", "Lv", "Ts", "Og" };
    
    public static void main(String[] args) {
        
        System.out.print("Element Names: ");
        printArray(names);
        System.out.print("\nElement Symbols: ");
        printArray(symbols);
        System.out.print("\nElement Weights: ");
        printArray(weights);
        
        System.out.println("\n\nSorted:");
        bubbleSort(names, weights, symbols);
        
        System.out.print("\nElement Names: ");
        printArray(names);
        System.out.print("\nElement Symbols: ");
        printArray(symbols);
        System.out.print("\nElement Weights: ");
        printArray(weights);
        System.out.println("");
        
        do {
            System.out.print("\nEnter element name: ");
            String elementName = wordscan.nextLine();
            if (binarySearch(names, elementName) == -1) {
                System.out.println("Sorry, this element is not in the list.");
            } else {
                System.out.println(symbols[binarySearch(names, elementName)] + " - " + weights[binarySearch(names, elementName)]);
            }
            if (search() == false) {
                break;
            }
        } while (true);
        
        System.out.println("\nSorted:");
        bubbleSort(symbols, weights, names);
        System.out.print("\nElement Symbols: ");
        printArray(symbols);
        System.out.print("\nElement Names: ");
        printArray(names);
        System.out.print("\nElement Weights: ");
        printArray(weights);
        System.out.println("");
        
        do {
            System.out.print("\nEnter element symbol: ");
            String elementSymbol = wordscan.nextLine();
            if (binarySearch(symbols, elementSymbol) == -1) {
                System.out.println("Sorry, this symbol is not in the list.");
            } else {
                System.out.println(names[binarySearch(symbols, elementSymbol)] + " - " + weights[binarySearch(symbols, elementSymbol)]);
            }
            if (search() == false) {
                break;
            }
        } while (true);
        
    } // end main
    
    
    public static boolean search() {
        String search;
        do {
            System.out.print("Continue searching? (y/n) ");
            search = wordscan.nextLine().toLowerCase();
        } while (!(search.equals("y") || search.equals("n")));
            
        if (search.equalsIgnoreCase("y")) {
            return true;
        } 
        return false;
    }
    
    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                System.out.print(array[i]);
            } else {
                System.out.print(array[i] + ", ");
            }
            
        }
    } // end printArray (int)
    
    public static void printArray(String[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                System.out.print(array[i]);
            } else {
                System.out.print(array[i] + ", ");
            }
            
        }
    } // end printArray (String)
    
    public static void printArray(double[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                System.out.print(array[i]);
            } else {
                System.out.print(array[i] + ", ");
            }
            
        }
    } // end printArray (double)
    
    public static void bubbleSort(String[] array1, double[] array2, String[] array3) {
        boolean swap = true;
        while (swap) {
            swap = false;
            for (int i = 0; i < array1.length - 1; i++) {
                if (array1[i].compareToIgnoreCase(array1[i + 1]) > 0) {
                    String temp1 = array1[i];
                    array1[i] = array1[i + 1];
                    array1[i + 1] = temp1;
                    double temp2 = array2[i];
                    array2[i] = array2[i + 1];
                    array2[i + 1] = temp2;
                    String temp3 = array3[i];
                    array3[i] = array3[i + 1];
                    array3[i + 1] = temp3;
                    swap = true;
                }
            }
        }
    } // end bubbleSort (String)
    
    public static int binarySearch(String[] array, String string) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high)
        {
            int mid = (low + high) / 2;
            if (array[mid].equalsIgnoreCase(string)) {
                return mid;
            } else if(array[mid].compareToIgnoreCase(string) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    } // end binarySearch (String)
    
} // end class
