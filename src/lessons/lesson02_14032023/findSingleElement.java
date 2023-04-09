package lessons.lesson02_14032023;

public class findSingleElement {
    public static void main(String[] args) {
        int x [] = {1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,};
        System.out.println(searchNumber(x));
        System.out.println(searchNumber1(x));

    }
    private static int searchNumber(int[] array){
        int size = array.length;
        if(array[size - 2] != array[size - 1]){
            return array[size - 1];
        }
        for (int i = 0; i < size; i+=2) {
            if (array[i] != array[i + 1]){
                return array[i];
            }
        }return -1;
    }
    private static int searchNumber1(int[] array){
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result = result ^ array[i];
        }
        return result;
    }
}
