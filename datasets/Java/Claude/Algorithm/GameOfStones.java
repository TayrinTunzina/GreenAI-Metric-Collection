import java.util.Scanner;

public class GameOfStones {
    
    public static String gameOfStones(int n) {
        // dp[i] = true if current player can win with i stones
        boolean[] dp = new boolean[n + 1];
        
        // Base cases: if we can make a move and opponent will be in losing position
        for (int i = 2; i <= n; i++) {
            // Try removing 2, 3, or 5 stones
            int[] moves = {2, 3, 5};
            for (int move : moves) {
                if (i >= move && !dp[i - move]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[n] ? "First" : "Second";
    }
    
    // Optimized pattern-based solution
    public static String gameOfStonesOptimized(int n) {
        return (n % 7 == 0 || n % 7 == 1) ? "Second" : "First";
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of test cases: ");
        int t = scanner.nextInt();
        
        System.out.println("Enter " + t + " test case(s), each containing the number of stones:");
        
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            
            // Use either the DP solution or optimized solution
            String result = gameOfStones(n);
            // String result = gameOfStonesOptimized(n);  // Uncomment for optimized version
            
            System.out.println(result);
        }
        
        scanner.close();
    }
}