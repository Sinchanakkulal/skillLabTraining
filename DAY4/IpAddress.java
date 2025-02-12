package DAY4;
import java.util.Scanner;

public class IpAddress {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the IP address (it should be in xxx.xxx.xxx.xxx format):");
        String num = sc.nextLine();

        boolean isValid = addressCheck(num, 0);
        System.out.println("Is the IP valid? " + isValid);
        sc.close();
    }

    public static boolean addressCheck(String ip, int segment) {
        // Base case: if we have checked 4 segments
        if (segment == 4) {
            return ip.isEmpty(); // If there's no leftover part, it's valid
        }

        // Split the string into two parts
        String[] parts = ip.split("\\.", 2); // Split into at most 2 parts

        // If more than 2 parts are there, then it is invalid
        if (parts.length > 2) {
            return false;
        }

        String currentSegmentString = parts[0];
        String remaining = parts.length == 2 ? parts[1] : ""; // Remaining part after the first segment

        // Validate current segment
        if (!isValidSegment(currentSegmentString)) {
            return false;
        }

        // If remaining is not empty, then recursively call the function
        return addressCheck(remaining, segment + 1);
    }

    public static boolean isValidSegment(String segment) {
        // Check if the segment is empty or has leading zeros
        if (segment.isEmpty() || (segment.length() > 1 && segment.startsWith("0"))) {
            return false;
        }
        try {
            int value = Integer.parseInt(segment);
            return value >= 0 && value <= 255; // Check if the value is in the range 0-255
        } catch (NumberFormatException e) {
            System.err.println("Please enter a valid number.");
            return false; // Return false if parsing fails
        }
    }
}