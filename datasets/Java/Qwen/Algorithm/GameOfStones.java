import java.util.*;

public class GameOfStones {
    public static String gameOfStones(int n) {
        // dp[i] represents whether the current player can win with i stones
        if (n <= 1) {
            return "Second";
        }
        
        boolean[] dp = new boolean[n + 1];
        
        // Fill dp array
        for (int i = 2; i <= n; i++) {
            // Check if we can make a move that leads to opponent's loss
            if (i >= 2 && !dp[i - 2]) {  // Take 2 stones
                dp[i] = true;
            } else if (i >= 3 && !dp[i - 3]) {  // Take 3 stones
                dp[i] = true;
            } else if (i >= 5 && !dp[i - 5]) {  // Take 5 stones
                dp[i] = true;
            }
            // If none of the above, dp[i] remains false
        }
        
        return dp[n] ? "First" : "Second";
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            System.out.println(gameOfStones(n));
        }
        
        scanner.close();
    }
}