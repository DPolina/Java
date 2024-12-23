
public class Main {
    
    public static double generateNum(double limit, double offset) {
        return (double) (Math.random()*limit + offset);
    } // end GenerateNum
    
    public static void main(String[] args) {
        
        String winner = "";
        String[] names = {
            "Fred",
            "Bob",
            "Robert",
            "Ruth",
            "Jack",
            "Rob",
            "Jason",
            "Mike",
            "Ann",
            "Julian"
        };
        double[] raisedMoney = new double[names.length];
        boolean[] filledForms = new boolean[names.length];
        double total = 0.00;
        int counter = 0;
        
        System.out.printf("%-15s%-18s%-25s", "Name", "Raised money", "Registration forms");
        System.out.println("");
        
        for (int i = 0; i < names.length; i++) {
            double trueFalse;
            trueFalse = generateNum(2, 1);
            if (trueFalse < 2) {
                filledForms[i] = true;
            } else {
                filledForms[i] = false;
            }
            raisedMoney[i] = generateNum(500.00, 50.00);
            if (raisedMoney[i] < 100) {
                counter += 1;
            } 
            total = total + raisedMoney[i]; 
            System.out.printf("%-18s$%-20.2f%-20s", names[i], raisedMoney[i], filledForms[i]);
            System.out.println("");
        }
        
        System.out.println("");
        double average = total / raisedMoney.length;
        System.out.printf("The totlal amount raised by your team: $%.2f;", total);
        System.out.println("");
        System.out.printf("The average amount raised per student: $%.2f;", average);
        System.out.println("");
        System.out.printf("The number of students who raised less than $100: %d;", counter);
        System.out.println("");
        System.out.print("The names of students who have not turned in their forms: ");
        
        double max = raisedMoney[0];
        String delimiter = "";
        for (int i = 0; i < filledForms.length; i++) {
            if (filledForms[i] != true) {
                System.out.printf("%s %s", delimiter, names[i]);
                delimiter = ",";
            }
            if (max <= raisedMoney[i]) {
                max = raisedMoney[i];
                winner = names[i];
            } 
        }
        if (delimiter != "") {
            System.out.println(".");
        }
        
        max = Math.floor(max * 100) / 100;
        System.out.println("");
        System.out.println("The highest amount is raised by " + winner + ": $" + max + ".");
        
        String[] champions = new String[names.length];
        int numOfChampions = 0;
        double moneyOfChampions = 0;
        for (int i = 0; i < filledForms.length; i++) {
            if (raisedMoney[i] > 500.00) {
                champions[numOfChampions] = names[i];
                moneyOfChampions += raisedMoney[i];
                numOfChampions += 1;
            }
        }
        
        String and = " ";
        if (numOfChampions != 0) {
            System.out.print ("The full-ride baking scholarship is won thanks to");
            for (int i = 0; i < numOfChampions; i++) {
                if (champions[i] != null) {
                    System.out.printf ("%s%s", and, champions[i]);
                    if (i > 0 && i == numOfChampions - 2 || numOfChampions == 2) {
                        and = " and ";
                    } else {
                        and = ", ";
                    }
                }
            }
            System.out.printf (" who raised $%.2f and made your school one of premiere schools in the country!", moneyOfChampions);
        } else {
            System.out.println("Unfortunately, no one raised more than $500.");
        }
        
    } // end main
} // end class
