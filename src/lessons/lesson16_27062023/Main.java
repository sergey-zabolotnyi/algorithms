package lessons.lesson16_27062023;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,55,2,10,-1, 2,13,1,0,3,46};
        int k = 1;
        System.out.println(maxSumNaiveApproach(arr,k));
        int x = 102;
        sum3Elements(arr,x);
        System.out.println(Arrays.toString(bubbleSort(arr)));
    }

    private static int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    private static void sum3Elements(int[] arr, int x) {
        for (int i = 0; i < arr.length-2; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                for (int k = 0; k < arr.length; k++) {
                    if (arr[i]+arr[j]+arr[k] ==x){
                        System.out.println("Summ of "+ x + " = " + arr[i] + "," + arr[j]+ "," + arr[k]);
                        return;
                    }
                }
            }
        }
        System.out.println("Triplets not found.");
    }

    private static int maxSumNaiveApproach(int[] arr, int k) {
        int max = 0;
        for (int i = 0; i < arr.length - k + 1; i++) {
            int current = 0;
            for (int j = 0; j < k; j++) {
                current = current + arr[i+j];
            }
            max = Math.max(current,max);
        }
        return max;
    }

    
}
