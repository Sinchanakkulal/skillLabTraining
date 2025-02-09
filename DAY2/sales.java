import java.util.*;

class InversionCount {
    static int mergeAndCount(int[] arr, int left, int mid, int right) {
        int[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);
        int i = 0, j = 0, k = left, swaps = 0;
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) arr[k++] = leftArr[i++];
            else { arr[k++] = rightArr[j++]; swaps += (mid + 1) - (left + i); }
        }
        while (i < leftArr.length) arr[k++] = leftArr[i++];
        while (j < rightArr.length) arr[k++] = rightArr[j++];
        return swaps;
    }

    static int mergeSortAndCount(int[] arr, int left, int right) {
        if (left >= right) return 0;
        int mid = left + (right - left) / 2;
        return mergeSortAndCount(arr, left, mid) + mergeSortAndCount(arr, mid + 1, right) + mergeAndCount(arr, left, mid, right);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of elements:");
        int n = scanner.nextInt();
        int[] P = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            P[i] = scanner.nextInt();
        }
        scanner.close();
        System.out.println("The inversion count is " + mergeSortAndCount(P, 0, P.length - 1));
    }
}
