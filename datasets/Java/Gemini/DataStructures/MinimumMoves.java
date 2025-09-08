import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays; // Import Arrays class
import java.util.List;

public class MinimumMoves {

    public static int minMoves(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[Math.max(j, i / j)]);
                }
            }

            if (dp[i] == Integer.MAX_VALUE) {
                dp[i] = dp[i - 1] + 1;
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            int n = scanner.nextInt();
            results.add(minMoves(n));
        }

        for (int result : results) {
            System.out.println(result);
        }
    }
}
