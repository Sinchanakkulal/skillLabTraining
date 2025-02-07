import java.util.Scanner;

public class one {
    public static void main(String args[]) {
        int size, s_min;
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        s_min = sec_min(arr); 
        System.out.println("Second minimum is: " + s_min); 
    }

    public static int sec_min(int[] arr) { 
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        int s_min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (s_min > arr[i] && arr[i] != min) { 
                s_min = arr[i];
            }
        }
        return s_min;
    }
}