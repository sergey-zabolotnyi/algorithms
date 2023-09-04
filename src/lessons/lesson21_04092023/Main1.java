package lessons.lesson21_04092023;

public class Main1 {
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 1, 3};
        System.out.println("Повторяющееся: " + findDuplicate(arr));
    }

    public static int findDuplicate(int[] arr) {
        boolean[] booleans = new boolean[arr.length-1];
        for (int i = 0; i < arr.length; i++) {
            if (booleans[arr[i] - 1]) return arr[i];
            else booleans[arr[i] - 1] = true;
        }
        return -1;
    }
}
