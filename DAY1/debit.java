import java.util.Scanner;

public class DebitCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the number of transactions
        System.out.print("Enter the number of transactions: ");
        int n = sc.nextInt();
        int[] transactions = new int[n];

        // Input transaction amounts
        System.out.println("Enter the transaction amounts:");
        for (int i = 0; i < n; i++) {
            transactions[i] = sc.nextInt();
        }

        // Count debit transactions (less than 1000)
        int debitCount = 0;
        for (int amount : transactions) {
            if (amount < 1000) {
                debitCount++;
            }
        }

        System.out.println("The number of debits: " + debitCount);
        sc.close();
    }
}
