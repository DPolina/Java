import java.util.ArrayList;
import java.util.Scanner;

public class SeaBattle {
    
    public static Scanner numscan = new Scanner(System.in);
    public static Scanner wordscan = new Scanner(System.in);
    public static ArrayList<Ship> shipsInMyStock = new ArrayList<Ship>();
    public static ArrayList<Ship> shipsInOtherStock = new ArrayList<Ship>();
    public static ArrayList<ArrayList<String>> myField = new ArrayList<>();
    public static ArrayList<ArrayList<String>> otherField = new ArrayList<>();
    public static ArrayList<Coordinate> coordinatesOfMyShips = new ArrayList<>();
    public static ArrayList<Coordinate> coordinatesOfOtherShips = new ArrayList<>();
    public static ArrayList<ArrayList<Boolean>> myAvailableCoordinates = new ArrayList<>();
    public static ArrayList<ArrayList<Boolean>> otherAvailableCoordinates = new ArrayList<>();
    public static ArrayList<Coordinate> toAttack = new ArrayList<>();

    public static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String numbers = "0123456789";
    public static Ship carrier = new Ship("Carrier", 5);  
    public static Ship battleship = new Ship("Battleship", 4);
    public static Ship cruiser = new Ship("Cruiser", 3);
    public static Ship submarine = new Ship("Submarine", 3);
    public static Ship destroyer = new Ship("Destroyer", 2);
    
    public static int xCoordinate; // other X
    public static int yCoordinate; // other Y
    public static int XCoordinate; // my X
    public static int YCoordinate; // my Y
    public static String direction;
    boolean acceptableLength = false;
    public static int head = 0;
    public static int tail = 0;
    public static boolean victory = false;
    public static int myScore = 0;
    public static int computersScore = 0;
    public static int myCounter = 0;
    public static int computersCounter = 0;
    
    public static void main(String[] args) {
      
      int N = 10;
        
        do {
            victory = false;
            myScore = 0;
            computersScore = 0;
            myCounter = 0;
            computersCounter = 0;
            coordinatesOfMyShips.clear();
            shipsInMyStock.clear();
            coordinatesOfOtherShips.clear();
            otherAvailableCoordinates.clear();
            shipsInOtherStock.clear();
            myField = buildField(N, N, "-"); // (height, length, symbol)
            otherField = buildField(N, N, "-"); 
            
            for (int i = 0; i < N; i++) {
              myAvailableCoordinates.add(new ArrayList());
              for (int j = 0; j < N; j++) {
                  myAvailableCoordinates.get(i).add(true);
              }
            }

            System.out.println("\n------------[ PREPARATION ]------------ \n\nWhich action would you like to execute? \n\nA) Set field on your own \nB) Generate random field ");
            String action = "";
            do {
                try {
                    System.out.print("\nAction: ");
                    action = wordscan.nextLine();
                    if ((!action.equalsIgnoreCase("a")) && (!action.equalsIgnoreCase("b"))) {
                        System.out.println("Please, choose from the suggested options. ");
                    } 
                } catch (Exception InputMismatchException) {
                    System.out.println("Please, choose from the suggested options. ");
                    wordscan.next();
                }

            } while ((!action.equalsIgnoreCase("a")) && (!action.equalsIgnoreCase("b")));

            if (action.equalsIgnoreCase("a")) {
                setMyField();
            } else if (action.equalsIgnoreCase("b")) { 
                System.out.println("\n--------------[ MY FIELD ]-------------");
                setMyFieldRandomly();
                printField(myField, "");

                String apply = "";
                do {
                    System.out.print("\nApply this placement for the ships? (y/n) ");
                    apply = wordscan.nextLine();
                    if ((!apply.equalsIgnoreCase("y")) && (!apply.equalsIgnoreCase("n"))) {
                        System.out.println("Please, choose from the suggested options. ");
                    } else if (apply.equalsIgnoreCase("n")) {
                        coordinatesOfMyShips.clear();
                        for (int i = 0; i < myField.size(); i++) {
                            for (int j = 0; j < myField.get(0).size(); j++) {
                                myAvailableCoordinates.get(i).set(j, true);
                            }
                        }
                        shipsInMyStock.clear();
                        for (int i = 0; i < myField.size(); i++) {
                            for (int j = 0; j < myField.get(0).size(); j++) {
                                myField.get(i).set(j, "-");
                            }
                        }
                        setMyFieldRandomly();
                        printField(myField, "");
                    } else {
                        System.out.println("");
                    }
                } while (apply.equalsIgnoreCase("n") || (!apply.equalsIgnoreCase("n") && !apply.equalsIgnoreCase("y"))); 
            }

            //printAvailableCoordinates(myAvailableCoordinates);

            setOtherField();

            do {
                System.out.println("\n-------------[ MY ATTACK ]-------------");
                myAttack();
                if (victory == true) {
                    break;
                }
                System.out.println("\n---------[ COMPUTER'S ATTACK ]---------");
                computersAttack();

            } while (victory == false);

            System.out.println("\n[ SCORE ]");
            System.out.printf("%22s%10s", "MOVES", "KILLS");
            System.out.printf("\n%9s%11d%10d", "ME:", myScore, myCounter);
            System.out.printf("\n%9s%11d%10d", "COMPUTER:", computersScore, computersCounter);
            System.out.println("\n\n----------------------------------------\n");
            
            String playAgain = "";
            do {
                System.out.print("Play again? (y/n) ");
                playAgain = wordscan.nextLine();
                if ((!playAgain.equalsIgnoreCase("y")) && (!playAgain.equalsIgnoreCase("n"))) {
                    System.out.println("Please, choose from the suggested options. ");
                } 
            } while ((!playAgain.equalsIgnoreCase("y")) && (!playAgain.equalsIgnoreCase("n")));
            if (playAgain.equalsIgnoreCase("n")) {
                break;
            }
            
        } while (true);
        
    } // end main

    public static Coordinate firstHit = new Coordinate(-1, -1);

    public static void computersAttack() {
        
        boolean successfulAttack = false;
        
        do {
            if (toAttack.size() == 0) {
                do {
                    XCoordinate = (int)(Math.random() * 10);
                    YCoordinate = (int)(Math.random() * 10);
                } while (myField.get(YCoordinate).get(XCoordinate).equals("X") || myField.get(YCoordinate).get(XCoordinate).equals("O"));
            
                if (indexOfCoordinate(coordinatesOfMyShips, XCoordinate, YCoordinate) > -1) { // Hit a ship
                    myField.get(YCoordinate).set(XCoordinate, "X");
                    successfulAttack = true;
                    firstHit = new Coordinate(XCoordinate, YCoordinate);
                    printField(myField, "");
                    System.out.println("\nComputer fired in " + alphabet.substring(XCoordinate, XCoordinate + 1) + (YCoordinate + 1) + " and HIT your ship.");
                    
                    if (XCoordinate + 1 < myField.get(0).size()) {
                        toAttack.add(new Coordinate(XCoordinate + 1, YCoordinate));
                    }
                    if (XCoordinate - 1 >= 0) {
                        toAttack.add(new Coordinate(XCoordinate - 1, YCoordinate));
                    }
                    if (YCoordinate + 1 < myField.size()) {
                        toAttack.add(new Coordinate(XCoordinate, YCoordinate + 1));
                    }
                    if (YCoordinate - 1 >= 0) {
                        toAttack.add(new Coordinate(XCoordinate, YCoordinate - 1));
                    }
                    
                    for (int i = 0; i < toAttack.size(); i++) {
                        if (myField.get(toAttack.get(i).getYCoordinate()).get(toAttack.get(i).getXCoordinate()).equals("O") || myField.get(toAttack.get(i).getYCoordinate()).get(toAttack.get(i).getXCoordinate()).equals("X")) {
                            toAttack.remove(i);
                        }
                    }
    
                    coordinatesOfMyShips.remove(indexOfCoordinate(coordinatesOfMyShips, XCoordinate, YCoordinate));
                    
                } else {
                    myField.get(YCoordinate).set(XCoordinate, "O");
                    successfulAttack = false;
                    printField(myField, "");
                    System.out.println("\nComputer fired in " + alphabet.substring(XCoordinate, XCoordinate + 1) + (YCoordinate + 1) + " and MISSED.");
                }
                
            } else { // if (toAttack.size() > 0)
                
                int idx = (int)(Math.random() * toAttack.size());
                Coordinate attackTo = toAttack.get(idx);
                
                if (indexOfCoordinate(coordinatesOfMyShips, attackTo.getXCoordinate(), attackTo.getYCoordinate()) > -1) { // if hit
                    
                    coordinatesOfMyShips.remove(indexOfCoordinate(coordinatesOfMyShips, attackTo.getXCoordinate(), attackTo.getYCoordinate()));
                    
                    if ((attackTo.getXCoordinate() == XCoordinate + 1) || (attackTo.getXCoordinate() == firstHit.getXCoordinate() + 1)) {
                        
                        XCoordinate = attackTo.getXCoordinate();
                        
                        if (XCoordinate + 1 < myField.get(0).size()) {
                            toAttack.add(new Coordinate(attackTo.getXCoordinate() + 1, attackTo.getYCoordinate()));
                        }
                        
                        if (indexOfCoordinate(toAttack, XCoordinate - 1, YCoordinate + 1) > -1) {
                            toAttack.remove(indexOfCoordinate(toAttack, XCoordinate - 1, YCoordinate + 1));
                        }
                        if (indexOfCoordinate(toAttack, XCoordinate - 1, YCoordinate - 1) > -1) {
                            toAttack.remove(indexOfCoordinate(toAttack, XCoordinate - 1, YCoordinate - 1));
                        }
                            
                    } else if ((attackTo.getXCoordinate() == XCoordinate - 1) || (attackTo.getXCoordinate() == firstHit.getXCoordinate() - 1)) {
                        
                        XCoordinate = attackTo.getXCoordinate();
                        
                        if (XCoordinate - 1 >= 0) {
                            toAttack.add(new Coordinate(attackTo.getXCoordinate() - 1, attackTo.getYCoordinate()));
                        }
                        
                        if (indexOfCoordinate(toAttack, XCoordinate + 1, YCoordinate + 1) > -1) {
                            toAttack.remove(indexOfCoordinate(toAttack, XCoordinate + 1, YCoordinate + 1));
                        }
                        if (indexOfCoordinate(toAttack, XCoordinate + 1, YCoordinate - 1) > -1) {
                            toAttack.remove(indexOfCoordinate(toAttack, XCoordinate + 1, YCoordinate - 1));
                        }
                        
                    } else if ((attackTo.getYCoordinate() == YCoordinate + 1) || (attackTo.getYCoordinate() == firstHit.getYCoordinate() + 1)) {
                        
                        YCoordinate = attackTo.getYCoordinate();
                        
                        if (YCoordinate + 1 < myField.size()) {
                            toAttack.add(new Coordinate(attackTo.getXCoordinate(), attackTo.getYCoordinate() + 1));
                        }
                        
                        if (indexOfCoordinate(toAttack, XCoordinate + 1, YCoordinate - 1) > -1) {
                            toAttack.remove(indexOfCoordinate(toAttack, XCoordinate + 1, YCoordinate - 1));
                        }
                        if (indexOfCoordinate(toAttack, XCoordinate - 1, YCoordinate - 1) > -1) {
                            toAttack.remove(indexOfCoordinate(toAttack, XCoordinate - 1, YCoordinate - 1));
                        }
                        
                    } else if ((attackTo.getYCoordinate() == YCoordinate - 1) || (attackTo.getYCoordinate() == firstHit.getYCoordinate() - 1)) {
                        
                        YCoordinate = attackTo.getYCoordinate();
                        
                        if (YCoordinate - 1 >= 0) {
                            toAttack.add(new Coordinate(attackTo.getXCoordinate(), attackTo.getYCoordinate() - 1));
                        }
                        
                        if (indexOfCoordinate(toAttack, XCoordinate + 1, YCoordinate + 1) > -1) {
                            toAttack.remove(indexOfCoordinate(toAttack, XCoordinate + 1, YCoordinate + 1));
                        }
                        if (indexOfCoordinate(toAttack, XCoordinate - 1, YCoordinate + 1) > -1) {
                            toAttack.remove(indexOfCoordinate(toAttack, XCoordinate - 1, YCoordinate + 1));
                        }
                    } 
                    
                    myField.get(attackTo.getYCoordinate()).set(attackTo.getXCoordinate(), "X");
                    successfulAttack = true;
                    
                    if (isMyKilled()) {
                        surroundDeadShip(myField, myAvailableCoordinates, XCoordinate, YCoordinate);
                        printField(myField, "");
                        System.out.println("\nComputer fired in " + alphabet.substring(attackTo.getXCoordinate(), attackTo.getXCoordinate() + 1) + (attackTo.getYCoordinate() + 1) + " and KILLED your ship.");
                        computersCounter += 1;
                        for (int i = 0; i < toAttack.size(); i++) {
                            toAttack.remove(i);
                        }
                        if (coordinatesOfMyShips.size() == 0) {
                          successfulAttack = false;
                            victory = true;
                            computersScore += 1;
                            System.out.println("\n----------[ YOU ARE DEFEATED ]----------");
                        }
                    } else {
                        printField(myField, "");
                        System.out.println("\nComputer fired in " + alphabet.substring(XCoordinate, XCoordinate + 1) + (YCoordinate + 1) + " and HIT your ship.");
                    }
                    
                    for (int i = 0; i < toAttack.size(); i++) {
                        String cell = myField.get(toAttack.get(i).getYCoordinate()).get(toAttack.get(i).getXCoordinate());
                        
                        if (cell.equals("O") || cell.equals("X")) {
                            toAttack.remove(i);
                        }
                    }
                    
                } else {
                    myField.get(toAttack.get(idx).getYCoordinate()).set(toAttack.get(idx).getXCoordinate(), "O");
                    successfulAttack = false;
                    toAttack.remove(idx);
                    printField(myField, "");
                    System.out.println("\nComputer fired in " + alphabet.substring(attackTo.getXCoordinate(), attackTo.getXCoordinate() + 1) + (attackTo.getYCoordinate() + 1) + " and MISSED.");
                }
            }
            computersScore += 1;

            Scanner pauser = new Scanner (System.in);
            pauser.nextLine();

        } while (successfulAttack == true);
        
    } // end computersAttack
    
    public static void myAttack() {
        
        printField(otherField, "");
        boolean attack = true;
        do {
            askForOtherCoordinate();
            if (otherField.get(yCoordinate).get(xCoordinate).equals("X")) {
               System.out.println("You've already attacked this spot. "); 
            } else if (otherField.get(yCoordinate).get(xCoordinate).equals("O")) {
                System.out.println("This spot is already attacked. "); 
            } else {
                if ((otherAvailableCoordinates.get(yCoordinate).get(xCoordinate) == false)) {
                    otherField.get(yCoordinate).set(xCoordinate, "X");
                    coordinatesOfOtherShips.remove(indexOfCoordinate(coordinatesOfOtherShips, xCoordinate, yCoordinate));
                    if (isOtherKilled()) {
                        System.out.println("\nSHIP IS KILLED!");
                        surroundDeadShip(otherField, otherAvailableCoordinates, xCoordinate, yCoordinate);
                        myCounter += 1;
                    } else {
                        System.out.println("\nHIT!");
                    }
                    printField(otherField, "");
                    attack = true;
                    if (coordinatesOfOtherShips.size() == 0) {
                        attack = false;
                        victory = true;
                        myScore += 1;
                        System.out.println("\n---------------[ VICTORY ]--------------");
                    }
                } else {
                    otherField.get(yCoordinate).set(xCoordinate, "O");
                    System.out.println("\nMISS");
                    attack = false;
                    head = 0;
                    tail = 0;
                }
                myScore += 1;
            }
        } while (attack);
        
    } // end myAttack
    
    public static boolean isOtherKilled() {
        
        boolean isKilled = false;
        if (((xCoordinate + 1 < otherField.get(0).size()) && (otherAvailableCoordinates.get(yCoordinate).get(xCoordinate + 1) == false)) || ((xCoordinate - 1 >= 0) && (otherAvailableCoordinates.get(yCoordinate).get(xCoordinate - 1) == false))) {
            
            for (int i = 0; i < sizeOfShip(otherField, otherAvailableCoordinates, xCoordinate, yCoordinate); i++) {
                if (otherField.get(yCoordinate).get(head + i).equals("X")) {
                    isKilled = true;
                } else {
                    isKilled = false;
                    break;
                }
            }
            
        } else if (((yCoordinate + 1 < otherField.size()) && (otherAvailableCoordinates.get(yCoordinate + 1).get(xCoordinate) == false)) || ((yCoordinate - 1 >= 0) && (otherAvailableCoordinates.get(yCoordinate - 1).get(xCoordinate) == false))) {
            
            for (int i = 0; i < sizeOfShip(otherField, otherAvailableCoordinates, xCoordinate, yCoordinate); i++) {
                if (otherField.get(head + i).get(xCoordinate).equals("X")) {
                    isKilled = true;
                } else {
                    isKilled = false;
                    break;
                }
            }
        }
        return isKilled;
        
    } // end isKilled
    
    public static boolean isMyKilled() {
        
        boolean isKilled = false;
        if (((XCoordinate + 1 < myField.get(0).size()) && (myAvailableCoordinates.get(YCoordinate).get(XCoordinate + 1) == false)) || ((XCoordinate - 1 >= 0) && (myAvailableCoordinates.get(YCoordinate).get(XCoordinate - 1) == false))) {
            // if horizontal
            for (int i = 0; i < sizeOfShip(myField, myAvailableCoordinates, XCoordinate, YCoordinate); i++) {
                if (myField.get(YCoordinate).get(head + i).equals("X")) {
                    isKilled = true;
                } else {
                    isKilled = false;
                    break;
                }
            }
            
        } else if (((YCoordinate + 1 < myField.size()) && (myAvailableCoordinates.get(YCoordinate + 1).get(XCoordinate) == false)) || ((YCoordinate - 1 >= 0) && (myAvailableCoordinates.get(YCoordinate - 1).get(XCoordinate) == false))) {
            // if vertical
            for (int i = 0; i < sizeOfShip(myField, myAvailableCoordinates, XCoordinate, YCoordinate); i++) {
                if (myField.get(head + i).get(XCoordinate).equals("X")) {
                    isKilled = true;
                } else {
                    isKilled = false;
                    break;
                }
            }
        }
        return isKilled;
        
    } // end isMyKilled
    
    public static int sizeOfShip(ArrayList<ArrayList<String>> field, ArrayList<ArrayList<Boolean>> availableCoordinates, int x, int y) {
        
        if (((x + 1 < field.get(0).size()) && (availableCoordinates.get(y).get(x + 1) == false)) || ((x - 1 >= 0) && (availableCoordinates.get(y).get(x - 1) == false))) { 
          // if horizontal
            for (int i = 0; i < field.size(); i++) {
                if ((x - i >= 0) && (availableCoordinates.get(y).get(x - i) == false)) {
                    head = x - i;
                } else {
                    break;
                }
            }
            for (int i = 0; i < field.size(); i++) {
                if ((x + i < field.get(0).size()) && (availableCoordinates.get(y).get(x + i) == false)) {
                    tail = x + i;
                } else {
                    break;
                }
            }
        } else if (((y + 1 < field.size()) && (availableCoordinates.get(y + 1).get(x) == false)) || ((y - 1 >= 0) && (availableCoordinates.get(y - 1).get(x) == false))) { 
          // if vertical
            for (int i = 0; i < field.size(); i++) {
                if ((y - i >= 0) && (availableCoordinates.get(y - i).get(x) == false)) {
                    head = y - i;
                } else {
                    break;
                }
            }
            for (int i = 0; i < field.size(); i++) {
                if ((y + i < field.size()) && (availableCoordinates.get(y + i).get(x) == false)) {
                    tail = y + i;
                } else {
                    break;
                }
            }
        }
        //System.out.println("head: " + head + "; tail: " + tail);
        return tail - head + 1;
    } // end sizeOfShip
    
    public static void setMyField() {

        shipsInMyStock.add(carrier);
        shipsInMyStock.add(battleship);
        shipsInMyStock.add(cruiser);
        shipsInMyStock.add(submarine);
        shipsInMyStock.add(destroyer);
        
        System.out.println("\n---------[ SETTING THE FIELD ]---------\n");
        while (shipsInMyStock.size() != 0) {
            System.out.println("Ships In Stock: \n");
            printShipsInStock(shipsInMyStock);
            do {
                int index;
                try {
                    System.out.print("\nWhich ship would you like to place? (Enter index): ");
                    index = numscan.nextInt() - 1;
                } catch (Exception InputMismatchException) {
                    index = -1;
                    numscan.next();
                }
                    
                if ((index >= 0) && (index < shipsInMyStock.size())) {
                    printField(myField, "MY FIELD:");
                    placeShip(index);
                    break;
                } else {
                    System.out.println("Invalid value. Please, choose from the suggested options. ");
                }
            } while (true);
            System.out.println("");
        }
        
    } // end setField
    
    public static void setOtherField() {
        
        shipsInOtherStock.add(destroyer);
        shipsInOtherStock.add(submarine);
        shipsInOtherStock.add(cruiser);
        shipsInOtherStock.add(battleship);
        shipsInOtherStock.add(carrier);
        
        for (int i = 0; i < otherField.size(); i++) {
            otherAvailableCoordinates.add(new ArrayList());
            for (int j = 0; j < otherField.get(0).size(); j++) {
                otherAvailableCoordinates.get(i).add(true);
            }
        }
        
        for (int idx = 0; idx < shipsInOtherStock.size(); idx++) {
            boolean acceptableLength = false;
            do {
                do {
                    xCoordinate = (int)(Math.random() * 10);
                    yCoordinate = (int)(Math.random() * 10);
                    
                    generateDirection();
                    
                } while ((isOtherAvailable(xCoordinate, yCoordinate) == false)); 
                
                if ((direction.equalsIgnoreCase("r")) && (shipsInOtherStock.get(idx).getSize() <= otherField.get(0).size() - xCoordinate)) {
                    acceptableLength = true;
                    for (int i = 0; i < shipsInOtherStock.get(idx).getSize(); i++) {
                        if (isOtherAvailable(xCoordinate + i, yCoordinate) == false) {
                            acceptableLength = false;
                        }
                    }
                    if (acceptableLength) {
                        for (int i = 0; i < shipsInOtherStock.get(idx).getSize(); i++) {
                            coordinatesOfOtherShips.add(new Coordinate(xCoordinate + i, yCoordinate));
                            otherAvailableCoordinates.get(yCoordinate).set(xCoordinate + i, false);
                        }
                    } 
                } else if ((direction.equalsIgnoreCase("l")) && (shipsInOtherStock.get(idx).getSize() <= xCoordinate + 1)) {
                    acceptableLength = true;
                    for (int i = 0; i < shipsInOtherStock.get(idx).getSize(); i++) {
                        if (isOtherAvailable(xCoordinate - i, yCoordinate) == false) {
                            acceptableLength = false;
                        }
                    }
                    if (acceptableLength) {
                        for (int i = 0; i < shipsInOtherStock.get(idx).getSize(); i++) {
                            coordinatesOfOtherShips.add(new Coordinate(xCoordinate - i, yCoordinate));
                            otherAvailableCoordinates.get(yCoordinate).set(xCoordinate - i, false);
                        }
                    } 
                } else if ((direction.equalsIgnoreCase("u")) && (shipsInOtherStock.get(idx).getSize() <= yCoordinate + 1)) {
                    acceptableLength = true;
                    for (int i = 0; i < shipsInOtherStock.get(idx).getSize(); i++) {
                        if (isOtherAvailable(xCoordinate, yCoordinate - i) == false) {
                            acceptableLength = false;
                        }
                    }
                    if (acceptableLength) {
                        for (int i = 0; i < shipsInOtherStock.get(idx).getSize(); i++) {
                            coordinatesOfOtherShips.add(new Coordinate(xCoordinate, yCoordinate - i));
                            otherAvailableCoordinates.get(yCoordinate - i).set(xCoordinate, false);
                        }
                    } 
                } else if ((direction.equalsIgnoreCase("d")) && (shipsInOtherStock.get(idx).getSize() < otherField.size() - yCoordinate + 1)) {
                    acceptableLength = true;
                    for (int i = 0; i < shipsInOtherStock.get(idx).getSize(); i++) {
                        if (isOtherAvailable(xCoordinate, yCoordinate + i) == false) {
                            acceptableLength = false;
                        }
                    }
                    if (acceptableLength) {
                        for (int i = 0; i < shipsInOtherStock.get(idx).getSize(); i++) {
                            coordinatesOfOtherShips.add(new Coordinate(xCoordinate, yCoordinate + i));
                            otherAvailableCoordinates.get(yCoordinate + i).set(xCoordinate, false);
                        }
                    }
                }
                
            } while (acceptableLength == false);
            
        } // end for
        
    } // end setOtherField
    
    public static void placeShip(int idx) {
        
        System.out.println("\nWhere would you like to place the " + shipsInMyStock.get(idx).getName() + "? (" + shipsInMyStock.get(idx).getSize() + " spaces) ");
        
        xCoordinate = -1;
        yCoordinate = -1;
        direction = "";
        boolean acceptableLength = false;
        
        do {
            askForMyCoordinate();
            
            System.out.print("Choose direction (l-left, r-right, u-up, d-down): ");
            direction = wordscan.nextLine();
            if ((direction.equalsIgnoreCase("l")) || (direction.equalsIgnoreCase("r")) || (direction.equalsIgnoreCase("u")) || (direction.equalsIgnoreCase("d"))) {
                
                if ((direction.equalsIgnoreCase("r")) && (shipsInMyStock.get(idx).getSize() <= myField.get(0).size() - xCoordinate)) {
                    acceptableLength = true;
                    for (int i = 0; i < shipsInMyStock.get(idx).getSize(); i++) {
                        if (isMyAvailable(xCoordinate + i, yCoordinate) == false) {
                            acceptableLength = false;
                        }
                    }
                    if (acceptableLength) {
                        for (int i = 0; i < shipsInMyStock.get(idx).getSize(); i++) {
                            myField.get(yCoordinate).set(xCoordinate + i, "#");
                            coordinatesOfMyShips.add(new Coordinate(xCoordinate + i, yCoordinate));
                            myAvailableCoordinates.get(yCoordinate).set(xCoordinate + i, false);
                        }
                    } else {
                        System.out.println("Not enough space. ");
                    }
                } else if ((direction.equalsIgnoreCase("l")) && (shipsInMyStock.get(idx).getSize() <= xCoordinate + 1)) {
                    acceptableLength = true;
                    for (int i = 0; i < shipsInMyStock.get(idx).getSize(); i++) {
                        if (isMyAvailable(xCoordinate - i, yCoordinate) == false) {
                            acceptableLength = false;
                        }
                    }
                    if (acceptableLength) {
                        for (int i = 0; i < shipsInMyStock.get(idx).getSize(); i++) {
                            myField.get(yCoordinate).set(xCoordinate - i, "#");
                            coordinatesOfMyShips.add(new Coordinate(xCoordinate - i, yCoordinate));
                            myAvailableCoordinates.get(yCoordinate).set(xCoordinate - i, false);
                        }
                    } else {
                        System.out.println("Not enough space. ");
                    }
                } else if ((direction.equalsIgnoreCase("u")) && (shipsInMyStock.get(idx).getSize() <= yCoordinate + 1)) {
                    acceptableLength = true;
                    for (int i = 0; i < shipsInMyStock.get(idx).getSize(); i++) {
                        if (isMyAvailable(xCoordinate, yCoordinate - i) == false) {
                            acceptableLength = false;
                        }
                    }
                    if (acceptableLength) {
                        for (int i = 0; i < shipsInMyStock.get(idx).getSize(); i++) {
                            myField.get(yCoordinate - i).set(xCoordinate, "#");
                            coordinatesOfMyShips.add(new Coordinate(xCoordinate, yCoordinate - i));
                            myAvailableCoordinates.get(yCoordinate - i).set(xCoordinate, false);
                        }
                    } else {
                        System.out.println("Not enough space. ");
                    }
                } else if ((direction.equalsIgnoreCase("d")) && (shipsInMyStock.get(idx).getSize() < myField.size() - yCoordinate + 1)) {
                    acceptableLength = true;
                    for (int i = 0; i < shipsInMyStock.get(idx).getSize(); i++) {
                        if (isMyAvailable(xCoordinate, yCoordinate + i) == false) {
                            acceptableLength = false;
                        }
                    }
                    if (acceptableLength) {
                        for (int i = 0; i < shipsInMyStock.get(idx).getSize(); i++) {
                            myField.get(yCoordinate + i).set(xCoordinate, "#");
                            coordinatesOfMyShips.add(new Coordinate(xCoordinate, yCoordinate + i));
                            myAvailableCoordinates.get(yCoordinate + i).set(xCoordinate, false);
                        }
                    } else {
                        System.out.println("Not enough space. ");
                    }
                } else {
                    System.out.println("Not enough space. ");
                }
            } else {
                System.out.println("Invalid value. ");
            }
            
        } while (acceptableLength == false);
        
        
        printField(myField, "MY FIELD:");
        shipsInMyStock.remove(idx);
        
    } // end placeShip
    
    public static int indexOfCoordinate(ArrayList<Coordinate> coordinates, int x, int y) {
        
        for (int i = 0; i < coordinates.size(); i++) {
            if ((x == coordinates.get(i).getXCoordinate()) && (y == coordinates.get(i).getYCoordinate())) {
                return i;
            }
        }
        return -1;
    }
    
    public static void surroundDeadShip(ArrayList<ArrayList<String>> field, ArrayList<ArrayList<Boolean>> availableCoordinates, int x, int y) {
        
        if (((x + 1 < field.get(0).size()) && (availableCoordinates.get(y).get(x + 1) == false)) || ((x - 1 >= 0) && (availableCoordinates.get(y).get(x - 1) == false))) {
            if (head - 1 >= 0) {
                if (y + 1 < field.size()) {
                    field.get(y + 1).set(head - 1, "O");
                }
                if (y - 1 >= 0) {
                    field.get(y - 1).set(head - 1, "O");
                }
                field.get(y).set(head - 1, "O");
            }
            for (int i = 0; i < sizeOfShip(field, availableCoordinates, x, y); i++) {
                if (y + 1 < field.size()) {
                    field.get(y + 1).set(head + i, "O");
                }
                if (y - 1 >= 0) {
                    field.get(y - 1).set(head + i, "O");
                }
            }
            if (tail + 1 < field.get(tail).size()) {
                if (y + 1 < field.size()) {
                  field.get(y + 1).set(tail + 1, "O");  
                }
                if (y - 1 >= 0) {
                    field.get(y - 1).set(tail + 1, "O");
                }
                field.get(y).set(tail + 1, "O");
            } // horizontal

        } else if (((y + 1 < field.size()) && (availableCoordinates.get(y + 1).get(x) == false)) || ((y - 1 >= 0) && (availableCoordinates.get(y - 1).get(x) == false))) {
            if (head - 1 >= 0) {
                if (x + 1 < field.get(head).size()) {
                    field.get(head - 1).set(x + 1, "O");
                }
                if (x - 1 >= 0) {
                    field.get(head - 1).set(x - 1, "O");
                }
                field.get(head - 1).set(x, "O");
            }
            for (int i = 0; i < sizeOfShip(field, availableCoordinates, x, y); i++) {
                if (x + 1 < field.get(0).size()) {
                    field.get(head + i).set(x + 1, "O");
                }
                if (x - 1 >= 0) {
                    field.get(head + i).set(x - 1, "O");
                }
            }
            if (tail + 1 < field.size()) {
                if (x + 1 < field.get(head).size()) {
                    field.get(tail + 1).set(x + 1, "O");
                }
                if (x - 1 >= 0) {
                    field.get(tail + 1).set(x - 1, "O");
                }
                field.get(tail + 1).set(x, "O");
            } // vertical
        }
    } // end surroundDeadShip
    
    public static String generateDirection() {
        
        int rand = (int)(Math.random() * 4);
        switch (rand) {
            case 0:
                direction = "r";
                break;
            case 1:
                direction = "l";
                break;
            case 2:
                direction = "u";
                break;
            case 3:
                direction = "d";
                break;
        }
        return direction;
    } // end generateDirection
    
    public static ArrayList<ArrayList<String>> buildField(int height, int width, String symbol) {
        ArrayList<ArrayList<String>> field = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            field.add(new ArrayList());
            for (int j = 0; j < width; j++) {
                field.get(i).add(symbol);
            }
        }
        
        return field;
    } // end buildField
    
    public static boolean checkIfNumber(String str) {
        boolean isNumber = true;
        if (containsLetter(str) || str.contains(" ") || (containsNumber(str) == false)) {
            isNumber = false;
        }
        return isNumber;
        
    } // end checkIfNumber
    
    public static boolean checkIfLetter(String str) {
        for (int i = 0; i < alphabet.length(); i++) {
            if (str.equalsIgnoreCase(alphabet.substring(i, i + 1))) {
                return true;
            }
        }
        return false;
    } // end checkIfLetter
    
    public static boolean containsNumber(String str) {
        for (int i = 0; i < numbers.length(); i++) {
            for (int j = 0; j < str.length(); j++) {
                if (str.substring(j, j + 1).equals(numbers.substring(i, i + 1))) {
                    return true;
                } 
            }
        }
        return false;
    } // end containsNumber
    
    public static boolean containsLetter(String str) {
        for (int i = 0; i < alphabet.length(); i++) {
            for (int j = 0; j < str.length(); j++) {
                if (str.substring(j, j + 1).equalsIgnoreCase(alphabet.substring(i, i + 1))) {
                    return true;
                } 
            }
        }
        return false;
    } // end containsLetter
    
    public static int returnIndexOfLetter(String letter) {
        int index = -1;
        if (checkIfLetter(letter)) {
            for (int i = 0; i < alphabet.length(); i++) {
                if (letter.equalsIgnoreCase(alphabet.substring(i, i + 1))) {
                   index = i;  
                }
            }
        } 
        return index;
    } // end returnIndexOfLetter
    
    public static boolean isMyAvailable(int x, int y) {
        if ((x < 0) || (x >= myField.get(0).size()) || (y < 0) || (y >= myField.size())) {
            return false;
        }
        for (int i = 0; i < coordinatesOfMyShips.size(); i++) {
            if ((((x == coordinatesOfMyShips.get(i).getXCoordinate() + 1) || (x == coordinatesOfMyShips.get(i).getXCoordinate() - 1) || (x == coordinatesOfMyShips.get(i).getXCoordinate())) && ((y == coordinatesOfMyShips.get(i).getYCoordinate() + 1) || (y == coordinatesOfMyShips.get(i).getYCoordinate() - 1) || (y == coordinatesOfMyShips.get(i).getYCoordinate())))) {
                return false;
            }
        }
        return true;
    } // end isMyAvailable
    
    public static boolean isOtherAvailable(int x, int y) {
        if ((x < 0) || (x >= otherField.get(0).size()) || (y < 0) || (y >= otherField.size())) {
            return false;
        }
        if (coordinatesOfOtherShips.size() > 0) {
            for (int i = 0; i < coordinatesOfOtherShips.size(); i++) {
                if ((((x == coordinatesOfOtherShips.get(i).getXCoordinate() + 1) || (x == coordinatesOfOtherShips.get(i).getXCoordinate() - 1) || (x == coordinatesOfOtherShips.get(i).getXCoordinate())) && ((y == coordinatesOfOtherShips.get(i).getYCoordinate() + 1) || (y == coordinatesOfOtherShips.get(i).getYCoordinate() - 1) || (y == coordinatesOfOtherShips.get(i).getYCoordinate())))) {
                    return false;
                }
            }
        } 
        return true;
        
    } // end isOtherAvailable
    
    public static void printField(ArrayList<ArrayList<String>> field, String headline) {
        
        System.out.println(headline); 
        System.out.printf("%10s", "");
        
        for (int i = 0; i < field.get(0).size(); i++) {
            System.out.print(alphabet.charAt(i) + " ");
        }
        System.out.println("");
        
        for (int i = 0; i < field.size(); i++) {
            System.out.printf("%6s%3d ", " ", (i + 1));
            
            for (int j = 0; j < field.get(i).size(); j++) {
                System.out.print(field.get(i).get(j) + " ");
            }
            System.out.println("");
        }
        
    } // end printMyField
    
    public static void printAvailableCoordinates(ArrayList<ArrayList<Boolean>> coordinates) {
        
        System.out.println("\nCoordinates: \n"); 
        System.out.print("     ");
        
        for (int i = 0; i < coordinates.get(0).size(); i++) {
            System.out.printf("%-6s", alphabet.charAt(i));
        }
        System.out.println("");
        
        for (int i = 0; i < coordinates.size(); i++) {
            if (i < 9) {
                System.out.print(" " + (i + 1) + " ");
            } else {
                System.out.print((i + 1) + " "); 
            }
            for (int j = 0; j < coordinates.get(i).size(); j++) {
                System.out.printf(" %-5b", coordinates.get(i).get(j));
            }
            System.out.println("");
        }
        
    } // end printMyField
    
    public static void printShipsInStock(ArrayList<Ship> shipsInStock) {
        for (int i = 0; i < shipsInStock.size(); i++) {
            System.out.println((i + 1) + ") " + shipsInStock.get(i).getName() + " (" + shipsInStock.get(i).getSize() + " spaces)");
        }
    } // end printShipsInStock
    
    public static void askForMyCoordinate() {
        do {
            System.out.print("\nEnter first coordinate: ");
            String coordinate;
            do {
                coordinate = wordscan.nextLine();
                if (coordinate.length() > 0) {
                    break;
                } 
            } while (true);

            String letter = coordinate.substring(0, 1);
            String number = coordinate.substring(1);

            if ((checkIfLetter(letter)) && (checkIfNumber(number)) && (returnIndexOfLetter(letter) < myField.get(0).size()) && (Integer.parseInt(number) <= myField.size()) && (coordinate.length() > 1) ) { 

                xCoordinate = returnIndexOfLetter(letter);
                yCoordinate = Integer.parseInt(number) - 1; 

            } else {            
                System.out.print("Invalid value. ");
                if ((containsNumber(coordinate) == false) || (containsLetter(coordinate) == false) || (coordinate.length() <= 1)) {
                    System.out.println("Coordinate must include both letter and number. ");
                } else {
                    if ((checkIfLetter(letter) == false) || (returnIndexOfLetter(letter) >= myField.get(0).size())) {
                        System.out.print("First character must be a letter from A to " + alphabet.substring(myField.get(0).size() - 1, myField.get(0).size()) + ". ");
                    } 
                    if ((checkIfNumber(number) == false) || (Integer.parseInt(number) > myField.size())) { 
                        System.out.print("Second character must be a number from 1 to " + myField.size() + ".");
                    }
                    System.out.println("");
                }
                xCoordinate = -1;
                yCoordinate = -1;
            }
            if ((isMyAvailable(xCoordinate, yCoordinate) == false) && (xCoordinate >= 0) && (yCoordinate >= 0)) {
                System.out.println("This spot is not available. ");
            } 

        } while ((isMyAvailable(xCoordinate, yCoordinate) == false) || (xCoordinate == -1) || (yCoordinate == -1));
    } // end askForMyCoordinate
    
    public static void askForOtherCoordinate() {
        do {
            System.out.print("\nEnter first coordinate: ");
            String coordinate;
            do {
                coordinate = wordscan.nextLine();
                if (coordinate.length() > 0) {
                    break;
                } 
            } while (true);

            String letter = coordinate.substring(0, 1);
            String number = coordinate.substring(1);

            if ((checkIfLetter(letter)) && (checkIfNumber(number)) && (returnIndexOfLetter(letter) < otherField.get(0).size()) && (Integer.parseInt(number) <= otherField.size()) && (coordinate.length() > 1) ) { 

                xCoordinate = returnIndexOfLetter(letter);
                yCoordinate = Integer.parseInt(number) - 1; 

            } else {            
                System.out.print("Invalid value. ");
                if ((containsNumber(coordinate) == false) || (containsLetter(coordinate) == false) || (coordinate.length() <= 1)) {
                    System.out.println("Coordinate must include both letter and number. ");
                } else {
                    if ((checkIfLetter(letter) == false) || (returnIndexOfLetter(letter) >= otherField.get(0).size())) {
                        System.out.print("First character must be a letter from A to " + alphabet.substring(otherField.get(0).size() - 1, otherField.get(0).size()) + ". ");
                    } 
                    if ((checkIfNumber(number) == false) || (Integer.parseInt(number) > otherField.size())) { // ???
                        System.out.print("Second character must be a number from 1 to " + otherField.size() + ".");
                    }
                    System.out.println("");
                }
                xCoordinate = -1;
                yCoordinate = -1;
            }

        } while ((xCoordinate == -1) || (yCoordinate == -1));
        
    } // end askForOtherCoordinate
    
    public static void setMyFieldRandomly() {
        
        shipsInMyStock.add(destroyer);
        shipsInMyStock.add(submarine);
        shipsInMyStock.add(cruiser);
        shipsInMyStock.add(battleship);
        shipsInMyStock.add(carrier);
        
        for (int idx = 0; idx < shipsInMyStock.size(); idx++) {
            boolean acceptableLength = false;
            do {
                do {
                    xCoordinate = (int)(Math.random() * 10);
                    yCoordinate = (int)(Math.random() * 10);
                    
                    generateDirection();
                    
                } while ((isMyAvailable(xCoordinate, yCoordinate) == false)); // Takes random coordinates
                
                if ((direction.equalsIgnoreCase("r")) && (shipsInMyStock.get(idx).getSize() <= myField.get(0).size() - xCoordinate)) {
                    acceptableLength = true;
                    for (int i = 0; i < shipsInMyStock.get(idx).getSize(); i++) {
                        if (isMyAvailable(xCoordinate + i, yCoordinate) == false) {
                            acceptableLength = false;
                        }
                    }
                    if (acceptableLength) {
                        for (int i = 0; i < shipsInMyStock.get(idx).getSize(); i++) {
                            myField.get(yCoordinate).set(xCoordinate + i, "#");
                            coordinatesOfMyShips.add(new Coordinate(xCoordinate + i, yCoordinate));
                            myAvailableCoordinates.get(yCoordinate).set(xCoordinate + i, false);
                        }
                    } 
                } else if ((direction.equalsIgnoreCase("l")) && (shipsInMyStock.get(idx).getSize() <= xCoordinate + 1)) {
                    acceptableLength = true;
                    for (int i = 0; i < shipsInMyStock.get(idx).getSize(); i++) {
                        if (isMyAvailable(xCoordinate - i, yCoordinate) == false) {
                            acceptableLength = false;
                        }
                    }
                    if (acceptableLength) {
                        for (int i = 0; i < shipsInMyStock.get(idx).getSize(); i++) {
                            myField.get(yCoordinate).set(xCoordinate - i, "#");
                            coordinatesOfMyShips.add(new Coordinate(xCoordinate - i, yCoordinate));
                            myAvailableCoordinates.get(yCoordinate).set(xCoordinate - i, false);
                        }
                    } 
                } else if ((direction.equalsIgnoreCase("u")) && (shipsInMyStock.get(idx).getSize() <= yCoordinate + 1)) {
                    acceptableLength = true;
                    for (int i = 0; i < shipsInMyStock.get(idx).getSize(); i++) {
                        if (isMyAvailable(xCoordinate, yCoordinate - i) == false) {
                            acceptableLength = false;
                        }
                    }
                    if (acceptableLength) {
                        for (int i = 0; i < shipsInMyStock.get(idx).getSize(); i++) {
                            myField.get(yCoordinate - i).set(xCoordinate, "#");
                            coordinatesOfMyShips.add(new Coordinate(xCoordinate, yCoordinate - i));
                            myAvailableCoordinates.get(yCoordinate - i).set(xCoordinate, false);
                        }
                    } 
                } else if ((direction.equalsIgnoreCase("d")) && (shipsInMyStock.get(idx).getSize() < myField.size() - yCoordinate + 1)) {
                    acceptableLength = true;
                    for (int i = 0; i < shipsInMyStock.get(idx).getSize(); i++) {
                        if (isMyAvailable(xCoordinate, yCoordinate + i) == false) {
                            acceptableLength = false;
                        }
                    }
                    if (acceptableLength) {
                        for (int i = 0; i < shipsInMyStock.get(idx).getSize(); i++) {
                            myField.get(yCoordinate + i).set(xCoordinate, "#");
                            coordinatesOfMyShips.add(new Coordinate(xCoordinate, yCoordinate + i));
                            myAvailableCoordinates.get(yCoordinate + i).set(xCoordinate, false);
                        }
                    }
                }
                
            } while (acceptableLength == false);
            
        } // end for
        
    } // end setMyFieldRandomly
    
} // end class
