import java.util.Scanner;

public class DiagonalDifference {
    public static int diagonalDifference(int[][] arr) {
        int primary_diagonal_sum = 0;
        int secondary_diagonal_sum = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            primary_diagonal_sum += arr[i][i];
            secondary_diagonal_sum += arr[i][n - 1 - i];
        }

        return Math.abs(primary_diagonal_sum - secondary_diagonal_sum);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows and columns: ");
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];
        System.out.println("Enter the matrix elements row by row:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }

        System.out.println(diagonalDifference(arr));
        scanner.close();
    }
}
