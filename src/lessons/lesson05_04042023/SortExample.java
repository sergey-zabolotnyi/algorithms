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
        mergeSort(array2);
        System.out.println(Arrays.toString(array2));

    }
    private static void mergeSort(int[] array) {
        mergeSortRecursive(array, array.length);
    }
    private static void mergeSortRecursive(int[] array, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        // Два подмассива
        int[] l = new int[mid];
        int[] r = new int[n - mid];
        // Копируем в подмассивы элементы из исходного массива
        for (int i = 0; i < mid; i++) {
            l[i] = array[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = array[i];
        }
        mergeSortRecursive(l, mid);
        mergeSortRecursive(r, n - mid);

        // Объединяем отсортированные l и r массивы в один
        merge(array, l, r, mid, n - mid);
    }
    /**
     * Объединение двух отсортированных подмассивов в один массив
     * @param array исходный массив (в него объединяем l и r)
     * @param l левый подмассив
     * @param r правый подмассив
     * @param left длина левого подмассива  
     * @param right длина правого подмассива
     */
    private static void merge(int[] array, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] < r[j]) {
                array[k++] = l[i++];
            } else {
                array[k++] = r[j++];
            }
        }
        // Возможно в одном из подмассивов остался "хвост"
        while (i < left) {
            array[k++] = l[i++];
        }
        while (j < right) {
            array[k++] = r[j++];
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
