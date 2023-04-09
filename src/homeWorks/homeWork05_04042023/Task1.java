package homeWorks.homeWork05_04042023;

public class Task1 {

    // Task 1. Сумма цифр числа. Дано натуральное число N. Вычислите сумму его цифр.
    //При решении этой задачи нельзя использовать строки, списки, массивы (ну и циклы, разумеется).
    public static void main(String[] args) {
        
        System.out.println(sumNumbers(3)); // ожидаемый резулътат 6
        System.out.println(sumNumbers(5)); // ожидаемый резулътат 15
        System.out.println(sumNumbers(10)); // ожидаемый резулътат 55
    }
    public static int sumNumbers(int n){
        if(n == 1){  // условие выхода из рекурсии
            return 1;
        }
        return n + sumNumbers(n-1); // рекурсия
    }
}
