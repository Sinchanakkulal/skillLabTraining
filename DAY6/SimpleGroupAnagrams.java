import java.util.*;

public class SimpleGroupAnagrams {
    public static void groupAnagrams(String[] strs) {
        // Use a HashMap where key = sorted string, value = concatenated words
        Map<String, String> map = new HashMap<>();

        for (String str : strs) {
            // Sort characters of the string to form a key
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray); // This is the key

            // Concatenate words using a space
            map.put(sortedStr, map.getOrDefault(sortedStr, "") + (map.containsKey(sortedStr) ? ", " : "") + str);
        }

        // Print the grouped anagrams
        for (String value : map.values()) {
            System.out.println("[" + value + "]");
        }
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strs);
    }
}