package lessons.lesson12_30052023;

import java.util.*;
public class Main {

    public static void main(String[] args) {
        // Множество рассматриваемых штатов, которые необходимо покрыть
        Set<String> statesNeeded = new HashSet<>(List.of("MT", "WA", "OR", "ID", "NV", "UT", "CA", "AZ"));
        // Станции и покрываемые ими штаты
        Map<Integer, Set<String>> stations = new HashMap<>();
        stations.put(1, new HashSet<>(List.of("ID", "NV", "UT")));
        stations.put(2, new HashSet<>(List.of("WA", "ID", "MT")));
        stations.put(3, new HashSet<>(List.of("OR", "NV", "CA")));
        stations.put(4, new HashSet<>(List.of("NV", "UT")));
        stations.put(5, new HashSet<>(List.of("CA", "AZ")));
        // Ответ - итоговый набор станций
        Set<Integer> finalStations = new HashSet<>();

        while (!statesNeeded.isEmpty()) {
            Set<String> statesCovered = new HashSet<>();    // Текущее покрытие штатов
            int bestStation = 0;    // Станция, которая покрывает больше всего штатов, не входящих в statesCovered

            Set<String> statesBestCovered = new HashSet<>();

            for (Map.Entry<Integer, Set<String>> entry : stations.entrySet()) {
                int station = entry.getKey();
                Set<String> covered = new HashSet<>(statesNeeded);
                covered.retainAll(entry.getValue()); // Пересечение множеств

                if (covered.size() > statesBestCovered.size()) {
                    bestStation = station;
                    statesBestCovered = covered;
                }
            }

            statesNeeded.removeAll(statesBestCovered);
            statesCovered.addAll(statesBestCovered);
            finalStations.add(bestStation);
        }

        System.out.println("Итоговый набор станций: " + finalStations);
    }
}
