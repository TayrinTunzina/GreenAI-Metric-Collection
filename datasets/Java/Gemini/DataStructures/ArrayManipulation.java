import java.util.*;

public class ArrayManipulation {

    public static long arrayManipulation(int n, int[][] queries) {
        long[] arr = new long[n + 1]; 

        for (int[] query : queries) {
            int a = query[0] - 1; // Adjust indices to 0-based
            int b = query[1] - 1;
            int k = query[2];
            arr[a] += k;
            if (b < n) {
                arr[b + 1] -= k; 
            }
        }

        long max_val = 0;
        long temp_sum = 0;
        for (long val : arr) {
            temp_sum += val;
            max_val = Math.max(max_val, temp_sum);
        }

        return max_val;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 3; j++) {
                queries[i][j] = scanner.nextInt();
            }
        }

        long result = arrayManipulation(n, queries);
        System.out.println(result);
    }
}