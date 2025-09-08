import java.util.*;

public class MatrixRotation {

    public static void matrixRotation(int[][] matrix, int r) {
        int m = matrix.length;
        int n = matrix[0].length;
        int numRings = Math.min(m, n) / 2;

        // Temporary list to store each ring's elements
        List<Integer> layer = new ArrayList<>();

        for (int ring = 0; ring < numRings; ring++) {
            int height = m - 2 * ring;
            int width = n - 2 * ring;

            int perimeter;
            if (height == 1 || width == 1) {
                perimeter = height * width;
            } else {
                perimeter = 2 * (height + width - 2);
            }

            int effectiveR = r % perimeter;
            if (effectiveR == 0) {
                continue;
            }

            layer.clear();

            // 1. Left column: top to bottom
            for (int i = ring; i < ring + height; i++) {
                layer.add(matrix[i][ring]);
            }
            // 2. Bottom row: left to right (excluding corners)
            for (int j = ring + 1; j < ring + width - 1; j++) {
                layer.add(matrix[ring + height - 1][j]);
            }
            // 3. Right column: bottom to top
            for (int i = ring + height - 1; i >= ring; i--) {
                layer.add(matrix[i][ring + width - 1]);
            }
            // 4. Top row: right to left (excluding corners)
            for (int j = ring + width - 2; j > ring; j--) {
                layer.add(matrix[ring][j]);
            }

            // Clockwise rotation: right rotate by effectiveR
            int shift = perimeter - effectiveR;
            List<Integer> rotatedLayer = new ArrayList<>();
            rotatedLayer.addAll(layer.subList(shift, layer.size()));
            rotatedLayer.addAll(layer.subList(0, shift));

            // Put back into matrix
            int idx = 0;

            // Left column
            for (int i = ring; i < ring + height; i++) {
                matrix[i][ring] = rotatedLayer.get(idx++);
            }
            // Bottom row
            for (int j = ring + 1; j < ring + width - 1; j++) {
                matrix[ring + height - 1][j] = rotatedLayer.get(idx++);
            }
            // Right column
            for (int i = ring + height - 1; i >= ring; i--) {
                matrix[i][ring + width - 1] = rotatedLayer.get(idx++);
            }
            // Top row
            for (int j = ring + width - 2; j > ring; j--) {
                matrix[ring][j] = rotatedLayer.get(idx++);
            }
        }

        // Print the result
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
                if (j < n - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstLine = scanner.nextLine().split(" ");
        int m = Integer.parseInt(firstLine[0]);
        int n = Integer.parseInt(firstLine[1]);
        int r = Integer.parseInt(firstLine[2]);

        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            String[] row = scanner.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(row[j]);
            }
        }

        matrixRotation(matrix, r);
        scanner.close();
    }
}