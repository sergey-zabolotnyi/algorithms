package homeWorks.homework01_07_03_2023;

public class findSingleElement {
    public static void main(String[] args) {
        int[] newArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5, 6, 7, 9}; // пример массива (8 в одном экземпляре)

        int uniqueNum = findSingleElement(newArr);
        System.out.println("В массиве только данный элемент: " + uniqueNum + " в 1 эксемпляре"); // ищем 8

    }
    public static int findSingleElement(int[] arr) {
        int result = 0;
        for (int num : arr) {
            result ^= num;
        }
        return result;
    }
}
