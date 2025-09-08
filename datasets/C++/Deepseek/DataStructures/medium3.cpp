#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

vector<int> min_moves(int Q, vector<int>& queries) {
    int max_N = *max_element(queries.begin(), queries.end());
    vector<int> dp(max_N + 1, 0);
    
    for (int i = 1; i <= max_N; ++i) {
        dp[i] = dp[i - 1] + 1;  // Operation 2
        for (int a = 2; a <= sqrt(i); ++a) {
            if (i % a == 0) {
                int b = i / a;
                dp[i] = min(dp[i], dp[max(a, b)] + 1);
            }
        }
    }
    
    vector<int> results;
    for (int n : queries) {
        results.push_back(dp[n]);
    }
    return results;
}

int main() {
    int Q;
    cout << "Enter the number of queries (Q): ";
    cin >> Q;
    
    vector<int> queries(Q);
    for (int i = 0; i < Q; ++i) {
        cout << "Enter N for query " << i + 1 << ": ";
        cin >> queries[i];
    }
    
    vector<int> results = min_moves(Q, queries);
    
    cout << "Minimum moves required for each query:" << endl;
    for (int res : results) {
        cout << res << endl;
    }
    
    return 0;
}