package lessons.lesson11_23052023;

public class Main {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.pushToHead(10);
        list.pushToTail(20);
        list.pushToIndex(1, 15);
        list.pushToIndex(-10, 0);
        list.print();
        System.out.println(list.size());
        System.out.println(list.get(3));
        System.out.println(list.get(5));
        System.out.println(list.get(0));
//        list.removeFirst();
//        list.removeLast();
        list.print();
        list.remove(1);
        list.print();


//        list.remove(5);
//        list.print();
//        list.remove(5);
//        list.print();
    }

}
