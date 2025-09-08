import java.util.Scanner;

public class HourglassSum {
    // Function to calculate the maximum hourglass sum
    public static int maxHourglassSum(int[][] arr) {
        int maxSum = Integer.MIN_VALUE; // Initialize with minimum integer value
        for (int i = 0; i < 4; i++) { // Rows: 0 to 3
            for (int j = 0; j < 4; j++) { // Columns: 0 to 3
                // Calculate the hourglass sum
                int top = arr[i][j] + arr[i][j+1] + arr[i][j+2];
                int middle = arr[i+1][j+1];
                int bottom = arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
                int hourglassSum = top + middle + bottom;
                // Update maxSum if current hourglassSum is greater
                maxSum = Math.max(maxSum, hourglassSum);
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] arr = new int[6][6]; // 6x6 array
        System.out.println("Enter the 6x6 array row by row (space-separated integers):");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        // Calculate and print the maximum hourglass sum
        int result = maxHourglassSum(arr);
        System.out.println("Maximum Hourglass Sum: " + result);

        scanner.close();
    }
}