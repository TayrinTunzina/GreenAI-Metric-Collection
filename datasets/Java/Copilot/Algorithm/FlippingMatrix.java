import java.util.Scanner;

public class FlippingMatrix {
    public static int flippingMatrix(int[][] matrix) {
        int n = matrix.length / 2;
        int max_sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max_sum += Math.max(matrix[i][j], Math.max(matrix[i][2 * n - j - 1], Math.max(matrix[2 * n - i - 1][j], matrix[2 * n - i - 1][2 * n - j - 1])));
            }
        }
        return max_sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of queries: ");
        int q = scanner.nextInt();
        for (int k = 0; k < q; k++) {
            int n = scanner.nextInt();
            int[][] matrix = new int[2 * n][2 * n];
            for (int i = 0; i < 2 * n; i++) {
                for (int j = 0; j < 2 * n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            System.out.println(flippingMatrix(matrix));
        }
        scanner.close();
    }
}
