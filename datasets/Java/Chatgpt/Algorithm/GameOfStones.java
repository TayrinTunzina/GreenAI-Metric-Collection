import java.util.*;

public class GameOfStones {
    static String gameOfStones(int n) {
        boolean[] dp = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i >= 2 && !dp[i - 2]) dp[i] = true;
            else if (i >= 3 && !dp[i - 3]) dp[i] = true;
            else if (i >= 5 && !dp[i - 5]) dp[i] = true;
        }
        return dp[n] ? "First" : "Second";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of test cases: ");
        int t = sc.nextInt();
        while (t-- > 0) {
            System.out.print("Enter number of stones: ");
            int n = sc.nextInt();
            System.out.println(gameOfStones(n));
        }
    }
}
