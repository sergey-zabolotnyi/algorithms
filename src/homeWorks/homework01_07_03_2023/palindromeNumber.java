package homeWorks.homework01_07_03_2023;

public class palindromeNumber {
    public static boolean isPalindrome(int x) {
        // преобразуем число в строку для проверки символов
        String numberToString = Integer.toString(x);
        // итерируемся по символам числа от начала до середины
        for (int i = 0; i < numberToString.length() / 2; i++) {
            // сравниваем i-ый символ с последним символом
            if (numberToString.charAt(i) != numberToString.charAt(numberToString.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(121)); // true
        System.out.println(isPalindrome(123)); // false
        System.out.println(isPalindrome(1001)); // true
        System.out.println(isPalindrome(1101)); // false
        System.out.println(isPalindrome(9876789)); // true
    }
}
