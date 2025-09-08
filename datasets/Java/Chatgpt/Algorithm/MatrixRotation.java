import java.util.*;

public class MatrixRotation {
    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        int m = matrix.size();
        int n = matrix.get(0).size();
        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {
            List<Integer> elements = new ArrayList<>();

            for (int i = layer; i < n - layer; i++)
                elements.add(matrix.get(layer).get(i));
            for (int i = layer + 1; i < m - layer - 1; i++)
                elements.add(matrix.get(i).get(n - layer - 1));
            for (int i = n - layer - 1; i >= layer; i--)
                elements.add(matrix.get(m - layer - 1).get(i));
            for (int i = m - layer - 2; i > layer; i--)
                elements.add(matrix.get(i).get(layer));

            int len = elements.size();
            int rot = r % len;
            List<Integer> rotated = new ArrayList<>();
            for (int i = 0; i < len; i++)
                rotated.add(elements.get((i + rot) % len));

            int idx = 0;
            for (int i = layer; i < n - layer; i++)
                matrix.get(layer).set(i, rotated.get(idx++));
            for (int i = layer + 1; i < m - layer - 1; i++)
                matrix.get(i).set(n - layer - 1, rotated.get(idx++));
            for (int i = n - layer - 1; i >= layer; i--)
                matrix.get(m - layer - 1).set(i, rotated.get(idx++));
            for (int i = m - layer - 2; i > layer; i--)
                matrix.get(i).set(layer, rotated.get(idx++));
        }

        for (List<Integer> row : matrix) {
            for (int val : row)
                System.out.print(val + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt(), r = sc.nextInt();
        List<List<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++)
                row.add(sc.nextInt());
            matrix.add(row);
        }
        matrixRotation(matrix, r);
    }
}
