import java.util.*;

public class MatrixRotation {
    public static void matrixRotation(int[][] matrix, int r) {
        int m = matrix.length, n = matrix[0].length;
        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {
            List<Integer> elements = new ArrayList<>();
            for (int i = layer; i < n - layer; i++) elements.add(matrix[layer][i]);
            for (int i = layer + 1; i < m - layer; i++) elements.add(matrix[i][n - layer - 1]);
            for (int i = n - layer - 2; i >= layer; i--) elements.add(matrix[m - layer - 1][i]);
            for (int i = m - layer - 2; i > layer; i--) elements.add(matrix[i][layer]);

            int rot = r % elements.size();
            List<Integer> rotated = new ArrayList<>();
            rotated.addAll(elements.subList(rot, elements.size()));
            rotated.addAll(elements.subList(0, rot));

            int idx = 0;
            for (int i = layer; i < n - layer; i++) matrix[layer][i] = rotated.get(idx++);
            for (int i = layer + 1; i < m - layer; i++) matrix[i][n - layer - 1] = rotated.get(idx++);
            for (int i = n - layer - 2; i >= layer; i--) matrix[m - layer - 1][i] = rotated.get(idx++);
            for (int i = m - layer - 2; i > layer; i--) matrix[i][layer] = rotated.get(idx++);
        }

        for (int[] row : matrix) {
            for (int val : row) System.out.print(val + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt(), r = sc.nextInt();
        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();

        matrixRotation(matrix, r);
        sc.close();
    }
}
