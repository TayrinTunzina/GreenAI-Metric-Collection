import java.util.Scanner;

public class HourglassSum {

    public static int hourglassSum(int[][] arr) {
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                int currentSum = arr[i][j] + arr[i][j+1] + arr[i][j+2] +
                                 arr[i+1][j+1] +
                                 arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] arr = new int[6][6];

        // Manually input the 6x6 array
        System.out.println("Enter the elements of the 6x6 array:");
        for (int i = 0; i < 6; ++i) {
            for (int j = 0; j < 6; ++j) {
                arr[i][j] = scanner.nextInt();
            }
        }

        System.out.println("The maximum hourglass sum is: " + hourglassSum(arr));
        scanner.close();
    }
}
