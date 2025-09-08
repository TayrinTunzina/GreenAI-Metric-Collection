import java.util.Scanner;

public class FlippingMatrix {

    public static int flippingMatrix(int[][] matrix) {
        int n = matrix.length / 2;
        int maxSum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxSum += Math.max(
                        Math.max(matrix[i][j], matrix[i][2 * n - j - 1]),
                        Math.max(matrix[2 * n - i - 1][j], matrix[2 * n - i - 1][2 * n - j - 1])
                );
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of queries: ");
        int q = scanner.nextInt();

        for (int i = 0; i < q; i++) {
            System.out.print("Enter the size of the matrix (n): ");
            int n = scanner.nextInt();
            int[][] matrix = new int[2 * n][2 * n];

            System.out.println("Enter the matrix elements row-wise:");
            for (int j = 0; j < 2 * n; j++) {
                for (int k = 0; k < 2 * n; k++) {
                    matrix[j][k] = scanner.nextInt();
                }
            }

            int result = flippingMatrix(matrix);
            System.out.println("Maximum sum: " + result);
        }
    }
}
