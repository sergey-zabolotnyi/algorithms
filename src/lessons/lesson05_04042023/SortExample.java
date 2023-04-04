package lessons.lesson05_04042023;

import java.util.Arrays;

public class SortExample {
    public static void main(String[] args) {
       int[] array = {20,30,50,10,40,100,80,90,60,70};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
        System.out.println("--------------------------");
        int[] array1 = {20,30,50,10,40,100,80,90,60,70};
        selectSort(array1);
        System.out.println(Arrays.toString(array1));
        System.out.println("--------------------------");
        int[] array2 = {12,1,23,41,6,73,0,2,54,9,7,8,3,5};

    }
    private static void mergeSort(int[] array){
        mergeSortRecursive(array, array.length);

    }
    private static void mergeSortRecursive(int[] array, int n){
        if(n<2){
            return;
        }
        int mid = n/2;
        // создаем два подмассива
        int[] left = new int[mid];
        int[] right = new int[n-mid];
        // копируем в подмассивы элементы
        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }
        for (int i = mid; i < n; i++) {
            right[i-mid] = array[i];
        }
        mergeSortRecursive(left, mid);
        mergeSortRecursive(right, n - mid);

        merge(array, left, right, mid, n-mid);
    }

    private static void merge(int[] array, int[] left, int[] right, int l, int r) {
        int i = 0, j = 0, k = 0;
        if (i<l && j <r){
            array[k++] = left[i++];
        }else {
            array[k] = right[j];

        }

    }

    private static void bubbleSort(int[] array){
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i+1; j < array.length; j++) {
                if(array[i] > array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
    private static void selectSort(int[] array){
        for (int i = 0; i < array.length - 1; i++) {
            int nMin = i;
            for (int j = i+1; j < array.length; j++) {
                if(array[j] < array[nMin]){
                    nMin = j;
                }
            }
            int temp = array[i];
            array[i] = array[nMin];
            array[nMin] = temp;
        }
    }
}
