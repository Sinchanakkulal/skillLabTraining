import java.util.Arrays;
import java.util.Scanner;

public class PermutationInString {
    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] charCount1 = new int[26];  // Frequency array for s1
        int[] charCount2 = new int[26];  // Frequency array for the sliding window in s2

        // Fill charCount1 with frequency of characters in s1
        for (char c : s1.toCharArray()) {
            charCount1[c - 'a']++; 
        }
        int windowSize = s1.length();

        // Fill charCount2 with first window of s2
        for (int i = 0; i < windowSize; i++) {
            charCount2[s2.charAt(i) - 'a']++;
        }
        
        // Check if first window matches
        if (Arrays.equals(charCount1, charCount2)) return true;

        // Slide the window across s2
        for (int i = windowSize; i < s2.length(); i++) {
            charCount2[s2.charAt(i) - 'a']++;      // Add new character to the window
            charCount2[s2.charAt(i - windowSize) - 'a']--;  // Remove old character from the window

            if (Arrays.equals(charCount1, charCount2)) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Take user input for s1 and s2
        System.out.print("Enter string s1: ");
        String s1 = scanner.nextLine();
        
        System.out.print("Enter string s2: ");
        String s2 = scanner.nextLine();
        
        // Check if s2 contains a permutation of s1
        boolean result = checkInclusion(s1, s2);
        
        System.out.println("Does s2 contain a permutation of s1? " + result);
        
        scanner.close();
    }
}
