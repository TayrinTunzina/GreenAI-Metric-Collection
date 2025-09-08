#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

// Preprocess DP array
vector<int> preprocess_dp(int max_n) {
    vector<int> dp(max_n + 1, 1e9);
    dp[0] = 0;  // Base case

    for (int i = 1; i <= max_n; ++i) {
        // Option 1: Decrease by 1
        dp[i] = dp[i - 1] + 1;

        // Option 2: Factorize i into a and b
        for (int a = 2; a <= sqrt(i); ++a) {
            if (i % a == 0) {  // a is a divisor of i
                int b = i / a;
                dp[i] = min(dp[i], dp[max(a, b)] + 1);
            }
        }
    }

    return dp;
}

int main() {
    int Q;
    cout << "Enter the number of queries: ";
    cin >> Q;

    vector<int> queries(Q);
    int max_n = 0;
    for (int i = 0; i < Q; ++i) {
        cout << "Enter a number: ";
        cin >> queries[i];
        max_n = max(max_n, queries[i]);
    }

    // Preprocess DP array
    vector<int> dp = preprocess_dp(max_n);

    // Answer queries
    for (int i = 0; i < Q; ++i) {
        cout << dp[queries[i]] << endl;
    }

    return 0;
}