#include <iostream>
#include <vector>
#include <string>
#include <algorithm> // For std::min, std::max (though not strictly needed for this logic)

std::string gameOfStones(int n) {
    // dp[i] will be true if the current player can win with i stones, false otherwise.
    // We need to consider up to n stones, so size n+1
    std::vector<bool> dp(n + 1, false);

    // Base cases
    // dp[0] = false (no stones, current player loses)
    // dp[1] = false (cannot remove 2, 3, or 5, current player loses)

    // Calculate dp states
    // Start from 2 because 0 and 1 are base cases handled by initialization
    for (int i = 2; i <= n; ++i) {
        bool canWin = false;

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

int main() {
    std::ios_base::sync_with_stdio(false); // Optimize C++ I/O
    std::cin.tie(NULL);                   // Untie cin from cout

    std::cout << "Enter the number of test cases (t):" << std::endl;
    int t;
    std::cin >> t;

    for (int t_itr = 0; t_itr < t; ++t_itr) {
        std::cout << "Enter the number of stones for test case " << (t_itr + 1) << ":" << std::endl;
        int n;
        std::cin >> n;
        std::string winner = gameOfStones(n);
        std::cout << winner << std::endl;
    }

    return 0;
}