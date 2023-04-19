package homeWorks.homeWork06_18042023;

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        int[] myArray = {2,4,6,9,12,-3,0,24,10,15,9,1,3,-5};
        quickSort(myArray, 0, myArray.length-1);
        System.out.println(Arrays.toString(myArray));
    }
    public static void quickSort(int[] myArray, int less, int greater) {
        int i = less, j = greater;
        // выбираем средний элемент
        int pivot = myArray[(less + greater) / 2];
        while (i <= j) {
            while (myArray[i] < pivot) {
                i++;
            }
            while (myArray[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = myArray[i];
                myArray[i] = myArray[j];
                myArray[j] = temp;
                i++;
                j--;
            }
        }
        if (less < j) {
            quickSort(myArray, less, j);
        }
        if (i < greater) {
            quickSort(myArray, i, greater);
        }
    }
}
