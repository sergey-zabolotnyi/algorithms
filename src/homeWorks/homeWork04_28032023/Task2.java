package homeWorks.homeWork04_28032023;

public class Task2 {
    // Даны два целых числа x и n, напишите функцию для вычисления x^n
    // решение 1 - рекурсивно O(n)
    // решение 2 - улучшить решение 1 до O(log n)
    public static void main(String[] args) {
        System.out.println(pow(2,3));           // 8
        System.out.println(powImproved(3,3));   // 27
        System.out.println(pow(5,2));           // 25
        System.out.println(powImproved(10,3));   // 1000

    }
    static int pow(int num, int p) {
        if (p == 0) {
            return 1; // условие выхода из рекурсии
        }
        return num * pow(num, p - 1);
    }
    static int powImproved(int num, int p) {
        if (p == 0) {
            return 1; // условие выхода из рекурсии
        } else if (p % 2 == 0) {
            int temp = powImproved(num, p / 2);
            return temp * temp;
        } else {
            int temp = powImproved(num, (p - 1) / 2);
            return num * temp * temp;
        }
    }
}
