#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

int commonChild(const std::string& s1, const std::string& s2) {
    int n = s1.length();

    // Space-optimized DP using two vectors.
    // prev_dp stores the DP values for row i-1.
    // current_dp stores the DP values for the current row i.
    std::vector<int> prev_dp(n + 1, 0);
    std::vector<int> current_dp(n + 1, 0);

    for (int i = 1; i <= n; ++i) {
        for (int j = 1; j <= n; ++j) {
            if (s1[i - 1] == s2[j - 1]) {
                // If characters match, add 1 to the diagonal predecessor.
                current_dp[j] = prev_dp[j - 1] + 1;
            } else {
                // Otherwise, take the max of the top or left cell.
                current_dp[j] = std::max(prev_dp[j], current_dp[j - 1]);
            }
        }
        // Update the previous row for the next iteration.
        prev_dp = current_dp;
    }

    return prev_dp[n];
}

int main() {
    std::string s1, s2;
    std::cin >> s1 >> s2;
    int result = commonChild(s1, s2);
    std::cout << result << std::endl;
    return 0;
}