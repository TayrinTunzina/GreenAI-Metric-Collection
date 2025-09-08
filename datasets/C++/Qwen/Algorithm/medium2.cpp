#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int flippingMatrix(vector<vector<int>> matrix) {
    int n = matrix.size() / 2;
    int maxSum = 0;

    // Iterate through each cell in the upper-left quadrant
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            // Find the maximum value among the four possible positions
            int maxVal = max({
                matrix[i][j],                           // Current position
                matrix[i][2 * n - j - 1],               // Column reverse
                matrix[2 * n - i - 1][j],               // Row reverse
                matrix[2 * n - i - 1][2 * n - j - 1]    // Both reversed
            });
            maxSum += maxVal;
        }
    }

    return maxSum;
}

int main() {
    int q;
    cout << "Enter the number of queries: ";
    cin >> q;

    vector<int> results;

    while (q--) {
        int n;
        cout << "Enter the value of n: ";
        cin >> n;

        vector<vector<int>> matrix(2 * n, vector<int>(2 * n));
        cout << "Enter the " << 2 * n << "x" << 2 * n << " matrix row by row:\n";
        for (int i = 0; i < 2 * n; ++i) {
            for (int j = 0; j < 2 * n; ++j) {
                cin >> matrix[i][j];
            }
        }

        int result = flippingMatrix(matrix);
        results.push_back(result);
    }

    cout << "\nResults:\n";
    for (int res : results) {
        cout << res << endl;
    }

    return 0;
}