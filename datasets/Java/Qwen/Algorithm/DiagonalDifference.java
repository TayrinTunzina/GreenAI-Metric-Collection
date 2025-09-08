import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input size of the square matrix
        System.out.print("Enter the size of the square matrix (n): ");
        int n = scanner.nextInt();

        // Initialize the matrix
        int[][] arr = new int[n][n];

        // Input matrix elements
        System.out.println("Enter the elements of the matrix row by row:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        // Calculate diagonal sums
        int primaryDiagonalSum = 0, secondaryDiagonalSum = 0;
        for (int i = 0; i < n; i++) {
            primaryDiagonalSum += arr[i][i]; // Primary diagonal: arr[i][i]
            secondaryDiagonalSum += arr[i][n - 1 - i]; // Secondary diagonal: arr[i][n-1-i]
        }

        // Calculate absolute difference
        int difference = Math.abs(primaryDiagonalSum - secondaryDiagonalSum);

        // Output the result
        System.out.println("The absolute difference between the sums of the diagonals is: " + difference);
    }
}