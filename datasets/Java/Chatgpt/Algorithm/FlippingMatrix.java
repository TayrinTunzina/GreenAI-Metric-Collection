import java.util.Scanner;

public class FlippingMatrix {
    public static int flippingMatrix(int[][] matrix, int n) {
        int maxSum = 0;
        int size = 2 * n;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maxSum += Math.max(
                        Math.max(matrix[i][j], matrix[i][size - j - 1]),
                        Math.max(matrix[size - i - 1][j], matrix[size - i - 1][size - j - 1])
                );
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of queries: ");
        int q = scanner.nextInt();

        for (int t = 0; t < q; t++) {
            System.out.print("Enter value of n: ");
            int n = scanner.nextInt();
            int size = 2 * n;
            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            System.out.println(flippingMatrix(matrix, n));
        }

        scanner.close();
    }
}
