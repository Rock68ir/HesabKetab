package Validition;

public class Validators{
    public static boolean ValidatorLetters(String s){
        boolean result = true;
        for (Character c: s.toCharArray()
             ) {
            if (!Character.isLetter(c) && !Character.isSpaceChar(c)){
                result = false;
                break;
            }
        }
        return result;
    }
    public static boolean ValidatorNumber(String s){
        boolean result = true;
        for (Character c: s.toCharArray()
        ) {
            if (!Character.isDigit(c)){
                result = false;
                break;
            }
        }
        return result;
    }
    private static boolean Validatorlength(String s , int length){
        return s.length() == length;
    }
    public static boolean ValidatorPhoneNumber(String s){
        boolean result = true;
        if (s.toCharArray()[0] != 0 || !Validatorlength(s , 11)){
            return false;
        }
        for (Character c: s.toCharArray()
        ) {
            if (!ValidatorNumber(s)){
                result = false;
                break;
            }
        }
        return result;
    }
    public static boolean ValidatorCode(String s){
        int sum = 0;
        char c;
        int controlCode = Character.getNumericValue(s.toCharArray()[9]);
        if (!Validatorlength(s , 10)){
            return false;
        }
        for (int i = 0 ; i < 9 ; i++){
            c = s.toCharArray()[i];
            sum += (10 - i) * Character.getNumericValue(c);
        }
        System.out.println(sum % 11);
        if (sum % 11 <= 2){
            System.out.println(sum%11);
            return sum % 11 == controlCode;
        }
        else {
            return (11 - (sum % 11)) == controlCode;
        }
    }
}
