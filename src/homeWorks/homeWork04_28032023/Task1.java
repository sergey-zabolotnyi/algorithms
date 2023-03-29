package homeWorks.homeWork04_28032023;

import java.util.Stack;
public class Task1 {

    // 1. Закончить итерационное решение задачи о Ханойских башнях.

    public static void main(String[] args) {

        iterativeHanoi(3); // три диска

        System.out.println("\n------------------------------------\n");

        iterativeHanoi(4); // четыре диска
    }
    public static void iterativeHanoi(int n) {
        Stack<Integer> s = new Stack<Integer>();
        Stack<Integer> d = new Stack<Integer>();
        Stack<Integer> a = new Stack<Integer>();
        int totalMoves = (int) Math.pow(2, n) - 1;
        for (int i = n; i >= 1; i--) {
            s.push(i);
        }
        if (n % 2 == 0) {
            Stack<Integer> temp = d;
            d = a;
            a = temp;
        }
        for (int i = 1; i <= totalMoves; i++) {
            if (i % 3 == 1) {
                moveDisksBetweenTwoPoles(s, d, "A", "C");
            } else if (i % 3 == 2) {
                moveDisksBetweenTwoPoles(s, a, "A", "B");
            } else if (i % 3 == 0) {
                moveDisksBetweenTwoPoles(a, d, "B", "C");
            }
        }
    }

    public static void moveDisksBetweenTwoPoles(Stack<Integer> from, Stack<Integer> to, String fromPole, String toPole) {
        int pole1Top = from.isEmpty() ? Integer.MAX_VALUE : from.peek();
        int pole2Top = to.isEmpty() ? Integer.MAX_VALUE : to.peek();
        if (pole1Top < pole2Top) {
            int disk = from.pop();
            to.push(disk);
            System.out.println("Переставляем диск " + disk + " со стержня " + fromPole + " на стержень " + toPole);
        } else {
            int disk = to.pop();
            from.push(disk);
            System.out.println("Переставляем диск " + disk + " со стержня " + toPole + " на стержень " + fromPole);
        }
    }
}