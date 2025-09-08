import java.util.Scanner;

public class ArrayManipulation {
    public static long arrayManipulation(int n, int[][] queries) {
        // Step 1: Initialize the difference array
        long[] diff = new long[n + 2];
        
        // Step 2: Process all queries
        for (int[] query : queries) {
            int a = query[0], b = query[1], k = query[2];
            diff[a] += k;
            if (b + 1 <= n) {
                diff[b + 1] -= k;
            }
        }
        
        // Step 3: Compute prefix sums and find the maximum value
        long max_value = 0, current_sum = 0;
        for (int i = 1; i <= n; ++i) {
            current_sum += diff[i];
            max_value = Math.max(max_value, current_sum);
        }
        
        return max_value;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input handling
        System.out.print("Enter the size of the array (n) and number of operations (m): ");
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        
        int[][] queries = new int[m][3];
        System.out.println("Enter the queries (each line as 'a b k'):");
        for (int i = 0; i < m; ++i) {
            queries[i][0] = scanner.nextInt();
            queries[i][1] = scanner.nextInt();
            queries[i][2] = scanner.nextInt();
        }
        
        // Call the function and print the result
        long result = arrayManipulation(n, queries);
        System.out.println("The maximum value in the array is: " + result);
        
        scanner.close();
    }
}