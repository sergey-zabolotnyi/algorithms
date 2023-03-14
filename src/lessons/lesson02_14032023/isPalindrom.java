package lessons.lesson02_14032023;

public class isPalindrom {
    public static void main(String[] args) {
        String s1 = "asddsa";
        String s2 = "qwertyrewq";
        int a = 123;

        System.out.println(isPalindrome(s1));
        System.out.println(isPalindrome(s2));
        System.out.println(isPalindrome(String.valueOf(a)));
        System.out.println(isPalindrome(String.valueOf(12321)));
        System.out.println("===============");
        System.out.println(isPalindrome2(s1));
        System.out.println(isPalindrome2(s2));
        System.out.println(isPalindrome2(String.valueOf(a)));
        System.out.println(isPalindrome2(String.valueOf(12321)));
        System.out.println("===============");
        System.out.println(isPalindrome3(a));
        System.out.println(isPalindrome3(123321));
        System.out.println("===============");
        System.out.println(isPalindrome4(a));
        System.out.println(isPalindrome4(12321));
    }
    private static boolean isPalindrome (String s){
        String s2 = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            s2 = s2 + s.charAt(i);
        }
        return (s.equals(s2));
    }
    private static boolean isPalindrome2 (String s){
        int size = s.length();
        for (int i = 0; i < size/2; i++) {
            if (s.charAt(i) != s.charAt(size - i - 1)){
                return false;
            }
        } return true;
    }
    private static boolean isPalindrome3 (int x){
        if (x < 0 || (x != 0 && x % 10 == 0)){
            return false;
        }
        int result = 0;
        while (x > result){
            result = 10 * result + x % 10;
            x /=10;
        }
        return  x == result || x == result / 10;
    }
    public static boolean isPalindrome4 (int x) {
        int origin = x;
        int reversed = 0;
        while (x != 0) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x /= 10;
        }
        return reversed == origin;
    }
}
