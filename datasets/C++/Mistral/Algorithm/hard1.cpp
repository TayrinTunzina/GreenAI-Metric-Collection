#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

void matrixRotation(vector<vector<int>>& matrix, int m, int n, int r) {
    for (int layer = 0; layer < min(m, n) / 2; ++layer) {
        int firstRow = layer;
        int firstCol = layer;
        int lastRow = m - 1 - layer;
        int lastCol = n - 1 - layer;

        // Extract the elements of the current layer
        vector<int> elements;
        for (int i = firstCol; i <= lastCol; ++i) {
            elements.push_back(matrix[firstRow][i]);
        }
        for (int i = firstRow + 1; i <= lastRow; ++i) {
            elements.push_back(matrix[i][lastCol]);
        }
        for (int i = lastCol - 1; i >= firstCol; --i) {
            elements.push_back(matrix[lastRow][i]);
        }
        for (int i = lastRow - 1; i > firstRow; --i) {
            elements.push_back(matrix[i][firstCol]);
        }

        // Perform the rotation
        int length = elements.size();
        int rMod = r % length;
        rotate(elements.begin(), elements.begin() + rMod, elements.end());

        // Place the rotated elements back into the matrix
        int index = 0;
        for (int i = firstCol; i <= lastCol; ++i) {
            matrix[firstRow][i] = elements[index++];
        }
        for (int i = firstRow + 1; i <= lastRow; ++i) {
            matrix[i][lastCol] = elements[index++];
        }
        for (int i = lastCol - 1; i >= firstCol; --i) {
            matrix[lastRow][i] = elements[index++];
        }
        for (int i = lastRow - 1; i > firstRow; --i) {
            matrix[i][firstCol] = elements[index++];
        }
    }

    // Print the rotated matrix
    for (const auto& row : matrix) {
        for (int val : row) {
            cout << val << " ";
        }
        cout << endl;
    }
}

int main() {
    int m, n, r;
    cin >> m >> n >> r;
    vector<vector<int>> matrix(m, vector<int>(n));
    for (int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j) {
            cin >> matrix[i][j];
        }
    }

    // Perform matrix rotation
    matrixRotation(matrix, m, n, r);

    return 0;
}
