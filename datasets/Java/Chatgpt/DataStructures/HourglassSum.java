import java.util.Scanner;

public class HourglassSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] arr = new int[6][6];

        System.out.println("Enter the elements of the 6x6 array:");

        // Input for the 6x6 array
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        int maxHourglassSum = Integer.MIN_VALUE;

        // Loop through the 16 possible hourglasses
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                // Calculate the sum of the current hourglass
                int currentHourglassSum =
                        arr[i][j] + arr[i][j + 1] + arr[i][j + 2] +
                                arr[i + 1][j + 1] +
                                arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];

                // Update maxHourglassSum if the current sum is greater
                if (currentHourglassSum > maxHourglassSum) {
                    maxHourglassSum = currentHourglassSum;
                }
            }
        }

        // Output the maximum hourglass sum
        System.out.println("Maximum hourglass sum: " + maxHourglassSum);

        scanner.close();
    }
}
