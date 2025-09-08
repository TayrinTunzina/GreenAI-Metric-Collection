import java.util.Scanner;

public class HourglassSum {
    public static int hourglassSum(int[][] arr) {
        int max_sum = Integer.MIN_VALUE;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int top = arr[i][j] + arr[i][j+1] + arr[i][j+2];
                int middle = arr[i+1][j+1];
                int bottom = arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
                int hourglass_sum = top + middle + bottom;
                if (hourglass_sum > max_sum) {
                    max_sum = hourglass_sum;
                }
            }
        }
        return max_sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] arr = new int[6][6];
        System.out.println("Enter the 6x6 matrix elements row by row:");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        System.out.println(hourglassSum(arr));
        scanner.close();
    }
}
