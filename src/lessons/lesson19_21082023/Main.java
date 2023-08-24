package lessons.lesson19_21082023;

public class Main {
    public static void main(String[] args) {
        int[] array = {25, 10, 5, 1};
        int number = 63;
        if (greedy(array, number) == -1) System.out.println("We couldn't construct the combination we wanted");
        else
            System.out.println(greedy(array, number));
    }

    public static int greedy(int[] array, int num) {
        int index = 0;
        int count = 0;
        while (num > 0 && index < array.length) {
            if (array[index] <= num) {
                num = num - array[index];
                count++;
            } else index++;

        }

        return num == 0 ? count : -1;
    }

}
