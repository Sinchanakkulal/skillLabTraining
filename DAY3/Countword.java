//Write a function to count the number of times each word appears in a given paragraph.

//Input: "the cat and the hat"
//Output: {"the": 2, "cat": 1, "and": 1, "hat": 1}
//through recursive  method


import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Countword {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the paragraph:");
        String paragraph = sc.nextLine();

        Map<String, Integer> countWord = new HashMap<>();
        countWordInParagraph(paragraph.split(" "), 0, countWord);

        System.out.println("Word frequency count is:");
        System.out.print(countWord);

        sc.close();
    }

    public static Map<String, Integer> countWordInParagraph(String[] words, int index, Map<String, Integer> countWord) {
        // Base case
        if (index >= words.length) {
            return countWord;
        }

        String word = words[index].toLowerCase().replaceAll("[^a-zA-Z]", "");
        if (!word.isEmpty()) {
            countWord.put(word, countWord.getOrDefault(word, 0) + 1);
        }

        return countWordInParagraph(words, index + 1, countWord);
    }
}