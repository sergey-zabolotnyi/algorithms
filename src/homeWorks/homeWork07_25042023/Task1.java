package homeWorks.homeWork07_25042023;

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {

        // Дано число, записанное своими разрядами в массиве, например,
        // число 546 будет представлено массивом [5, 4, 6].
        // Прибавить к этому "числу" 1.

        int[] array1 = {1,2,3};
        int[] array2 = {4,3,2,1};
        int[] array3 = {9};
        int[] array4 = new int[]{9,9,9,9};
        System.out.println(Arrays.toString(convertArr(array1))); // Output: [1,2,4]
        System.out.println(Arrays.toString(convertArr(array2))); // Output: [4,3,2,2]
        System.out.println(Arrays.toString(convertArr(array3))); // Output: [1,0]
        System.out.println(Arrays.toString(convertArr(array4))); // Output: [1,0,0,0,0]
        
    }
    public static int[] convertArr(int[] arr) {
        int num = 0;
        // 1. Переводим массив в число
        for (int i = 0; i < arr.length; i++) {
            num = num * 10 + arr[i];
            //System.out.println(num);
        }
        // 2. Увеличиваем на 1
        num += 1;
        // 3.Узнаем количество элементов нового массива
        int length = String.valueOf(Math.abs(num)).length();
        // 4. Создаем новый массив
        int[] arr1 = new int[length];
        // 5. Заполняем элементами
        for (int i = length - 1; i >= 0; i--) {
            arr1[i] = num % 10;
            num /= 10;
            //System.out.println(arr1[i]);
        }
        return arr1;
    }

}
