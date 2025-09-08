import java.util.Scanner;

public class DiagonalDifference {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the size of the matrix
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];

        // Input the matrix elements
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        // Calculate the sums of the diagonals
        int primaryDiagonalSum = 0;
        int secondaryDiagonalSum = 0;
        for (int i = 0; i < n; i++) {
            primaryDiagonalSum += arr[i][i];            // Sum of primary diagonal
            secondaryDiagonalSum += arr[i][n - i - 1];  // Sum of secondary diagonal
        }

        // Calculate the absolute difference
        int difference = Math.abs(primaryDiagonalSum - secondaryDiagonalSum);

        // Output the result
        System.out.println(difference);
    }
}
