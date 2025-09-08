import java.util.Scanner;

public class FlippingMatrix {

    public static int flippingMatrix(int[][] matrix) {
        int n = matrix.length / 2;
        int maxSum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Find the maximum value among the four symmetric positions
                int maxVal = Math.max(Math.max(matrix[i][j], matrix[i][2*n-1-j]),
                                      Math.max(matrix[2*n-1-i][j], matrix[2*n-1-i][2*n-1-j]));
                maxSum += maxVal;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of queries: ");
        int q = scanner.nextInt();
        while (q-- > 0) {
            System.out.print("Enter the value of n: ");
            int n = scanner.nextInt();
            int[][] matrix = new int[2*n][2*n];
            for (int i = 0; i < 2*n; i++) {
                for (int j = 0; j < 2*n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            System.out.println("Maximum sum: " + flippingMatrix(matrix));
        }
        scanner.close();
    }
}