import java.util.Scanner;
import java.util.Stack;

public class StockPriceAnalysis {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // User input for the size of the array
        System.out.print("Enter the number of days: ");
        int n = scanner.nextInt();
        
        // User input for the stock prices
        int[] arr = new int[n];
        System.out.println("Enter the stock prices for each day:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        // Call the function to find the next greater prices
        int[] result = findNextGreater(arr);
        
        // Print the result
        System.out.print("Next greater prices: ");
        for (int price : result) {
            System.out.print(price + " ");
        }
    }

    // Function to find the next greater element using dynamic programming
    private static int[] findNextGreater(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Initialize all elements in result to -1
        for (int i = 0; i < n; i++) {
            result[i] = -1;
        }

        // Traverse the array from left to right
        for (int i = 0; i < n; i++) {
            // While stack is not empty and the current element is greater than the element at the index stored at the top of the stack
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                // Pop the index from the stack and set the result for that index
                int index = stack.pop();
                result[index] = arr[i];
            }
            // Push the current index onto the stack
            stack.push(i);
        }

        return result;
    }
}