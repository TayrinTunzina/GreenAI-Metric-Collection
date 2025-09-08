import java.util.*;

public class MatrixRotation {
    
    public static void matrixRotation(int[][] matrix, int r) {
        int m = matrix.length;
        int n = matrix[0].length;
        int rings = Math.min(m, n) / 2;
        
        for (int ring = 0; ring < rings; ring++) {
            List<Integer> elements = new ArrayList<>();
            
            // Extract ring elements
            // Top row (left to right)
            for (int j = ring; j < n - ring; j++) {
                elements.add(matrix[ring][j]);
            }
            
            // Right column (top to bottom, excluding corners)
            for (int i = ring + 1; i < m - ring; i++) {
                elements.add(matrix[i][n - ring - 1]);
            }
            
            // Bottom row (right to left, excluding corner if not single row)
            if (m - ring - 1 > ring) {
                for (int j = n - ring - 2; j >= ring; j--) {
                    elements.add(matrix[m - ring - 1][j]);
                }
            }
            
            // Left column (bottom to top, excluding corners if not single column)
            if (n - ring - 1 > ring) {
                for (int i = m - ring - 2; i > ring; i--) {
                    elements.add(matrix[i][ring]);
                }
            }
            
            // Calculate effective rotations
            int ringSize = elements.size();
            if (ringSize == 0) continue;
            
            int effectiveR = r % ringSize;
            
            // Create rotated list
            List<Integer> rotated = new ArrayList<>();
            for (int i = effectiveR; i < ringSize; i++) {
                rotated.add(elements.get(i));
            }
            for (int i = 0; i < effectiveR; i++) {
                rotated.add(elements.get(i));
            }
            
            // Place back rotated elements
            int idx = 0;
            
            // Top row
            for (int j = ring; j < n - ring; j++) {
                matrix[ring][j] = rotated.get(idx++);
            }
            
            // Right column
            for (int i = ring + 1; i < m - ring; i++) {
                matrix[i][n - ring - 1] = rotated.get(idx++);
            }
            
            // Bottom row
            if (m - ring - 1 > ring) {
                for (int j = n - ring - 2; j >= ring; j--) {
                    matrix[m - ring - 1][j] = rotated.get(idx++);
                }
            }
            
            // Left column
            if (n - ring - 1 > ring) {
                for (int i = m - ring - 2; i > ring; i--) {
                    matrix[i][ring] = rotated.get(idx++);
                }
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
        Scanner sc = new Scanner(System.in);
        
        // Read input
        int m = sc.nextInt();
        int n = sc.nextInt();
        int r = sc.nextInt();
        
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        
        // Solve and print result
        matrixRotation(matrix, r);
        
        sc.close();
    }
}