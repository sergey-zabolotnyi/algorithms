package homeWorks.hw13_06062023;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Task3 {
    public static void main(String[] args) {
        // Создаем дерево с помощью массива
        Integer[] arr1 = {13, 5, 1, 8, 30   };
        TreeNode root = buildTree(arr1);

        // Проверяем и исправляем дерево
        treeCheck(root);
    }

    private static void treeCheck(TreeNode root) {
        boolean isBroken = isBSTBroken(root);
        if (isBroken) {
            fixBST(root);
            System.out.println("Дерево было исправлено:");
            printTree(root);
        } else {
            System.out.println("Дерево не сломано.");
        }
    }

    // Метод для построения дерева из массива
    private static TreeNode buildTree(Integer[] arr) {
        if (arr == null || arr.length == 0)
            return null;
        List<TreeNode> nodes = new ArrayList<>();
        for (Integer val : arr) {
            if (val == null) {
                nodes.add(null);
            } else {
                nodes.add(new TreeNode(val));
            }
        }

        TreeNode root = nodes.get(0);
        int i = 0, j = 1;
        while (j < nodes.size()) {
            TreeNode parent = nodes.get(i++);
            if (parent != null) {
                parent.left = nodes.get(j++);
                if (j < nodes.size())
                    parent.right = nodes.get(j++);
            }
        }
        return root;
    }

    // Метод для проверки, сломано ли дерево BST
    private static boolean isBSTBroken(TreeNode root) {
        if (root == null)
            return false;

        return !isSubtreeLesser(root.left, root.val) || !isSubtreeGreater(root.right, root.val)
                || isBSTBroken(root.left) || isBSTBroken(root.right);
    }

    private static boolean isSubtreeLesser(TreeNode node, int value) {
        if (node == null)
            return true;

        return node.val < value && isSubtreeLesser(node.left, value) && isSubtreeLesser(node.right, value);
    }

    private static boolean isSubtreeGreater(TreeNode node, int value) {
        if (node == null)
            return true;

        return node.val > value && isSubtreeGreater(node.left, value) && isSubtreeGreater(node.right, value);
    }

    // Метод для исправления дерева BST
    private static void fixBST(TreeNode root) {
        if (root == null)
            return;

        fixBST(root.left);
        fixBST(root.right);

        if (root.left != null && root.left.val > root.val) {
            // Обмен значениями
            int temp = root.left.val;
            root.left.val = root.val;
            root.val = temp;
        }

        if (root.right != null && root.right.val < root.val) {
            // Обмен значениями
            int temp = root.right.val;
            root.right.val = root.val;
            root.val = temp;
        }
    }

    // Метод для вывода дерева
    private static void printTree(TreeNode root) {
        if (root == null)
            return;

        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}