package homeWorks.hw13_06062023.task1;

import java.util.LinkedList;
import java.util.Queue;

// BST
public class Tree {

    private Node root = null;

    public void add(int value) {
        Node temp = new Node();
        temp.value = value;
        // Если дерево пусто, то temp становится корнем
        if (root == null) {
            root = temp;
            return;
        }
        // Дерево не пусто - ищем место в нем для temp
        Node t = root;
        while (true) {
            if (value < t.value) {
                // Нужно двигаться влево
                if (t.leftChild != null) {
                    // Левый потомок существует - переходим на него
                    t = t.leftChild;
                } else {
                    // Левого потомка не существует, значит нашли место для temp
                    t.leftChild = temp;
                    return;
                }
            } else {
                // Нужно двигаться вправо
                if (t.rightChild != null) {
                    // Правый потомок существует - переходим на него
                    t = t.rightChild;
                } else {
                    // Правого потомка не существует, значит нашли место для temp
                    t.rightChild = temp;
                    return;
                }
            }
        }
    }

    public void print() {
        pass(root);
    }

    // Обход в глубину
    private void pass(Node t) {
        if (t.leftChild != null) {
            pass(t.leftChild);
        }
        System.out.println(t.value);
        if (t.rightChild != null) {
            pass(t.rightChild);
        }
    }

    // Обход в ширину
    public void pass() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            if (temp.leftChild != null) {
                queue.add(temp.leftChild);
            }
            if (temp.rightChild != null) {
                queue.add(temp.rightChild);
            }
            System.out.println(temp.value);
        }
    }

    private class Node {
        int value;
        Node leftChild, rightChild;
    }

}
