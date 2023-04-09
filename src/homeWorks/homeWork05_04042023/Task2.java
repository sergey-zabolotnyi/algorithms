package homeWorks.homeWork05_04042023;

public class Task2 {
    // Цифры числа справа налево. Дано натуральное число N. Выведите все его цифры по одной, в обратном порядке,
    // разделяя их пробелами или новыми строками. При решении этой задачи нельзя использовать строки, списки,
    // массивы (ну и циклы, разумеется). Разрешена только рекурсия и целочисленная арифметика.
    public static void main(String[] args) {

        reverseNum(25);
        System.out.println("---------------");

        reverseNum(12345);
        System.out.println("---------------");

        reverseNum(987654321);
    }

    public static void reverseNum (int n){
        if(n < 10){
            System.out.println(n);
        } else{
            System.out.print(n % 10 + ", ");
            reverseNum (n / 10);
        }
    }
}
