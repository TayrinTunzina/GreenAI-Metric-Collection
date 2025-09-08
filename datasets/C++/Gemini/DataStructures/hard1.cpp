#include <iostream>
#include <vector>

using namespace std;

long long arrayManipulation(int n, vector<vector<int>>& queries) {
    vector<long long> arr(n + 1, 0);

    for (auto& query : queries) {
        int a = query[0] - 1; // Adjust indices to 0-based
        int b = query[1] - 1;
        int k = query[2];
        arr[a] += k;
        if (b < n) {
            arr[b + 1] -= k;
        }
    }

    long long max_val = 0;
    long long temp_sum = 0;
    for (long long val : arr) {
        temp_sum += val;
        max_val = max(max_val, temp_sum);
    }

    return max_val;
}

int main() {
    int n, m;
    cin >> n >> m;
    vector<vector<int>> queries(m, vector<int>(3));

    for (int i = 0; i < m; ++i) {
        for (int j = 0; j < 3; ++j) {
            cin >> queries[i][j];
        }
    }

    long long result = arrayManipulation(n, queries);
    cout << result << endl;
    return 0;
}