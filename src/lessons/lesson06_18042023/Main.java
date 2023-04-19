package lessons.lesson06_18042023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //printNaturalNumber(1,10);

        List<Integer> list = qSort(List.of(12, 10, 7, 2, 0, 6, 24, 5, 20, 15, 45, 1));
        System.out.println(list);

    }

    private static List<Integer> qSort(List<Integer> array) {
        // Базовый случай
        if (array.size() < 2){
            return array;
        }
        // Опорный элемент
        int pivot = array.get(0);
        // Массив элементов, меньших pivot
        List<Integer> less = new ArrayList<>();
        // Массив элементов, больших или равных pivot
        List<Integer> greater = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            if(array.get(i) < pivot){
                less.add(array.get(i));
            } else {
                greater.add(array.get(i));
            }
        }
        List<Integer> result = new ArrayList<>();
        result.addAll(qSort(less));
        result.addAll(qSort(greater));
        return result;
    }

    private static void printNaturalNumber(int lower, int n){
        if(lower <= n) {
            printNumber(lower);
            lower += 1;
            helperFunction(lower, n);
        }
    }
    private static void helperFunction(int lower, int n){
        if(lower <= n){
            printNumber(lower);
            lower += 1;
            printNaturalNumber(lower, n);
        }
    }
    private static void printNumber(int lower) {
        System.out.print(lower+" ");
    }
}
