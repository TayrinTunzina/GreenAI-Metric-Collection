import java.util.*;

public class CommonChild {
    
    public static int commonChild(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        
        // Create DP table where dp[i][j] represents LCS length of s1[0:i] and s2[0:j]
        int[][] dp = new int[n + 1][m + 1];
        
        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    // Characters match, add 1 to diagonal value
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    // Characters don't match, take maximum from left or top
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        return dp[n][m];
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        
        int result = commonChild(s1, s2);
        System.out.println(result);
        
        scanner.close();
    }
}