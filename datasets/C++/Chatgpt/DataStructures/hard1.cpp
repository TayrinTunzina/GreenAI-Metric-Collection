#include <iostream>
#include <vector>
using namespace std;

long arrayManipulation(int n, vector<vector<int>>& queries) {
    vector<long> arr(n + 2, 0);  // Extra space to handle b+1 index

    // Apply difference array technique
    for (const auto& q : queries) {
        int a = q[0], b = q[1], k = q[2];
        arr[a] += k;
        arr[b + 1] -= k;
    }

    // Find the maximum value using prefix sum
    long max_value = 0, current_value = 0;
    for (int i = 1; i <= n; i++) {
        current_value += arr[i];
        max_value = max(max_value, current_value);
    }

    return max_value;
}

int main() {
    int n, m;
    cin >> n >> m;
    vector<vector<int>> queries(m, vector<int>(3));
    
    for (int i = 0; i < m; i++) {
        cin >> queries[i][0] >> queries[i][1] >> queries[i][2];
    }

    cout << arrayManipulation(n, queries) << endl;
    return 0;
}
