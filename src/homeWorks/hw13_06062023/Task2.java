package homeWorks.hw13_06062023;

public class Task2 {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
         tree.root = new Node(3);
         tree.root.left = new Node(2);
         tree.root.right = new Node(4);
         tree.root.left.left = new Node(1);
         tree.root.right.right = new Node(5);
         tree.root.right.right.right = new Node(6);

        int height = tree.getHeight();
        System.out.println("Высота дерева: " + height);
    }
}
class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree {
    Node root;

    public BinaryTree() {
        this.root = null;
    }

    private int computeHeight(Node node) {
        if (node == null) {
            return 0;
        } else {
            int leftHeight = computeHeight(node.left);
            int rightHeight = computeHeight(node.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public int getHeight() {
        return computeHeight(root);
    }
}
