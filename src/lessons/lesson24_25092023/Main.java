package lessons.lesson24_25092023;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        int[] array = {5, 4, 3, 2, 6, 1};
        System.out.println(Arrays.toString(bubbleSort(array)));

        System.out.println(sum(100));
        System.out.println(sumIter(100));
        System.out.println(fibonacci(10));

    }

    public static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-i-1; j++) {
                if (array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }
    public static int sum(int n) {
        if (n <= 0) throw new Error("The number should be positive");
        if (n == 1) return 1;
        return sum(n - 1) + n;
    }
    public static int sumIter(int n) {
        int result = 0;
        if (n <= 0) throw new Error("The number should be positive");
        for (int i = 1; i <= n; i++) {
            result += i;
        }
        return result;
    }
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
