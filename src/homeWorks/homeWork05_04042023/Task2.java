package homeWorks.homeWork05_04042023;

public class Task2 {

    // Дано натуральное число N. Выведите все его цифры по одной, а также в обратном порядке,
    // разделяя их пробелами или новыми строками. При решении этой задачи нельзя использовать строки, списки,
    // массивы (ну и циклы, разумеется). Разрешена только рекурсия и целочисленная арифметика.

    public static void main(String[] args) {
        System.out.println(splitNum(345));
        System.out.println(splitNum(987654321));
        System.out.println("-----------");

        System.out.println(reverseNum(345));
        System.out.println(reverseNum(987654321));
    }

    private static String splitNum(int n){
        if(n < 10) {
            return Integer.toString(n);
        }
        return splitNum(n / 10) + ", " + n % 10;
    }
    
    private static int reverseNum (int n){
        if(n < 10){
            return n;
        } else {
            System.out.print(n % 10 + ", ");
            return reverseNum (n / 10);
        }
    }
}
