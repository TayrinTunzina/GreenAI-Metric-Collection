import java.util.Scanner;

public class ArrayManipulation {

    public static long arrayManipulation(int n, int[][] queries) {
        // Initialize a difference array with zeros
        long[] diff = new long[n + 2];

        // Process each query
        for (int[] query : queries) {
            int a = query[0];
            int b = query[1];
            int k = query[2];
            diff[a] += k;
            if (b + 1 <= n) {
                diff[b + 1] -= k;
            }
        }

        // Compute the prefix sum to get the final array
        long max_value = 0;
        long current = 0;
        for (int i = 1; i <= n; i++) {
            current += diff[i];
            if (current > max_value) {
                max_value = current;
            }
        }

        return max_value;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for n
        System.out.print("Enter the size of the array (n): ");
        int n = scanner.nextInt();

        // Input for the number of queries
        System.out.print("Enter the number of queries: ");
        int numQueries = scanner.nextInt();

        // Input for each query
        int[][] queries = new int[numQueries][3];
        for (int i = 0; i < numQueries; i++) {
            System.out.println("Enter query " + (i + 1) + " (a, b, k): ");
            System.out.print("Enter a: ");
            queries[i][0] = scanner.nextInt();
            System.out.print("Enter b: ");
            queries[i][1] = scanner.nextInt();
            System.out.print("Enter k: ");
            queries[i][2] = scanner.nextInt();
        }

        // Get the result
        long result = arrayManipulation(n, queries);
        System.out.println("Maximum value after all operations: " + result);

        // Close the scanner
        scanner.close();
    }
}