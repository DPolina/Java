
public class Main {
    
    public static int generateNum(int limit, int offset) {
        return (int) (Math.random()*limit + offset);
    }

    public static void main(String[] args) {
         
        String[] names = {
            "Bobert",
            "Boberta",
            "Boberto",
            "Bobertio",
            "Bobertus",
            "Bobertum"
        };
        
        int gradesCounter = 6;
         
        int[] gradesExam1 = new int[gradesCounter];
        int[] gradesExam2 = new int[gradesCounter];
        int[] gradesExam3 = new int[gradesCounter];
        double[] average = new double[gradesCounter];
        int[] grade = new int[gradesCounter];
        
        System.out.printf("#)%6s%14s%10s%10s%10s", "Name", "Grade", "Exam 1", "Exam 2", "Exam 3");
        System.out.println("");
        for (int gradeIdx = 0; gradeIdx < gradesCounter; gradeIdx++) {
            grade[gradeIdx] = generateNum(2, 10);
            gradesExam1[gradeIdx] = generateNum(100, 1);
            gradesExam2[gradeIdx] = generateNum(100, 1);
            gradesExam3[gradeIdx] = generateNum(100, 1);
            double sum = gradesExam1[gradeIdx] + gradesExam2[gradeIdx] + gradesExam3[gradeIdx];
            average[gradeIdx] = sum / 3;
            // System.out.println("Exam 1: " + gadesExam1[gradeIdx]);
            System.out.printf("%d) %-10s%7d%10d%10d%10d", gradeIdx + 1, names[gradeIdx], grade[gradeIdx], gradesExam1[gradeIdx], gradesExam2[gradeIdx], gradesExam3[gradeIdx]);
            System.out.println("");
        }
        
    /*****************Next 20%*****************/

        System.out.println("");
        for (int i = 0; i < names.length; i++) {
            if (i == names.length - 1) {
                System.out.printf("The average of %s is %.0f.", names[i], average[i]);
            } else {
                System.out.printf("The average of %s is %.0f,", names[i], average[i]);
                System.out.println("");
            }
        }
        
    /*****************Final 20%*****************/
    
        System.out.println("");
        System.out.println("");
        int counter = 0;
        for (int i = 0; i < names.length; i++) {
            if (gradesExam3[i] > 79) {
                counter += 1;
                System.out.printf("%s got %d on %s.", names[i], gradesExam3[i], "Exam 3");
                System.out.println("");
            }
        }
        if (counter == 0) {
            System.out.println("No one got higher than 79 on Exam 3.");
        }
        
        System.out.println("");
        System.out.printf("#)%6s%14s%10s%10s%10s%10s", "Name", "Grade", "Exam 1", "Exam 2", "Exam 3", "Average");
        System.out.println("");
        for (int gradeIdx = 0; gradeIdx < gradesCounter; gradeIdx++) {
            gradesExam3[gradeIdx] = generateNum(100, 1);
            if (gradesExam1[gradeIdx] < 50) {
                gradesExam1[gradeIdx] = 40;
            }
            double sum = gradesExam1[gradeIdx] + gradesExam2[gradeIdx] + gradesExam3[gradeIdx];
            average[gradeIdx] = sum / 3;
            // System.out.println("Exam 1: " + gadesExam1[gradeIdx]);
            System.out.printf("%d) %-10s%7d%10d%10d%10d%10.0f", gradeIdx + 1, names[gradeIdx], grade[gradeIdx], gradesExam1[gradeIdx], gradesExam2[gradeIdx], gradesExam3[gradeIdx], average[gradeIdx]);
            System.out.println("");
        }
        
    } // end main
    
} // end class
