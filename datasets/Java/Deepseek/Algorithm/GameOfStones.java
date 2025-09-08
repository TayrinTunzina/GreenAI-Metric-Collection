import java.util.Scanner;

public class GameOfStones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        boolean[] dp = new boolean[101];
        dp[0] = false;
        dp[1] = false;
        for (int i = 2; i <= 100; i++) {
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
        while (t-- > 0) {
            int n = scanner.nextInt();
            System.out.println(dp[n] ? "First" : "Second");
        }
        scanner.close();
    }
}