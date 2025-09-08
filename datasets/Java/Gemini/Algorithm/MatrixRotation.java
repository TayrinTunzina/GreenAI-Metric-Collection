import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatrixRotation {

    public static void matrixRotation(List<List<Integer>> matrix, int m, int n, int r) {
        int numLayers = Math.min(m, n) / 2;

        for (int i = 0; i < numLayers; i++) {
            // Define boundaries for the current layer
            int top = i, bottom = m - 1 - i;
            int left = i, right = n - 1 - i;

            // A layer that is just a line has 0 perimeter, so skip
            if (left >= right || top >= bottom) {
                break;
            }
            
            // 1. Extract layer elements into a 1D list (anti-clockwise)
            List<Integer> layer1d = new ArrayList<>();
            // Move down the left column
            for (int row = top; row <= bottom; row++) layer1d.add(matrix.get(row).get(left));
            // Move right across the bottom row
            for (int col = left + 1; col <= right; col++) layer1d.add(matrix.get(bottom).get(col));
            // Move up the right column
            for (int row = bottom - 1; row >= top; row--) layer1d.add(matrix.get(row).get(right));
            // Move left across the top row
            for (int col = right - 1; col > left; col--) layer1d.add(matrix.get(top).get(col));

            // 2. Calculate effective rotations
            int perimeter = layer1d.size();
            int effectiveRotations = r % perimeter;
            
            // If no effective rotation needed, continue
            if (effectiveRotations == 0) {
                continue;
            }

            // 3. Rotate the 1D list. Collections.rotate performs a right shift.
            Collections.rotate(layer1d, effectiveRotations);

            // 4. Place rotated elements back into the matrix
            int idx = 0;
            // Move down the left column
            for (int row = top; row <= bottom; row++) matrix.get(row).set(left, layer1d.get(idx++));
            // Move right across the bottom row
            for (int col = left + 1; col <= right; col++) matrix.get(bottom).set(col, layer1d.get(idx++));
            // Move up the right column
            for (int row = bottom - 1; row >= top; row--) matrix.get(row).set(right, layer1d.get(idx++));
            // Move left across the top row
            for (int col = right - 1; col > left; col--) matrix.get(top).set(col, layer1d.get(idx++));
        }

        // Print the final matrix
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(matrix.get(i).get(j)).append(j == n - 1 ? "" : " ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int m = Integer.parseInt(firstMultipleInput[0]);
        int n = Integer.parseInt(firstMultipleInput[1]);
        int r = Integer.parseInt(firstMultipleInput[2]);

        List<List<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] matrixRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            List<Integer> matrixRowItems = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                matrixRowItems.add(Integer.parseInt(matrixRowTempItems[j]));
            }
            matrix.add(matrixRowItems);
        }

        matrixRotation(matrix, m, n, r);
        bufferedReader.close();
    }
}