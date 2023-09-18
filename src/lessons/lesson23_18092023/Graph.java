package lessons.lesson23_18092023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Graph {
    HashMap<Character, ArrayList<Character>> vertices;

    public Graph(){
        vertices = new HashMap<>();
    }

    public void addVertex(Character value) {
        if (this.vertices.containsKey(value)) throw new Error("this vertex already exists");
        this.vertices.put(value,new ArrayList<>());
    }
    public void addEdge(Character value1, Character value2) {
        if (!this.vertices.containsKey(value1) || !this.vertices.containsKey(value2))
            throw new Error("At least one of those vertices is missing");
        this.vertices.get(value1).add(value2);
        this.vertices.get(value2).add(value1);
    }

    public void print(){
        for (Character key: vertices.keySet()){
            System.out.print(key+" -> ");
            for (Character value: vertices.get(key))
                System.out.print(value+", ");
            System.out.println();
        }
    }

    public void neighbour(Character value) {
        if (!vertices.containsKey(value)) throw new IllegalArgumentException("Vertex is not found");
        System.out.println(value + " -> " + vertices.get(value));
    }
    public void bf(Character value) {
        ArrayList<Character> queue = new ArrayList<>();
        HashSet<Character> set = new HashSet<>();
        queue.add(value);
        set.add(value);
        System.out.print(value + " ");
        while (queue.size() > 0) {
            Character key = queue.remove(0);
            for (Character neighbor : vertices.get(key)) {
                if (!set.contains(neighbor)) {
                    set.add(neighbor);
                    queue.add(neighbor);
                    System.out.print(neighbor + " ");
                }
            }
        }
    }

}
