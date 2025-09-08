import java.util.*;

public class FlippingMatrix {
    public static int flippingMatrix(List<List<Integer>> matrix) {
        int n = matrix.size() / 2;
        int total = 0;
        
        // For each element in the upper left quadrant
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                // Find max of all possible values that could be flipped to this position
                List<Integer> possible_values = Arrays.asList(
                    matrix.get(i).get(j),                    // Current position
                    matrix.get(i).get(2*n-1-j),              // Same row, reflected column
                    matrix.get(2*n-1-i).get(j),              // Reflected row, same column
                    matrix.get(2*n-1-i).get(2*n-1-j)         // Reflected row and column
                );
                total += Collections.max(possible_values);
            }
        }
        
        return total;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();  // Number of queries
        
        for(int query = 0; query < q; query++) {
            int n = scanner.nextInt();  // Size of matrix quadrant
            List<List<Integer>> matrix = new ArrayList<>();
            
            for(int i = 0; i < 2*n; i++) {
                List<Integer> row = new ArrayList<>();
                for(int j = 0; j < 2*n; j++) {
                    row.add(scanner.nextInt());
                }
                matrix.add(row);
            }
            
            System.out.println(flippingMatrix(matrix));
        }
        
        scanner.close();
    }
}