package homeWorks.homeWork03_21032023;

import java.util.Scanner;

// Имеется три стержня — левый (1), средний (2) и правый (3).
// На левом стержне находятся n дисков, диаметры которых различны.
// Диски упорядочены по размеру диаметра, сверху лежит наименьший, снизу — наибольший.
// Требуется перенести диски с левого стержня на правый, используя средний стержень как вспомогательный.
// Головоломка имеет следующие два правила:
// 1. Вы не можете поместить больший диск на меньший диск.
// 2. За один раз можно перемещать только один диск.

// Итеративно!

// Не совсем понял, что значит интерактивно... Сканнер?
// с помощью циклов и условных операторов у меня не получается решить задачу (только рекурсия)

public class ThreeTowersInteractive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество дисков: ");
        int n = scanner.nextInt();
        threeTowersInteractive(n, 'A', 'C', 'B');
        scanner.close();
    }

    public static void threeTowersInteractive(int n, char from, char to, char helper) {
        if (n == 1) {
            System.out.println("Перемещаем диск 1 с " + from + " на " + to);
            return;
        }
        threeTowersInteractive(n - 1, from, helper, to);
        System.out.println("Перемещаем диск " + n + " с " + from + " на " + to);
        threeTowersInteractive(n - 1, helper, to, from);
    }
}