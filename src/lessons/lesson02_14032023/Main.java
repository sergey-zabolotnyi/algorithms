package lessons.lesson02_14032023;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(linearSearch(array, 10));
        System.out.println(linearSearch(array, 5));
        System.out.println("------------------");
        System.out.println(binarySearch(array, 10));
        System.out.println(binarySearch(array, 5));
        System.out.println("-----------------");

        int[] arr = new int[1000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        System.out.println(linearSearch(arr,998));
        System.out.println(binarySearch(arr, 998));
        System.out.println("-----------------");
        System.out.println(factorial(5));
    }

    // Линейный поиск
    public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Бинарный(двоичный) поиск
    public static int binarySearch(int[] arr, int x) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == x)
                return mid;
            if (arr[mid] > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n-1);
        }
    }
}