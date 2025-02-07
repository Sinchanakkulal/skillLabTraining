import java.util.HashSet;
import java.util.Scanner;

public class FirstDuplicateFinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Define array size (10 in this example)
        System.out.print("Enter the number of elements (max 10): ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        // Input array elements
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Using HashSet to track seen elements
        HashSet<Integer> seen = new HashSet<>();
        int firstDuplicate = -1;

        for (int num : arr) {
            if (seen.contains(num)) {
                firstDuplicate = num;
                break;
            }
            seen.add(num);
        }

        if (firstDuplicate != -1) {
            System.out.println("The first duplicate is: " + firstDuplicate);
        } else {
            System.out.println("No duplicate found.");
        }

        sc.close();
    }
}
