package homeWorks.hw14_13062023;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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

    // Обход в глубину (рекурсивная реализация)
    private void pass(Node t) {
        if (t.leftChild != null) {
            pass(t.leftChild);
        }
        System.out.println(t.value);
        if (t.rightChild != null) {
            pass(t.rightChild);
        }
    }

    public void passIterative() {
        passIterative(root);
    }

    // Обход в глубину (итерационная реализация)
    private void passIterative(Node top) {
        Stack<Node> stack = new Stack<>();
        while (top != null || !stack.isEmpty()) {
            if (!stack.isEmpty()) {
                top = stack.pop();
                System.out.println(top.value);
                if (top.rightChild != null) {
                    top = top.rightChild;
                } else {
                    top = null;
                }
            }
            while (top != null) {
                stack.push(top);
                top = top.leftChild;
            }
        }
    }
    public int height() {
        return height(root);
    }

    private int height(Node t) {
        if (t == null) {
            return 0;
        }
        return Math.max(height(t.leftChild), height(t.rightChild)) + 1;
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

    public boolean contains(int value) {
        return search(root, value) != null;
    }

    private Node search(Node t, int value) {
        if (t == null || t.value == value) {
            return t;
        }
        if (value < t.value) {
            return search(t.leftChild, value);
        } else {
            return search(t.rightChild, value);
        }
    }

    private Node searchParent(Node t, Node s) {
        if (s == root) {
            return null;
        }
        if (t.leftChild == s || t.rightChild == s) {
            return t;
        }
        if (s.value < t.value) {
            return searchParent(t.leftChild, s);
        } else {
            return searchParent(t.rightChild, s);
        }
    }

    // Находим минимальный элемент в поддереве элемента t
    private Node subtreeMin(Node t) {
        while (t.leftChild != null) {
            t = t.leftChild;
        }
        return t;
    }

    public void delete(int value) {
        Node t = search(root, value);
        if (t != null) {
            delete(t);
        }
    }

    private void delete (Node t) {
        // Нам нужен parent элемента t. Найдем его
        Node parent = searchParent(root, t);
        if (t.leftChild == null && t.rightChild == null) {
            // Удаляется лист дерева
            if (parent.leftChild == t) {
                // У родителя удаляется левый потомок
                parent.leftChild = null;
            } else {
                // У родителя удаляется правый потомок
                parent.rightChild = null;
            }
        } else if (t.leftChild == null || t.rightChild == null) {
            // Удаляется элемент с одним потомком
            if (t.leftChild == null) {
                if (parent.leftChild == t) {
                    parent.leftChild = t.rightChild;
                } else {
                    parent.rightChild = t.rightChild;
                }
            } else {
                if (parent.leftChild == t) {
                    parent.leftChild = t.leftChild;
                } else {
                    parent.rightChild = t.leftChild;
                }
            }
        } else {
            // Удаляется элемент с двумя потомками
            // 1) Находим минимальный элемент в правом поддереве
            Node min = subtreeMin(t.rightChild);

            // Копируем минимальное значение, которое нужно удалить.
            t.value = min.value;
            
            // Рекурсивно удаляем минимальную ноду
            delete(min);

        }
    }

    private class Node {
        int value;
        Node leftChild, rightChild;
    }

}
