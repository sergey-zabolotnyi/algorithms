package lessons.lesson10_16052023;
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


//    pushToHead(int data),
//    pushToTail(int data),
//    pushToIndex(int index, int data)

//    removeFirst(),
//    removeLast(),
//    remove(int index)
//    get(int index)
//    size()
//    print()

    class Node {
        int value;
        Node next;
    }

}