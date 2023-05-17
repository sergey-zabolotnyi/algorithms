package homeWorks.hw09_09052023;

public class Queue {

    private int[] arr;      // массив для хранения элементов queue
    private int head;      // head указывает на первый элемент в queue
    private int tail;       // tail часть указывает на последний элемент в queue
    private int capacity;   // максимальная емкость queue
    private int count;      // текущий размер queue

    public Queue(int size) {
        arr = new int[size];
        capacity = size;
        head = 0;
        tail = -1;
        count = 0;
    }

    public void pushToEnd(int data) {
        if (tail == capacity - 1) {
            tail = -1;
        }
        arr[++tail] = data;
        count++;
    }

    public int remove() {
        int temp = arr[head++];
        if (head == capacity) {
            head = 0;
        }
        count--;
        return temp;
    }

    public int peek() {
        return arr[head];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }
}
