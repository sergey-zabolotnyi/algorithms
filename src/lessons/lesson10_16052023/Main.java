package lessons.lesson10_16052023;

public class Main {

    public static void main(String[] args) {
        Queue queue = new Queue(10);
        for (int i = 0; i < 8; i++) {
            queue.push(i);
        }
        System.out.println(queue.size());
        System.out.println(queue.remove());
        for (int i = 0; i < 7; i++) {
            System.out.println(queue.remove());
        }
        System.out.println(queue.isEmpty());
    }

}