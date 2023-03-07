package homeWorks.homework01_07_03_2023;

public class findSingleElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 8, 9}; // пример массива

        int[] counts = new int[10]; // массив для подсчета количества вхождений цифр
        for (int i = 0; i < arr.length; i++) {
            counts[arr[i]]++; // увеличиваем счетчик для текущей цифры
        }
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == 1) { // нашли искомый элемент
                System.out.println(i);
                break;
            }
        }
    }
}
