import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatrixRotation {

    public static void matrixRotation(int[][] matrix, int m, int n, int r) {
        for (int layer = 0; layer < Math.min(m, n) / 2; layer++) {
            int firstRow = layer;
            int firstCol = layer;
            int lastRow = m - 1 - layer;
            int lastCol = n - 1 - layer;

            // Extract the elements of the current layer
            List<Integer> elements = new ArrayList<>();
            for (int i = firstCol; i <= lastCol; i++) {
                elements.add(matrix[firstRow][i]);
            }
            for (int i = firstRow + 1; i <= lastRow; i++) {
                elements.add(matrix[i][lastCol]);
            }
            for (int i = lastCol - 1; i >= firstCol; i--) {
                elements.add(matrix[lastRow][i]);
            }
            for (int i = lastRow - 1; i > firstRow; i--) {
                elements.add(matrix[i][firstCol]);
            }

            // Perform the rotation
            int length = elements.size();
            int rMod = r % length;
            List<Integer> rotatedElements = new ArrayList<>(elements.subList(rMod, length));
            rotatedElements.addAll(elements.subList(0, rMod));

            // Place the rotated elements back into the matrix
            int index = 0;
            for (int i = firstCol; i <= lastCol; i++) {
                matrix[firstRow][i] = rotatedElements.get(index++);
            }
            for (int i = firstRow + 1; i <= lastRow; i++) {
                matrix[i][lastCol] = rotatedElements.get(index++);
            }
            for (int i = lastCol - 1; i >= firstCol; i--) {
                matrix[lastRow][i] = rotatedElements.get(index++);
            }
            for (int i = lastRow - 1; i > firstRow; i--) {
                matrix[i][firstCol] = rotatedElements.get(index++);
            }
        }

        // Print the rotated matrix
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int r = scanner.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Perform matrix rotation
        matrixRotation(matrix, m, n, r);

        scanner.close();
    }
}
