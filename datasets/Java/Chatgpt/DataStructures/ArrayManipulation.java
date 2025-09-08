import java.util.*;

public class ArrayManipulation {
    public static long arrayManipulation(int n, int[][] queries) {
        long[] arr = new long[n + 2]; // Extra space for b+1 index

        // Apply difference array technique
        for (int[] q : queries) {
            int a = q[0], b = q[1], k = q[2];
            arr[a] += k;
            arr[b + 1] -= k;
        }

        // Find the maximum value using prefix sum
        long max_value = 0, current_value = 0;
        for (int i = 1; i <= n; i++) {
            current_value += arr[i];
            max_value = Math.max(max_value, current_value);
        }

        return max_value;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
            queries[i][2] = sc.nextInt();
        }

        System.out.println(arrayManipulation(n, queries));
        sc.close();
    }
}
