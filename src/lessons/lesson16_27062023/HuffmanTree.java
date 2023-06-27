package lessons.lesson16_27062023;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class HuffmanNode implements Comparable<HuffmanNode> {
    char character;
    int frequency;
    HuffmanNode left;
    HuffmanNode right;

    public HuffmanNode(char character, int frequency, HuffmanNode left, HuffmanNode right) {
        this.character = character;
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    @Override
    public int compareTo(HuffmanNode other) {
        return this.frequency - other.frequency;
    }
}

public class HuffmanTree {
    public static HuffmanNode buildHuffmanTree(Map<Character, Integer> frequencies) {
        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>();

        for (Map.Entry<Character, Integer> entry : frequencies.entrySet()) {
            char character = entry.getKey();
            int frequency = entry.getValue();
            priorityQueue.offer(new HuffmanNode(character, frequency, null, null));
        }

        while (priorityQueue.size() > 1) {
            HuffmanNode leftChild = priorityQueue.poll();
            HuffmanNode rightChild = priorityQueue.poll();

            HuffmanNode parent = new HuffmanNode('\0', leftChild.frequency + rightChild.frequency, leftChild, rightChild);
            priorityQueue.offer(parent);
        }

        return priorityQueue.poll();
    }

    public static void buildHuffmanCodes(HuffmanNode root, String code, Map<Character, String> huffmanCodes) {
        if (root.isLeaf()) {
            huffmanCodes.put(root.character, code);
            return;
        }

        buildHuffmanCodes(root.left, code + "0", huffmanCodes);
        buildHuffmanCodes(root.right, code + "1", huffmanCodes);
    }

    public static String encodeString(String text, Map<Character, String> huffmanCodes) {
        StringBuilder encodedString = new StringBuilder();

        for (char c : text.toCharArray()) {
            encodedString.append(huffmanCodes.get(c));
        }

        return encodedString.toString();
    }

    public static String decodeString(String encodedString, HuffmanNode root) {
        StringBuilder decodedString = new StringBuilder();
        HuffmanNode current = root;

        for (char bit : encodedString.toCharArray()) {
            if (bit == '0') {
                current = current.left;
            } else {
                current = current.right;
            }

            if (current.isLeaf()) {
                decodedString.append(current.character);
                current = root;
            }
        }

        return decodedString.toString();
    }

    public static void main(String[] args) {
        String text = "Hello, Huffman!";
        System.out.println("Исходный текст: " + text);
        Map<Character, Integer> frequencies = new HashMap<>();

        for (char c : text.toCharArray()) {
            frequencies.put(c, frequencies.getOrDefault(c, 0) + 1);
        }

        HuffmanNode root = buildHuffmanTree(frequencies);
        Map<Character, String> huffmanCodes = new HashMap<>();
        buildHuffmanCodes(root, "", huffmanCodes);

        String encodedString = encodeString(text, huffmanCodes);
        System.out.println("Encoded String: " + encodedString);

        String decodedString = decodeString(encodedString, root);
        System.out.println("Decoded String: " + decodedString);
    }
}