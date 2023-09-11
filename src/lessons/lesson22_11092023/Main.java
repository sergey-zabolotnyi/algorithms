package lessons.lesson22_11092023;

import java.util.Hashtable;

public class Main {
    public static void main(String[] args) {
        String input = "pseudohyperactivity";
        Hashtable<Character,Integer> charFrequencyMap = new Hashtable<>();

        for (char c: input.toCharArray()){
            charFrequencyMap.put(c,charFrequencyMap.getOrDefault(c,0)+1);
        }
        char firstNonRepeatingChar = ' ';
        for (char c:input.toCharArray()){
            if (charFrequencyMap.get(c)==1){
                firstNonRepeatingChar = c;
                break;
            }
        }
        if (firstNonRepeatingChar!=' '){
            System.out.println("First non-repeating character: "+ firstNonRepeatingChar);
        }
        else {
            System.out.println("We couldn't find any non-repeating characters");
        }

    }
}
