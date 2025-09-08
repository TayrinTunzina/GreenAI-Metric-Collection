import java.util.Scanner;

public class DiagonalDifference {

    public static int diagonalDifference(int[][] arr) {
        int n = arr.length;
        int primarySum = 0, secondarySum = 0;

        for (int i = 0; i < n; i++) {
            primarySum += arr[i][i];  // Primary diagonal
            secondarySum += arr[i][n - 1 - i];  // Secondary diagonal
        }

        return Math.abs(primarySum - secondarySum);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the matrix: ");
        int n = scanner.nextInt();

        int[][] arr = new int[n][n];
        System.out.println("Enter the matrix row by row:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Absolute diagonal difference: " + diagonalDifference(arr));

        scanner.close();
    }
}