#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int flippingMatrix(vector<vector<int>> matrix) {
    int n = matrix.size() / 2;
    int max_sum = 0;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            // Find the maximum value among the four symmetric positions
            int max_val = max({matrix[i][j], matrix[i][2*n-1-j], matrix[2*n-1-i][j], matrix[2*n-1-i][2*n-1-j]});
            max_sum += max_val;
        }
    }
    return max_sum;
}

int main() {
    int q;
    cout << "Enter the number of queries: ";
    cin >> q;
    while (q--) {
        int n;
        cout << "Enter the value of n: ";
        cin >> n;
        vector<vector<int>> matrix(2*n, vector<int>(2*n));
        for (int i = 0; i < 2*n; ++i) {
            for (int j = 0; j < 2*n; ++j) {
                cin >> matrix[i][j];
            }
        }
        cout << "Maximum sum: " << flippingMatrix(matrix) << endl;
    }
    return 0;
}