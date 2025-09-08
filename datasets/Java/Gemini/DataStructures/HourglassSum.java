import java.util.Scanner;

public class HourglassSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] arr = new int[6][6];

        // Read the 6x6 array from the user
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        // Calculate the maximum hourglass sum
        int maxHourglassSum = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int hourglassSum = arr[i][j] + arr[i][j+1] + arr[i][j+2]
                        + arr[i+1][j+1]
                        + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
                maxHourglassSum = Math.max(maxHourglassSum, hourglassSum);
            }
        }

        // Print the maximum hourglass sum
        System.out.println(maxHourglassSum);
    }
}
