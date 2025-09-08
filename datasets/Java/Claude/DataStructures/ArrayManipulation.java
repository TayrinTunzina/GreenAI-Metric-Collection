import java.util.Scanner;

public class ArrayManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt user and get input for n (array size) and m (number of operations)
        System.out.print("Enter the size of the array (n) and number of operations (m): ");
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        
        // Create a difference array with size n+2 (to handle 1-indexing)
        long[] diff = new long[n + 2];
        
        // Process m operations
        System.out.println("Enter " + m + " operations (a b k):");
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int k = scanner.nextInt();
            
            // Update the difference array
            diff[a] += k;         // Add k at the start index
            diff[b + 1] -= k;     // Subtract k at the index after the end
        }
        
        // Compute prefix sum and track maximum value
        long maxVal = 0;
        long prefixSum = 0;
        
        for (int i = 1; i <= n; i++) {
            prefixSum += diff[i];
            maxVal = Math.max(maxVal, prefixSum);
        }
        
        // Output the result
        System.out.println("Maximum value after all operations: " + maxVal);
        
        scanner.close();
    }
}