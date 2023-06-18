package homeWorks.hw13_06062023;

public class Task2 {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
         tree.root = new Node(3);
         tree.root.leftChild = new Node(2);
         tree.root.rightChild = new Node(4);
         tree.root.leftChild.leftChild = new Node(1);
         tree.root.rightChild.rightChild = new Node(5);
         tree.root.rightChild.rightChild.rightChild = new Node(6);

        System.out.println("Высота дерева: " + tree.height());
    }
}
class Node {
    int data;
    Node leftChild;
    Node rightChild;

    public Node(int data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }
}

class BinaryTree {
    Node root;

    public BinaryTree() {
        this.root = null;
    }

    private int height(Node t) {
        if (t == null) {
            return 0;
        } else {
            return Math.max(height(t.leftChild), height(t.rightChild)) + 1;
        }
    }

    public int height() {
        return height(root);
    }
}
