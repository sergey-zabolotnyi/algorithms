package lessons.lesson22_11092023;

import java.util.*;
import java.util.stream.Collectors;

public class Main1 {
    public static void main(String[] args) {
        String[] words = {"listen", "silent", "hello", "world", "act", "cat", "dog", "god"};

        Map<String, List<String>> collected = Arrays.stream(words)
                .collect(Collectors.groupingBy(
                        word -> {
                            char[] charArray = word.toCharArray();
                            Arrays.sort(charArray);
                            return new String(charArray);
                        }
                ));

        collected.values().stream()
                .filter(word -> word.size() > 1)
                .forEach(word -> System.out.println("Содержат одинаковые буквы: " + String.join(", ", word)));

//        Map<String, List<String>> map = new HashMap<>();
//
//        for (String word : words) {
//            char[] letters = word.toCharArray();
//            Arrays.sort(letters);
//            String sorted = new String(letters);
//            if (!map.containsKey(sorted)) {
//                map.put(sorted, new ArrayList<>());
//            }
//            map.get(sorted).add(word);
//        }
//
//        for (List<String> list : map.values()) {
//            if (list.size() > 1) {
//                System.out.println("Содержат одинаковые буквы: " + String.join(", ", list));
//            }
//        }
    }
}