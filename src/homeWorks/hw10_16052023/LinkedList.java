package homeWorks.hw10_16052023;

public class LinkedList {

    private Node head;

    public void pushToHead(int data) {
        Node temp = new Node();
        temp.value = data;
        temp.next = head;
        head = temp;
    }

    public void pushToTail(int data) {
        Node temp = new Node();
        temp.value = data;
        if (head == null) {
            // Список пустой, значит новый элемент и есть head.
            // Искать "хвост" не нужно
            head = temp;
        } else {
            // Список не пустой. Ищем "хвост" списка
            Node t = head;
            while (t.next != null) {
                t = t.next;
            }
            t.next = temp;
        }
    }

    public void pushToIndex(int index, int data) {
        Node temp = new Node();
        temp.value = data;
        if (index <= 0) {
            // То вставляем temp со стороны "головы" списка
            pushToHead(data);
        }
        int count = 0;
        Node t = head;
        while (t.next != null) {
            if (count == index - 1) {
                break;
            }
            count++;
            t = t.next;
        }
        // t указывает на элемент, после которого мы должны вставить temp
        temp.next = t.next;
        t.next = temp;
    }

    public void removeFirst() {
        if (head != null) {
            head = head.next;
        }
    }

    public void removeLast() {
        if (head == null || head.next == null) {
            head = null;
            return;
        }
        Node t = head;
        while (t.next.next != null) {
            t = t.next;
        }
        t.next = null;
    }
    public void remove(int index) {
        if (index < 0 || head == null) {
            return;
        }
        if (index == 0) {
            head = head.next;
            return;
        }
        Node t = head;
        int count = 0;
        while (t.next != null && count < index - 1) {
            t = t.next;
            count++;
        }
        if (t.next != null) {
            t.next = t.next.next;
        }
    }
    public int get(int index) {
        if (index < 0 || head == null) {
            throw new IndexOutOfBoundsException();
        }
        Node t = head;
        int count = 0;
        while (t != null && count < index) {
            t = t.next;
            count++;
        }
        if (t != null) {
            return t.value;
        }
        throw new IndexOutOfBoundsException();
    }
    public int size() {
        int count = 0;
        Node t = head;
        while (t != null) {
            count++;
            t = t.next; }
        return count;
    }

    public void print() {
        Node t = head;
        while (t != null) {
            System.out.print(t.value + " ");
            t = t.next; }
        System.out.println();
    }

    class Node {
        int value;
        Node next;
    }

}