package lessons.lesson19_21082023;

import java.util.*;

public class GreedyMap {

    public static void main(String[] args) {
        int[] array = {1, 5, 10, 25};
        int number = 63;

        Map<Integer, Integer> coinCountMap = greedy(array, number);

        System.out.println("Минимальное количество монет, чтобы получилось " + number + ":");
        for (Map.Entry<Integer, Integer> entry : coinCountMap.entrySet()) {
            System.out.println(entry.getKey() + " центов: " + entry.getValue() + " монет");
        }
    }
    public static Map<Integer, Integer> greedy(int[] array, int number) {
        Arrays.sort(array); // Сортируем монеты по возрастанию
        Map<Integer, Integer> coinCountMap = new TreeMap<>(Collections.reverseOrder()); // Мапа для хранения количества монет

        int remainingSum = number;

        for (int i = array.length - 1; i >= 0; i--) {
            int coinValue = array[i];
            int coinCount = remainingSum / coinValue; // Количество монет данного номинала

            if (coinCount > 0) {
                coinCountMap.put(coinValue, coinCount);
                remainingSum -= coinCount * coinValue;
            }

            if (remainingSum == 0) {
                break;
            }
        }
        return coinCountMap;
    }
}
