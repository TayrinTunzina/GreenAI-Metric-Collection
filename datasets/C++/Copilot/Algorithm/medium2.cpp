#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int flippingMatrix(vector<vector<int>>& matrix) {
    int n = matrix.size() / 2;
    int max_sum = 0;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            max_sum += max({matrix[i][j], matrix[i][2 * n - j - 1], matrix[2 * n - i - 1][j], matrix[2 * n - i - 1][2 * n - j - 1]});
        }
    }
    return max_sum;
}

int main() {
    int q;
    cout << "Enter the number of queries: ";
    cin >> q;
    for (int k = 0; k < q; ++k) {
        int n;
        cin >> n;
        vector<vector<int>> matrix(2 * n, vector<int>(2 * n));
        for (int i = 0; i < 2 * n; ++i) {
            for (int j = 0; j < 2 * n; ++j) {
                cin >> matrix[i][j];
            }
        }
        cout << flippingMatrix(matrix) << endl;
    }
    return 0;
}
