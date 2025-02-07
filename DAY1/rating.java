import java.util.HashMap;
import java.util.Scanner;

public class MostFrequentRating {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the number of ratings
        System.out.print("Enter the number of ratings: ");
        int n = sc.nextInt();
        int[] ratings = new int[n];

        // Input the ratings
        System.out.println("Enter the ratings:");
        for (int i = 0; i < n; i++) {
            ratings[i] = sc.nextInt();
        }

        // HashMap to count frequency of each rating
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int rating : ratings) {
            frequencyMap.put(rating, frequencyMap.getOrDefault(rating, 0) + 1);
        }

        // Find the most frequent rating
        int mostFrequentRating = -1, maxCount = 0;
        for (int key : frequencyMap.keySet()) {
            if (frequencyMap.get(key) > maxCount) {
                maxCount = frequencyMap.get(key);
                mostFrequentRating = key;
            }
        }

        System.out.println("The most frequent rating is: " + mostFrequentRating + " (appeared " + maxCount + " times)");
        sc.close();
    }
}
