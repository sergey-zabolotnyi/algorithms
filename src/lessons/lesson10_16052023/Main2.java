package lessons.lesson10_16052023;

public class Main2 {

    public static void main(String[] args) {
        int n = 4; // количество кувшинок (n > 2)
        int[] array = new int[n];
        array[0] = array[1] = 1;
        for (int i = 2; i < n; i++) {
            array[i] = array[i - 2] + array[i - 1];
        }
        System.out.println(array[n - 1]);
    }

}
