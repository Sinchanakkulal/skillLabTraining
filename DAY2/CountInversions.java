import java.util.Scanner;

public class CountInversions {
    private static int mergeAndCount(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left, j = mid, k = left, count = 0;
        
        while (i < mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                count += mid - i;
            }
        }
        
        while (i < mid) {
            temp[k++] = arr[i++];
        }
        
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        
        System.arraycopy(temp, left, arr, left, right - left + 1);
        return count;
    }
    
    private static int mergeSortAndCount(int[] arr, int[] temp, int left, int right) {
        if (left >= right) return 0;
        
        int mid = (left + right) / 2;
        int leftCount = mergeSortAndCount(arr, temp, left, mid);
        int rightCount = mergeSortAndCount(arr, temp, mid + 1, right);
        int mergeCount = mergeAndCount(arr, temp, left, mid + 1, right);
        
        return leftCount + rightCount + mergeCount;
    }
    
    public static int countInversions(int[] arr) {
        int[] temp = new int[arr.length];
        return mergeSortAndCount(arr, temp, 0, arr.length - 1);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        
        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        scanner.close();
        System.out.println("The inversion count is " + countInversions(arr));
    }
}
