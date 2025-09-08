import java.util.Scanner;

public class MinimumMoves {
    public static int[] preprocessDP(int maxN) {
        int[] dp = new int[maxN + 1];
        for (int i = 0; i <= maxN; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;  // Base case

        for (int i = 1; i <= maxN; i++) {
            // Option 1: Decrease by 1
            dp[i] = dp[i - 1] + 1;

            // Option 2: Factorize i into a and b
            for (int a = 2; a <= Math.sqrt(i); a++) {
                if (i % a == 0) {  // a is a divisor of i
                    int b = i / a;
                    dp[i] = Math.min(dp[i], dp[Math.max(a, b)] + 1);
                }
            }
        }

        return dp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of queries: ");
        int Q = scanner.nextInt();

        int[] queries = new int[Q];
        int maxN = 0;
        for (int i = 0; i < Q; i++) {
            System.out.print("Enter a number: ");
            queries[i] = scanner.nextInt();
            maxN = Math.max(maxN, queries[i]);
        }

        // Preprocess DP array
        int[] dp = preprocessDP(maxN);

        // Answer queries
        for (int i = 0; i < Q; i++) {
            System.out.println(dp[queries[i]]);
        }

        scanner.close();
    }
}