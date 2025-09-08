import java.util.Scanner;

public class MinimumMoves {
    public static int[] minMoves(int Q, int[] queries) {
        int maxN = 0;
        for (int n : queries) {
            if (n > maxN) {
                maxN = n;
            }
        }
        int[] dp = new int[maxN + 1];
        
        for (int i = 1; i <= maxN; i++) {
            dp[i] = dp[i - 1] + 1;  // Operation 2
            for (int a = 2; a <= Math.sqrt(i); a++) {
                if (i % a == 0) {
                    int b = i / a;
                    dp[i] = Math.min(dp[i], dp[Math.max(a, b)] + 1);
                }
            }
        }
        
        int[] results = new int[Q];
        for (int i = 0; i < Q; i++) {
            results[i] = dp[queries[i]];
        }
        return results;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of queries (Q): ");
        int Q = sc.nextInt();
        
        int[] queries = new int[Q];
        for (int i = 0; i < Q; i++) {
            System.out.print("Enter N for query " + (i + 1) + ": ");
            queries[i] = sc.nextInt();
        }
        
        int[] results = minMoves(Q, queries);
        
        System.out.println("Minimum moves required for each query:");
        for (int res : results) {
            System.out.println(res);
        }
    }
}