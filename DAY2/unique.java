import java.util.Scanner;

public class unique {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("total number of integers:");
        int k = sc.nextInt();

        int[] N = new int[k]; // Declare array properly before use
        System.out.println("Enter the numbers:");

        for (int index = 0; index < k; index++) {
            N[index] = sc.nextInt(); // Store input values in the array
        }

        int[] repeatdigit = new int[10]; // To mark if a digit is present
        int[] uniquedigit = new int[10]; // To store unique digits
        int idx = 0; // Index for unique digits

        // Extract digits and mark them in repeatdigit array
        for (int index = 0; index < k; index++) {
            int num = N[index];
            while (num > 0) {
                int digit = num % 10; // Get last digit
                if (repeatdigit[digit] == 0) { // If digit is found first time
                    uniquedigit[idx++] = digit; // Store in unique digits array
                    repeatdigit[digit] = 1; // Mark it as found
                }
                num /= 10; // Remove last digit
            }
        }

        selectionSort(uniquedigit, idx); // Sort only the extracted digits

        // Print sorted unique digits
        System.out.print("[");
        for (int i = 0; i < idx; i++) {
            System.out.print(uniquedigit[i]);
            if (i < idx - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        sc.close();
    }

    // Selection Sort function to sort the unique digits
    public static void selectionSort(int[] uniquedigit, int size) {
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (uniquedigit[j] < uniquedigit[minIndex]) {
                    minIndex = j; // Find the smallest element
                }
            }
            // Swap the smallest element with the first unsorted element
            int temp = uniquedigit[i];
            uniquedigit[i] = uniquedigit[minIndex];
            uniquedigit[minIndex] = temp;
        }
    }
}
