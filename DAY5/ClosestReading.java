import java.util.Scanner;

public class ClosestReading {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input readings
        System.out.print("Enter the number of readings: ");
        int n = scanner.nextInt();
        int[] readings = new int[n];

        System.out.println("Enter the readings:");
        for (int i = 0; i < n; i++) {
            readings[i] = scanner.nextInt();
        }

        // Input target
        System.out.print("Enter the target temperature: ");
        int target = scanner.nextInt();

        // Input k
        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();

        // Find the K-th closest reading
        int result = findKthClosest(readings, target, k);
        System.out.println("The " + k + "-th closest reading is: " + result);
    }

    public static int findKthClosest(int[] readings, int target, int k) {
        int n = readings.length;
        // Create an array of distances
        int[] distances = new int[n];
        for (int i = 0; i < n; i++) {
            distances[i] = Math.abs(readings[i] - target);
        }

        // Use Quickselect to find the K-th closest
        return quickSelect(readings, distances, 0, n - 1, k - 1);
    }

    private static int quickSelect(int[] readings, int[] distances, int left, int right, int k) {
        if (left == right) {
            return readings[left];
        }

        int pivotIndex = partition(readings, distances, left, right);
        if (k == pivotIndex) {
            return readings[k];
        } else if (k < pivotIndex) {
            return quickSelect(readings, distances, left, pivotIndex - 1, k);
        } else {
            return quickSelect(readings, distances, pivotIndex + 1, right, k);
        }
    }

    private static int partition(int[] readings, int[] distances, int left, int right) {
        int pivotDistance = distances[right];
        int pivotReading = readings[right];
        int storeIndex = left;

        for (int i = left; i < right; i++) {
            if (distances[i] < pivotDistance || (distances[i] == pivotDistance && readings[i] < pivotReading)) {
                swap(readings, distances, storeIndex, i);
                storeIndex++;
            }
        }
        swap(readings, distances, storeIndex, right);
        return storeIndex;
    }

    private static void swap(int[] readings, int[] distances, int i, int j) {
        int tempReading = readings[i];
        readings[i] = readings[j];
        readings[j] = tempReading;

        int tempDistance = distances[i];
        distances[i] = distances[j];
        distances[j] = tempDistance;
    }
}