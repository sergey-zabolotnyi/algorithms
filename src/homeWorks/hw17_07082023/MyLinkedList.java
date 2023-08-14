package homeWorks.hw17_07082023;

class Node{
    int data;
    Node next;

    public Node (int data){
        this.data = data;
        this.next = null;
    }
}
public class MyLinkedList {
    Node head;
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.pushToTail(1);
        list.pushToTail(2);
        list.pushToTail(3);
        list.print();
        list.pushToIndex(3,4);
        list.pushToIndex(4, 5);
        list.print();
        list.removeLast();
        list.print();
        list.remove(3);
        list.print();
        System.out.println(list.get(0));
    }

    public void pushToTail(int data){
        if (head==null) head = new Node(data);
        else {
            Node currentNode = head;
            while (currentNode.next!=null){
                currentNode =currentNode.next;
            }
            currentNode.next = new Node(data);
        }
    }
    public void print(){
        Node currentNode = head;
        while (currentNode!=null){
            System.out.print(currentNode.data+", ");
            currentNode = currentNode.next;
        }
        System.out.println("null");
    }
    public void pushToIndex(int index, int data) {
        if (index < 0) {
            throw new IllegalArgumentException("The index can not be negative");
        }else if (index == 0) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        } else {
            Node newNode = new Node(data);
            Node currentNode = head;
            for (int i = 0; i < index - 1 && currentNode != null; i++) {
                currentNode = currentNode.next;
            }
            if (currentNode == null) {
                throw new IndexOutOfBoundsException("The index is out of bounds");
            }
            newNode.next = currentNode.next;
            currentNode.next = newNode;
        }
    }
    public void removeLast() {
        if (head == null) {
            return; // Список пустой
        } else if (head.next == null) {
            head = null; // Список имеет только 1 элемент
            return;
        }
        Node currentNode = head;
        while (currentNode.next.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = null;
    }
    public void remove(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("The index can not be negative");
        }else if (index == 0) {
            if (head != null) {
                head = head.next;
            }
        } else {
            Node currentNode = head;
            for (int i = 0; i < index - 1 && currentNode != null; i++) {
                currentNode = currentNode.next;
            }
            if (currentNode == null || currentNode.next == null) {
                throw new IndexOutOfBoundsException("The index is out of bounds");
            }
            currentNode.next = currentNode.next.next;
        }
    }

    public int get(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("The index can not be negative");
        }
        Node currentNode = head;
        for (int i = 0; i < index && currentNode != null; i++) {
            currentNode = currentNode.next;
        }
        if (currentNode == null) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        return currentNode.data;
    }
}
