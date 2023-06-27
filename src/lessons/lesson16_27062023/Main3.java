package lessons.lesson16_27062023;

public class Main3 {

    public static void main(String[] args) {
        // "Скользящее окно"
        // Дан массив целых чисел размера «n», наша цель — вычислить
        // максимальную сумму «k» последовательных элементов в массиве.
        // Ввод: arr[] = {10, 20, 30, 40}, k = 2
        // Вывод: 70

        // Вход: arr[] = {1, 45, 2, 10, 23, 3, 1, 0, 20}, k = 4
        // Выход: 80

        int[] arr = {1, 55, 2, 10, 2, 13, 1, 0, 3};
        int k = 3;
        System.out.println(maxSumNaiveApproach(arr, k));
        System.out.println(maxSumSlidingWindow(arr, k));

        // Дан отсортированный массив arr (отсортированный в порядке
        // возрастания), содержащий N целых чисел, найти, существует ли
        // какая-либо пара элементов (arr[i], arr[j]), сумма которых равна X.
        int[] arr2 = {10, 20, 35, 50, 75, 80};
        findPairSumTwoPointer(arr2, 71);
    }

    // O(n * k)
    private static int maxSumNaiveApproach(int[]arr, int k) {
        int max = 0;
        for (int i = 0; i < arr.length - k + 1; i++) {
            int current = 0;
            for (int j = 0; j < k; j++) {
                current = current + arr[i + j];
            }
            max = Math.max(current, max);
        }
        return max;
    }

    // O(n)
    private static int maxSumSlidingWindow(int[]arr, int k) {
        int max = 0;
        for (int i = 0; i < k; i++) {
            max += arr[i];
        }
        int windowSum = max;
        for (int i = k; i < arr.length; i++) {
            windowSum += arr[i] - arr[i - k];
            max = Math.max(max, windowSum);
        }
        return max;
    }

    private static void findPairSumTwoPointer(int[] arr, int sum) {
        int i = 0;  // первый указатель
        int j = arr.length - 1; // второй указатель
        while (i < j) {
            if (arr[i] + arr[j] == sum) {
                System.out.println("yes");
                return;
            } else if (arr[i] + arr[j] < sum) {
                i++;
            } else {
                j--;
            }
        }
        System.out.println("no");
    }

}
