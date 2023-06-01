package homeWorks.hw12_30052023;

import java.util.Arrays;

public class Dejkstra {
    private static final int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] graph = {
                {0, 4, 0, 0, 0},
                {4, 0, 8, 0, 0},
                {0, 8, 0, 7, 0},
                {0, 0, 7, 0, 9},
                {0, 0, 0, 9, 0}
        };
        int start = 0;

        dejkstra(graph, start);
    }

    public static void dejkstra (int[][] graph, int start) {
        boolean[] visited = new boolean[graph.length];
        int[] distances = new int[graph.length];

        Arrays.fill(distances, MAX);
        distances[start] = 0;

        for (int i = 0; i < graph.length - 1; i++) {
            int min = findMin(distances, visited);
            visited[min] = true;

            for (int j = 0; j < graph.length; j++) {
                if (graph[min][j] != 0 && !visited[j] && distances[min] != MAX) {
                    int newDistance = distances[min] + graph[min][j];
                    if (newDistance < distances[j]) {
                        distances[j] = newDistance;
                    }
                }
            }
        }

        System.out.println("Вершина\t Расстояние");
        for (int i = 0; i < distances.length; i++) {
            System.out.println(i + "\t\t" + distances[i]);
        }
    }

    private static int findMin(int[] distances, boolean[] visited) {
        int min = -1;
        for (int i = 0; i < distances.length; i++) {
            if (!visited[i] && (min == -1 || distances[i] < distances[min])) {
                min = i;
            }
        }
        return min;
    }
}
