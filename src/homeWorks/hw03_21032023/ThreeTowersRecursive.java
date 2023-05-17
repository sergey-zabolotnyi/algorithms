package homeWorks.hw03_21032023;


public class ThreeTowersRecursive {
    // Имеется три стержня — левый (1), средний (2) и правый (3).
// На левом стержне находятся n дисков, диаметры которых различны.
// Диски упорядочены по размеру диаметра, сверху лежит наименьший, снизу — наибольший.
// Требуется перенести диски с левого стержня на правый, используя средний стержень как вспомогательный.
// Головоломка имеет следующие два правила:
// 1. Вы не можете поместить больший диск на меньший диск.
// 2. За один раз можно перемещать только один диск.

// Рекурсивно

    public static void main(String[] args) {

        threeTowersRecursive(3,'A','C','B');
    }
        static void threeTowersRecursive (int n, char from, char to, char helper) {
            if (n == 1) {
                System.out.println("Берем диск 1 со стержня " +  from + " и ложим на стержень " + to);
                return;
            }
            threeTowersRecursive(n-1, from, helper, to);
            System.out.println("Берем диск " + n + " со стержня " +  from + " ложим на стержень " + to);
            threeTowersRecursive(n-1, helper, to, from);
        }

}
