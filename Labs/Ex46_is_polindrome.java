public class Main {

    public static void main(String[] args) {
        
        double num = 107.108;
        
        //System.out.println(isPolindrome(num));
        IntEqualsDouble(num);
    }
    
    static boolean isPolindrome(double num) {
        
        String str = String.valueOf(num);
        boolean IsPol = true;

        String strInt = "";
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == '.'){
                break;
            }
            strInt += str.charAt(i);
        }
        System.out.println(strInt);

        for (int i = 0; i < strInt.length() / 2; i++) {
            
            System.out.println(str.charAt(i) + " * " + str.charAt(strInt.length() - 1 - i));
            if (str.charAt(i) != str.charAt(strInt.length() - 1 - i)) {
                IsPol = false;
            }
        }
        return IsPol;
    }
    
    static void IntEqualsDouble (double num) {
        
        String str = String.valueOf(num);
            
        String str1 = ""; // Int-part
        String str2 = ""; // Double-part
        
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == '.') {
                break;
            }
            str1 += str.charAt(i);
        }

        for (int i = str.length() - 1; i > 0; i--) {
            if (str.charAt(i) == '.') {
                break;
            }
            str2 = str.charAt(i) + str2;
        }
        
        System.out.println(str1 + " + " + str2);
    }
}
