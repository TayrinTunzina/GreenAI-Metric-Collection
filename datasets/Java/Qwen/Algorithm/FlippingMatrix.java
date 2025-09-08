import java.util.Scanner;

public class FlippingMatrix {

    public static int flippingMatrix(int[][] matrix) {
        int n = matrix.length / 2;
        int maxSum = 0;

        // Iterate through each cell in the upper-left quadrant
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Find the maximum value among the four possible positions
                int maxVal = Math.max(
                    Math.max(matrix[i][j], matrix[i][2 * n - j - 1]), // Current and column reverse
                    Math.max(matrix[2 * n - i - 1][j], matrix[2 * n - i - 1][2 * n - j - 1]) // Row and both reverse
                );
                maxSum += maxVal;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of queries: ");
        int q = scanner.nextInt();
        int[] results = new int[q];

        for (int t = 0; t < q; t++) {
            System.out.print("Enter the value of n: ");
            int n = scanner.nextInt();

            int[][] matrix = new int[2 * n][2 * n];
            System.out.println("Enter the " + (2 * n) + "x" + (2 * n) + " matrix row by row:");
            for (int i = 0; i < 2 * n; i++) {
                for (int j = 0; j < 2 * n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            results[t] = flippingMatrix(matrix);
        }

        System.out.println("\nResults:");
        for (int res : results) {
            System.out.println(res);
        }

        scanner.close();
    }
}