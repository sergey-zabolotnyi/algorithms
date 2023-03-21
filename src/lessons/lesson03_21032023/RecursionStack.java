package lessons.lesson03_21032023;

public class RecursionStack {
    public static void main(String[] args) {
        System.out.println("Факториал числа 6 = " + factorialIter(6));
        System.out.println("-------------------");
        System.out.println("Факториал числа 7 = " + factorialRecursive(7));
        System.out.println("-------------------");
        System.out.println(printNumbers(3));
        System.out.println("-------------------");

        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, -10};
        System.out.println("Сумма элементов массива = " + sumArray(numbers, numbers.length-1));
        System.out.println("-------------------");
        System.out.println("Минимальный элемент массива = " + minElemArr(numbers, numbers.length-1));
        System.out.println("-------------------");
        System.out.println("Минимальный элемент массива = " + minArrayElement(numbers, numbers.length-1));
        System.out.println("-------------------");
        System.out.println("Алгоритм Евклида = " + gcd(28,20));
        System.out.println("-------------------");
        System.out.println("Фибоначчи чисел = " + getFibonacci(6));

    }
    // Фибоначчи рекурсией
    private static int getFibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return getFibonacci(n-1) + getFibonacci(n-2);
        }
    }
    // Алгоритм Евклида рекурсией
    private static int gcd(int n, int m){
        if(n == m){
            return n;
        }
        if (n>m){
            return gcd(n-m, m);
        } else {
            return gcd(m, m-n);
        }
    }
    // рекурсия мин елемент массива, другой способ
    private static int minArrayElement(int[] array, int i){
        if (i < array.length){
            int next = minArrayElement(array, i+1);
            return Math.min(array[i], next);
        } else {
            return array[0];
        }
    }
    // рекурсия мин елемент массива
    private static int minElemArr(int[] array, int i){
        if(i == 0){
            return array[i];
        }
        int min = minElemArr(array, i-1);
        return Math.min(min, array[i]);
    }
    private static int sumArray (int[] array, int i){
        if(i == 0){
            return array[0];
        }
        return sumArray(array, i - 1) + array[i];
    }

    // обычный факториал
    private static int factorialIter(int n){
        int p = 1;
        for (int i = 2; i <= n; i++) {
            p = p * i;
        }
        return p;
    }
    // рекурсивный факториал
    public static int factorialRecursive(int n) {
       if (n == 1){
           return 1;
       }else {
           return factorialRecursive(n-1) * n;
       }
    }
    // рекурсия вывод от n до 0
    public static int printNumbers(int n) {
        System.out.println(n);
        if (n == 1) {
            return 0;
        } else {
            return printNumbers(n - 1);
        }
    }
}
