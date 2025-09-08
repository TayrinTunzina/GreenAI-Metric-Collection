#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int flippingMatrix(vector<vector<int>>& matrix, int n) {
    int max_sum = 0;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            max_sum += max({matrix[i][j], matrix[i][2*n-1-j], matrix[2*n-1-i][j], matrix[2*n-1-i][2*n-1-j]});
        }
    }
    return max_sum;
}

int main() {
    int q;
    cout << "Enter the number of queries: ";
    cin >> q;
    vector<int> results;

    for (int t = 0; t < q; ++t) {
        int n;
        cout << "Enter the value of n for query " << t + 1 << ": ";
        cin >> n;
        vector<vector<int>> matrix(2 * n, vector<int>(2 * n));
        cout << "Enter the " << 2 * n << " x " << 2 * n << " matrix for query " << t + 1 << ":" << endl;
        for (int i = 0; i < 2 * n; ++i) {
            for (int j = 0; j < 2 * n; ++j) {
                cin >> matrix[i][j];
            }
        }
        results.push_back(flippingMatrix(matrix, n));
    }

    cout << "Results:" << endl;
    for (int result : results) {
        cout << result << endl;
    }

    return 0;
}
