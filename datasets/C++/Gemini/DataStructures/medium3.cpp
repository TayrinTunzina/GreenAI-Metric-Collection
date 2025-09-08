#include <iostream>
#include <vector>
#include <cmath>
#include <climits> // Include climits header for INT_MAX

using namespace std;

int minMoves(int n) {
    vector<int> dp(n + 1, INT_MAX); 

    dp[0] = 0;
    dp[1] = 1;

    for (int i = 2; i <= n; i++) {
        for (int j = 2; j <= sqrt(i); j++) {
            if (i % j == 0) {
                dp[i] = min(dp[i], 1 + dp[max(j, i / j)]);
            }
        }

        if (dp[i] == INT_MAX) { 
            dp[i] = dp[i - 1] + 1;
        }
    }

    return dp[n];
}

int main() {
    int q;
    cin >> q;
    vector<int> results;

    for (int i = 0; i < q; i++) {
        int n;
        cin >> n;
        results.push_back(minMoves(n)); 
    }

    for (int result : results) {
        cout << result << endl;
    }

    return 0;
}
