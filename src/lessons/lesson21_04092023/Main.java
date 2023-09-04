package lessons.lesson21_04092023;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree(5);
        tree.insert(3);
        tree.insert(1);
        tree.insert(7);
        tree.insert(9);
        tree.insert(8);
        tree.insert(4);
        tree.insert(6);

        System.out.println(tree.right.right.left.value);
        System.out.println(tree.countNodes(tree.left));
        System.out.println(tree.calculateHeight(tree));
    }
}
