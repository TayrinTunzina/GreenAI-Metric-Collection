import java.util.Scanner;

public class FlippingMatrix {

    public static int flippingMatrix(int[][] matrix, int n) {
        int maxSum = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                maxSum += Math.max(Math.max(matrix[i][j], matrix[i][2 * n - 1 - j]),
                                   Math.max(matrix[2 * n - 1 - i][j], matrix[2 * n - 1 - i][2 * n - 1 - j]));
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of queries: ");
        int q = scanner.nextInt();
        int[] results = new int[q];

        for (int t = 0; t < q; ++t) {
            System.out.print("Enter the value of n for query " + (t + 1) + ": ");
            int n = scanner.nextInt();
            int[][] matrix = new int[2 * n][2 * n];
            System.out.println("Enter the " + (2 * n) + " x " + (2 * n) + " matrix for query " + (t + 1) + ":");
            for (int i = 0; i < 2 * n; ++i) {
                for (int j = 0; j < 2 * n; ++j) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            results[t] = flippingMatrix(matrix, n);
        }

        System.out.println("Results:");
        for (int result : results) {
            System.out.println(result);
        }

        scanner.close();
    }
}
