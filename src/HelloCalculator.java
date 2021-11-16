import java.util.Scanner;
import java.util.InputMismatchException;
public class HelloCalculator {
    public static void main(String[] args) throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] str = s.split(" ");

        if (str.length != 3) {
            try {
                throw new InputMismatchException();
            } catch (InputMismatchException e) {
                System.out.println("Введены некорректные данные");
            }
            return;
        }
        String strA = str[0];
        String str1 = str[1];
        String strB = str[2];
        int result = 0;
        char operator = str1.charAt(0);



        int a = RomToArab(strA);
        int b = RomToArab(strB);

        if (a!=0 && b!=0) {
            result = calc(a, b, operator);
            if (result > 0) {
                String resultRoman = ArabToRoman(result);
                System.out.println(resultRoman);
            }
            else System.out.println("Введены некорректные данные");
        }


        int a1 = Integer.parseInt(strA);
        int b1 = Integer.parseInt(strB);
        if (a1 > 0 && a1 < 11 && b1 > 0 && b1 < 11) {
            result = calc(a1, b1, operator);
            System.out.println(result);
        } else {
            try {
                throw new InputMismatchException();
            } catch (InputMismatchException e) {
                System.out.println("Введены некорректные данные");
            }
            return;
        }
    }

    private static String ArabToRoman(int numArab) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        final String s = roman[numArab];
        return s;
    }


    private static int RomToArab(String roman) throws InputMismatchException {
        try {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Введены некорректные данные");
        }
        return 0;
    }


    public static int calc(int a, int b, char operator) {
        int result = 0;
        switch (operator) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                try {
                    result = a / b;
                } catch (ArithmeticException | InputMismatchException e) {
                    break;
                }
                break;
            default:
                try {
                    throw new InputMismatchException();
                }
                catch (InputMismatchException e){
                    System.out.println("Введены некорректные данные");
                }
        }
        return result;
    }
}
