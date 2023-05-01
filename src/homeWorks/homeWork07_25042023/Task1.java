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
        System.out.println("---------");

        // мы начали изучать на Java stream API, решил упростить код стримами
        System.out.println(Arrays.toString(convertWithStream(array1))); // Output: [1,2,4]
        System.out.println(Arrays.toString(convertWithStream(array2))); // Output: [4,3,2,2]
        System.out.println(Arrays.toString(convertWithStream(array3))); // Output: [1,0]
        System.out.println(Arrays.toString(convertWithStream(array4))); // Output: [1,0,0,0,0]
        
    }
    public static int[] convertArr(int[] arr) {
        int number = 0;
        // 1. Переводим массив в число
        for (int i = 0; i < arr.length; i++) {
            number = number * 10 + arr[i];
            //System.out.println(num);
        }
        // 2. Увеличиваем число на 1
        number += 1;
        // 3.Узнаем количество элементов нового массива
        int temp = number;
        int length = 0;
        while (temp != 0){
            length++;
            temp = temp / 10;
        } // System.out.println(length);

        // 4. Создаем новый массив
        int[] arr1 = new int[length];
        // 5. Заполняем элементами
        for (int i = length - 1; i >= 0; i--) {
            arr1[i] = number % 10;
            number /= 10;
            //System.out.println(arr1[i]);
        }
        return arr1;
    }
    // делаем то же самое но с помощью stream
    public static int[] convertWithStream(int[]arr){
        // 1. Переводим массив в число
       int number = Arrays.stream(arr)
               .reduce(0,(sum,n)->sum=sum*10+n);
        // 2. Увеличиваем число на 1
       number+=1;
        // 3. Создаем новый массив и заполняем элементами
       return Integer.toString(number)
               .chars()
               .map(Character::getNumericValue)
               .toArray();
    }

}
