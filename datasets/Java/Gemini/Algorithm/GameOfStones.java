import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GameOfStones {

    public static String gameOfStones(int n) {
        // dp[i] will be true if the current player can win with i stones, false otherwise.
        // We need to consider up to n stones, so size n+1
        boolean[] dp = new boolean[n + 1];

        // Base cases
        // dp[0] = false (no stones, current player loses)
        // dp[1] = false (cannot remove 2, 3, or 5, current player loses)

        // Calculate dp states
        // Start from 2 because 0 and 1 are base cases handled by initialization
        for (int i = 2; i <= n; i++) {
            boolean canWin = false;

            // Try removing 2 stones
            if (i - 2 >= 0 && !dp[i - 2]) {
                canWin = true;
            }
            // Try removing 3 stones
            if (!canWin && i - 3 >= 0 && !dp[i - 3]) { // Only check if not already winning
                canWin = true;
            }
            // Try removing 5 stones
            if (!canWin && i - 5 >= 0 && !dp[i - 5]) { // Only check if not already winning
                canWin = true;
            }

            dp[i] = canWin;
        }

        // If dp[n] is true, First player wins. Otherwise, Second player wins.
        return dp[n] ? "First" : "Second";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the number of test cases (t):");
        int t = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> results = new ArrayList<>();
        for (int tItr = 0; tItr < t; tItr++) {
            System.out.println("Enter the number of stones for test case " + (tItr + 1) + ":");
            int n = Integer.parseInt(bufferedReader.readLine().trim());
            String winner = gameOfStones(n);
            results.add(winner);
        }

        System.out.println("\n--- Winners ---");
        for (String res : results) {
            System.out.println(res);
        }

        bufferedReader.close();
    }
}