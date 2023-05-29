package lessons.lesson11_23052023;

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
            return;
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

    public void print() {
        Node t = head;
        while (t != null) {
            System.out.print(t.value + " ");
            t = t.next;
        }
        System.out.println();
    }

    public int size() {
        int count = 0;
        Node t = head;
        while (t != null) {
            count++;
            t = t.next;
        }
        return count;
    }

    public int get(int index) {
        if (head == null) {
            System.out.println("List is empty");
            return -1;
        }
        if (index < 0) {
            return head.value;
        }
        int count = 0;
        Node t = head;
        while (t.next != null) {
            if (count == index) {
                break;
            }
            count++;
            t = t.next;
        }
        return t.value;
    }

    public void removeFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        head = head.next;
    }

    public void removeLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            // Удаление из списка, в котором один элемент
            head = null;
            return;
        }
        Node t = head.next, p = head;
        while (t.next != null) {
            p = p.next;
            t = t.next;
        }
        p.next = null;
    }

    public void remove(int index) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (index <= 0) {
            removeFirst();
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        int count = 1;
        Node t = head.next, p = head;
        while (t.next != null) {
            if (count == index) {
                break;
            }
            count++;
            p = p.next;
            t = t.next;
        }
        p.next = t.next;
    }

    class Node {
        int value;
        Node next;
    }

}
