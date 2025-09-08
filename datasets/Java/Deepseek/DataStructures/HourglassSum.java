import java.util.Scanner;

public class HourglassSum {

    public static int maxHourglassSum(int[][] arr) {
        int maxSum = Integer.MIN_VALUE;  // Initialize with the smallest possible integer

        for (int i = 0; i < 4; i++) {  // Rows (0 to 3)
            for (int j = 0; j < 4; j++) {  // Columns (0 to 3)
                // Calculate the hourglass sum
                int hourglassSum = (
                    arr[i][j] + arr[i][j + 1] + arr[i][j + 2] +  // Top row
                    arr[i + 1][j + 1] +  // Middle element
                    arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2]  // Bottom row
                );
                // Update maxSum if the current hourglass sum is greater
                if (hourglassSum > maxSum) {
                    maxSum = hourglassSum;
                }
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] arr = new int[6][6];

        System.out.println("Enter the 6x6 array:");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Maximum hourglass sum: " + maxHourglassSum(arr));

        scanner.close();
    }
}