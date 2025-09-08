#include <iostream>
#include <vector>
#include <algorithm> // Include the algorithm header for std::max

using namespace std;

int flippingMatrix(vector<vector<int>>& matrix) {
    int n = matrix.size() / 2;
    int maxSum = 0;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            maxSum += std::max({ 
                matrix[i][j], 
                matrix[i][2 * n - j - 1], 
                matrix[2 * n - i - 1][j], 
                matrix[2 * n - i - 1][2 * n - j - 1] 
            }); 
        }
    }

    return maxSum;
}

int main() {
    int q;
    cout << "Enter the number of queries: ";
    cin >> q;

    for (int i = 0; i < q; i++) {
        int n;
        cout << "Enter the size of the matrix (n): ";
        cin >> n;
        vector<vector<int>> matrix(2 * n, vector<int>(2 * n));

        cout << "Enter the matrix elements row-wise:" << endl;
        for (int j = 0; j < 2 * n; j++) {
            for (int k = 0; k < 2 * n; k++) {
                cin >> matrix[j][k];
            }
        }

        int result = flippingMatrix(matrix);
        cout << "Maximum sum: " << result << endl;
    }

    return 0;
}
