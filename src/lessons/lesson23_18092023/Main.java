package lessons.lesson23_18092023;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        graph.addVertex('G');
        graph.addEdge('A', 'B');
        graph.addEdge('B', 'C');
        graph.addEdge('D', 'C');
        graph.addEdge('A', 'E');
        graph.addEdge('F', 'E');
        graph.addEdge('A', 'G');
        graph.bf('A');
    }

}
