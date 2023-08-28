package homeWorks.hw20_28082023;

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int value) {
        this.value = value;
        this.right = null;
        this.left = null;
    }
}
public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(6);
        tree.insert(15);
        tree.insert(12);

        TreeNode foundNode = tree.find(15);
        if (foundNode != null) {
            System.out.println("Node with this value found " + foundNode.value);
        } else {
            System.out.println("Node with this value not found.");
        }

        tree.delete(10);

        tree.print(tree.root);
    }
}

class BinaryTree {
   TreeNode root;

    public BinaryTree() {
        this.root = null;
    }
    public void insert(int value){
        TreeNode newNode = new TreeNode(value);
        if (root == null){
            root = newNode;
            return;
        }
        TreeNode currentNode = root;
        while (true){
            if (value < currentNode.value){
                if (currentNode.left == null){
                    currentNode.left = newNode;
                    return;
                }
                currentNode = currentNode.left;
            }
            else {
                if (currentNode.right == null){
                    currentNode.right = newNode;
                    return;
                }
                currentNode = currentNode.right;
            }
        }
    }
    public TreeNode find(int key) {
        return findRecursive(root, key);
    }
    private TreeNode findRecursive(TreeNode node, int key) {
        if (node == null || node.value == key) {
            return node;
        }

        if (key < node.value) {
            return findRecursive(node.left, key);
        } else {
            return findRecursive(node.right, key);
        }
    }
    public void delete(int value) {
        root = deleteRecursive(root, value);
    }
    private TreeNode deleteRecursive(TreeNode node, int value) {
        if (node == null) {
            return null;
        }
        if (value == node.value) {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            TreeNode minNode = findMin(node.right);
            node.value = minNode.value;
            node.right = deleteRecursive(node.right, minNode.value);
        } else if (value < node.value) {
            node.left = deleteRecursive(node.left, value);
        } else {
            node.right = deleteRecursive(node.right, value);
        }
        return node;
    }
    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    public void print(TreeNode node) {
        if (node != null) {
            print(node.left);
            System.out.println(node.value);
            print(node.right);
        }
    }
}