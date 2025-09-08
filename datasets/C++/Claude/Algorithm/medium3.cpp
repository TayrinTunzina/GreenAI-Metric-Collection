#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int commonChild(string s1, string s2) {
    int n = s1.length();
    int m = s2.length();
    
    // Create DP table where dp[i][j] represents LCS length of s1[0:i] and s2[0:j]
    vector<vector<int>> dp(n + 1, vector<int>(m + 1, 0));
    
    // Fill the DP table
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            if (s1[i-1] == s2[j-1]) {
                // Characters match, add 1 to diagonal value
                dp[i][j] = dp[i-1][j-1] + 1;
            } else {
                // Characters don't match, take maximum from left or top
                dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
            }
        }
    }
    
    return dp[n][m];
}

int main() {
    string s1, s2;
    cin >> s1 >> s2;
    
    int result = commonChild(s1, s2);
    cout << result << endl;
    
    return 0;
}