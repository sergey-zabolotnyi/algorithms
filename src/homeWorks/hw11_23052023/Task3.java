package homeWorks.hw11_23052023;

// Task 3. Given the head of a linked list, remove the n-th node from the end of the list and return its head.
class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}

public class Task3 {
    public Node removeN(Node head, int n) {
        Node node = new Node(0);
        node.next = head;
        Node fast = node;
        Node slow = node;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // Удаляем nth node
        slow.next = slow.next.next;

        return node.next;
    }
}
