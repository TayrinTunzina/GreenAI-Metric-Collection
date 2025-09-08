import java.util.*;

public class MatrixRotation {
    public static void matrixRotation(List<List<Integer>> matrix, int m, int n, int r) {
        int layers = Math.min(m, n) / 2;
        for (int layer = 0; layer < layers; layer++) {
            int perimeter = 2 * (m + n - 4 * layer - 2);
            int rotations = r % perimeter;
            for (int k = 0; k < rotations; k++) {
                int top = layer;
                int left = layer;
                int right = n - 1 - layer;
                int bottom = m - 1 - layer;
                
                int temp = matrix.get(top).get(left);
                
                // Move top row left
                for (int j = left; j < right; j++)
                    matrix.get(top).set(j, matrix.get(top).get(j + 1));
                
                // Move right column up
                for (int i = top; i < bottom; i++)
                    matrix.get(i).set(right, matrix.get(i + 1).get(right));
                
                // Move bottom row right
                for (int j = right; j > left; j--)
                    matrix.get(bottom).set(j, matrix.get(bottom).get(j - 1));
                
                // Move left column down
                for (int i = bottom; i > top; i--)
                    matrix.get(i).set(left, matrix.get(i - 1).get(left));
                
                matrix.get(top + 1).set(left, temp);
            }
        }
        
        for (List<Integer> row : matrix) {
            for (int num : row)
                System.out.print(num + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int r = scanner.nextInt();
        List<List<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++)
                row.add(scanner.nextInt());
            matrix.add(row);
        }
        matrixRotation(matrix, m, n, r);
        scanner.close();
    }
}