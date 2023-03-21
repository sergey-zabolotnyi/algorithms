package homeWorks.homeWork02_14032023;

public class LongestPrefix {
    public static void main(String[] args) {
        String[] str1 = {"flower", "flow", "flight"};
        String[] str2 = {"dog", "racecar", "car"};
        String[] myStr1 = {"transatlantic", "transfer", "translation"};
        String[] myStr2 = {"superhero", "supermodel", "superJava"};

        System.out.println(longestPrefixString(str1));
        System.out.println(longestPrefixString(str2));
        System.out.println("--------------------");
        System.out.println(longestPrefixString(myStr1));
        System.out.println(longestPrefixString(myStr2));
    }

    public static String longestPrefixString(String[] str) {
        String prefix = str[0];
        for (int i = 1; i < str.length; i++) {
            while (str[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "no prefix";
                }
            }
        }
        return prefix;
    }
}
