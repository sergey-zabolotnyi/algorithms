package lessons.lesson06_18042023;

import java.util.Arrays;

public class ArrayDemo {
    public static void main(String[] args) {
        int [] arr = {1, 4, 5, 2, 6, 3, 4};
        int k = 9;
        int[] result = sumK(arr,k);
        System.out.println(Arrays.toString(result));
    }
    private static int[] sumK(int[] array, int k){
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                for (int l = j+1; l < array.length; l++) {
                    if(array[i] + array[j] + array[l] == k) {
                        return new int[]{array[i], array[j], array[l]};
                    }
                }
            }
        }
        return new int[0];
    }
}
