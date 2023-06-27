package lessons.lesson16_27062023;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main2 {

    public static void main(String[] args) {
        String str = "abbc";
        huffmanTreeBuild(str);
    }

    private static void huffmanTreeBuild(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        // Считаем частоту появления каждого символа в строке
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : str.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
//        // Проходим в цикле по всем буквам строки str
//        for (char c : str.toCharArray()) {
//            if (freq.containsKey(c)) {
//                // Уже такая буква встречалась
//                freq.put(c, freq.get(c) + 1);
//            } else {
//                // Такая буква встречается в первый раз
//                freq.put(c, 1);
//            }
//        }
        // Создаем очередь с приоритетами (готовый класс) - это обычная очередь, но
        // элементы добавляются в эту очередь отсортированные по указанному параметру
        // (приоритету). У нас этот параметр - это частота буквы. Чем выше freq, тем
        // элемент ближе к началу в этой очереди
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(f -> f.freq));
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            pq.add(new Node(entry.getKey(), entry.getValue()));
        }
        // Пока в очереди не останется один элемент
        while (pq.size() != 1) {
            // Удаляем из очереди два элемента с низшими частотами
            Node a = pq.poll();
            Node b = pq.poll();
            int sum = a.freq + b.freq;
            pq.add(new Node(null, sum, a, b));
        }
        // Дерево Хаффмана построено. Пройдем по нему и получим таблицу кодирования
        Map<Character, String> huffmanCode = new HashMap<>();
        encode(pq.peek(), "", huffmanCode);
        // Выведем таблицу кодирования
        for (var entry : huffmanCode.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
        // Кодируем строку
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            sb.append(huffmanCode.get(c));
        }
        System.out.println(sb);
        decode(sb.toString(), huffmanCode);
    }

    private static void encode(Node t, String s, Map<Character, String> huffmanCode) {
        if (t == null) {
            return;
        }
        if (t.leftChild == null && t.rightChild == null) {
            // Найден лист дерева Хаффмана - кодируем
            huffmanCode.put(t.c, s);
        }
        encode(t.leftChild, s + '0', huffmanCode);
        encode(t.rightChild, s + '1', huffmanCode);
    }

    private static void decode(String s, Map<Character, String> huffmanCode) {
        StringBuilder sb = new StringBuilder();
        int len = 1;
        int position = 0;
        while(position + len <= s.length()) {
            String subs = s.substring(position, position + len);
            boolean f = false;
            for (var entry : huffmanCode.entrySet()) {
                if (entry.getValue().equals(subs)) {
                    // Мы нашли данный код
                    sb.append(entry.getKey());
                    position = position + len;
                    len = 1;
                    f = true;   // флаг того, что код был найден в таблице
                    break;
                }
            }
            // Если в таблице кодирования мы не нашли код, то увеличиваем subs
            if (!f) {
                len = len + 1;
            }
        }
        System.out.println(sb);
    }

    private static class Node {
        Character c;
        int freq;
        Node leftChild, rightChild;

        public Node(Character c, int freq) {
            this.c = c;
            this.freq = freq;
        }

        public Node(Character c, int freq, Node leftChild, Node rightChild) {
            this.c = c;
            this.freq = freq;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }

}
