package lessons.lesson14_13062023;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.add(10);
        tree.add(5);
        tree.add(2);
        tree.add(6);
        tree.add(5);
        tree.add(20);
        tree.print();
        System.out.println();
        tree.pass();
        System.out.println();
        tree.passIterative();
        System.out.println();
        System.out.println(tree.height());
        System.out.println(tree.contains(5));
        System.out.println(tree.contains(30));
        tree.delete(2);
        tree.print();
    }

}
