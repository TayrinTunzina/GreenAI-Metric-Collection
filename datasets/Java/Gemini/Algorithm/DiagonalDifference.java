import java.util.Scanner;

public class DiagonalDifference {
    public static int diagonalDifference(int[][] arr) {
        int n = arr.length;
        int leftDiagonalSum = 0, rightDiagonalSum = 0;

        for (int i = 0; i < n; i++) {
            leftDiagonalSum += arr[i][i];
            rightDiagonalSum += arr[i][n - i - 1];
        }

        return Math.abs(leftDiagonalSum - rightDiagonalSum);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        int result = diagonalDifference(arr);
        System.out.println(result);
    }
}
