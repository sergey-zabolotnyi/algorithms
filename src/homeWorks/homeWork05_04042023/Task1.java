package homeWorks.homeWork05_04042023;

public class Task1 {

    // Task 1. Сумма цифр числа. Дано натуральное число N. Вычислите сумму его цифр.
    //При решении этой задачи нельзя использовать строки, списки, массивы (ну и циклы, разумеется).
    public static void main(String[] args) {
        sumNumber(1234); // 10
        sumNumber(987); // 24
        System.out.println("--------");

        System.out.println("Сумма цифр числа равна: " + sumRefactor(1234)); // 10
        System.out.println("Сумма цифр числа равна: " + sumRefactor(987)); // 24

        System.out.println("-------------------");
        System.out.println(sumNumbers(3)); // ожидаемый резулътат 6
        System.out.println(sumNumbers(5)); // ожидаемый резулътат 15
        System.out.println(sumNumbers(10)); // ожидаемый резулътат 55
    }
    private static int sumRefactor(int n){
        if(n<10){
            return n;
        }
        return n % 10 + sumRefactor(n/10);
    }
    static void sumNumber(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit;
            n /= 10;
        }
        System.out.println("Сумма цифр числа равна: " + sum);
    }
    public static int sumNumbers(int n){
        if(n == 1){  // условие выхода из рекурсии
            return 1;
        }
        return n + sumNumbers(n-1); // рекурсия
    }

}
