#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int flippingMatrix(vector<vector<int>>& matrix, int n) {
    int maxSum = 0;
    int size = 2 * n;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            maxSum += max({
                matrix[i][j],
                matrix[i][size - j - 1],
                matrix[size - i - 1][j],
                matrix[size - i - 1][size - j - 1]
            });
        }
    }

    return maxSum;
}

int main() {
    int q;
    cout << "Enter number of queries: ";
    cin >> q;

    while (q--) {
        int n;
        cout << "Enter value of n: ";
        cin >> n;
        int size = 2 * n;
        vector<vector<int>> matrix(size, vector<int>(size));

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cin >> matrix[i][j];
            }
        }

        cout << flippingMatrix(matrix, n) << endl;
    }

    return 0;
}
