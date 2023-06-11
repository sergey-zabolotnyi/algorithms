package lessons.lesson13_06062023;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[][] graph = {{0,7,9,0,0,14},
                         {7,0,10,16,0,0},
                         {9,10,0,11,0,2},
                         {0,16,11,0,6,0},
                         {0,0,0,6,0,9},
                         {14,0,2,0,9,0}
        };
        Vertex v1 = new Vertex(1);
        v1.setValue(0);
        List<Vertex> vertices = List.of(v1,
                new Vertex(2),
                new Vertex(3),
                new Vertex(4),
                new Vertex(5),
                new Vertex(6));
        List<Vertex> passedVertices = new ArrayList<>();
        while (passedVertices.size() < graph.length){
            int idxMin = 0;
            int value = Integer.MAX_VALUE;
            for (int i = 0; i < vertices.size(); i++) {
                Vertex v = vertices.get(i);
                if(!passedVertices.contains(v) && v.getValue() < value){
                    value = v.getValue();
                    idxMin = i;
                }
            }
            List<Vertex> neighbours = new ArrayList<>();
            for (int i = 0; i < vertices.size(); i++) {
                if (graph[idxMin][i] != 0) {
                    neighbours.add(vertices.get(i));
                    Vertex v = vertices.get(i);
                    if(!passedVertices.contains(v)){
                        neighbours.add(vertices.get(i));
                    }
                }
            }
            neighbours.sort(Comparator.comparingInt(Vertex::getValue));
            for (int i = 0; i < neighbours.size(); i++) {

                if (neighbours.get(i).getValue() > vertices.get(idxMin).getValue() + graph[idxMin][neighbours.get(i).getNumber() - 1    ]){
                    neighbours.get(i).setValue(value);
                }
            }
            passedVertices.add(vertices.get(idxMin));

        }
        System.out.println(vertices);
    }
}
