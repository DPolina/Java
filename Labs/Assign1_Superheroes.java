
public class Main {
    
    public static void main(String[] args) {
        Superheroes();
        Students();
    } // end main
    
    public static void printSuperheroes (String[] superheroes, String[] superpower, boolean[] isHuman) {
        System.out.println("");
        System.out.printf("%-3s%-18s%-25s%-25s", "#)", "Superheroes", "Superpowers", "Are they human?");
        System.out.println("");

        for (int i = 0; i < superheroes.length; i++) {
            String human = Boolean.toString(isHuman[i]);
            System.out.printf("%d) %-18s%-25s%-23s", i + 1, superheroes[i], superpower[i], human);
            System.out.println("");
        }
        
        System.out.println("");
    }
    
    public static void Superheroes() {
        
        String[] superheroes = {
            "Spider-Man", 
            "Iron Man", 
            "Superman", 
            "Green Arrow", 
            "Daredevil", 
            "Wonder Woman"
        };
        String[] superpower = {
            "Spider web", 
            "Armoured battlesuit", 
            "Speed", "Sharpshooting", 
            "Perfect hearing", 
            "Strength"
        };
        boolean[] isHuman = {
            false, 
            true, 
            false, 
            true, 
            true, 
            false   
        };
        
        //
        System.out.print(superheroes[0] + ", ");
        System.out.println(superheroes[superheroes.length - 1]);
        
        for (int counter = 0; counter < superheroes.length; counter++) {
            if (counter == superheroes.length - 1) {
                System.out.print(superheroes[counter] + ".");
            } else {
                System.out.print(superheroes[counter] + ", ");
            }
        }
        
        System.out.println("");
        
        printSuperheroes(superheroes, superpower, isHuman);
        
        //
        System.out.println("The heroes have all been exposed to gritty-realism. Non-humans loose their powers.");
        for (int i = 0; i < isHuman.length; i++) {
            if (isHuman[i] == false) {
                superpower[i] = "none";
            }
        }
        
        printSuperheroes(superheroes, superpower, isHuman);
        
    } // end superheroes
    
    public static void Students() {
        ///
        String[][] coursesAndStudents = {
            { "Bobert", "Jaynifer", "Boulder" },
            { "Boberta", "Jaynifo", "Rocky" },
            { "Bobertium", "Jaynifa", "Gravela" },
            { "Boberto", "Jayniferous", "Minerelle"}
        };
        String[] courses = {
            "Computer Science 10",
            "Computer Science 20",
            "Computer Science 30",
            "Computer Science 30-1"
        };
        
        for (int courseIdx = 0; courseIdx < coursesAndStudents.length; courseIdx++) {
            System.out.printf("%-25s ", courses[courseIdx] + ":");
            for (int studentIdx = 0; studentIdx < coursesAndStudents[courseIdx].length; studentIdx++) {
                System.out.printf("%-15s ", coursesAndStudents[courseIdx][studentIdx]);
            }    
            System.out.println("");
        }
    } // end students
} // end class
