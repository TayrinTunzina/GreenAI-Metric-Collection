import java.util.Scanner;

public class GameOfStones {

    public static String gameOfStones(int n) {
        boolean[] dp = new boolean[n + 1];

        // Base case
        dp[0] = false;

        // Fill the dp array
        for (int i = 1; i <= n; i++) {
            if (i >= 2 && !dp[i - 2]) {
                dp[i] = true;
            } else if (i >= 3 && !dp[i - 3]) {
                dp[i] = true;
            } else if (i >= 5 && !dp[i - 5]) {
                dp[i] = true;
            } else {
                dp[i] = false;
            }
        }

        return dp[n] ? "First" : "Second";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of test cases: ");
        int t = scanner.nextInt();

        for (int i = 0; i < t; i++) {
            System.out.print("Enter the number of stones: ");
            int n = scanner.nextInt();
            System.out.println(gameOfStones(n));
        }
    }
}
