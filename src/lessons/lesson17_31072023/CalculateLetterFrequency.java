package lessons.lesson17_31072023;

import java.util.HashMap;
import java.util.Map;

public class CalculateLetterFrequency {
    public static void main(String[] args) {
        String text = "The quick fox jumps over the lazy dog";
        Map<Character,Integer> letterFrequency = calculateLetterFrequency(text);
        for (Map.Entry<Character,Integer> entry : letterFrequency.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
    public static Map<Character,Integer> calculateLetterFrequency(String text){
        Map<Character,Integer> letterFrequency = new HashMap<>();
        String lowercaseText = text.toLowerCase();
        for (int i = 0; i < lowercaseText.length(); i++) {
            char c = lowercaseText.charAt(i);
            if (Character.isLetter(c)){
                letterFrequency.put(c,letterFrequency.getOrDefault(c,0)+1);
            }
        }
        return letterFrequency;
    }
}
