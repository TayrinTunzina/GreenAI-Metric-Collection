#include <iostream>
#include <vector>
using namespace std;

void matrixRotation(vector<vector<int>>& matrix, int m, int n, int r) {
    int layers = min(m, n) / 2;
    for (int layer = 0; layer < layers; ++layer) {
        int perimeter = 2 * (m + n - 4 * layer - 2);
        int rotations = r % perimeter;
        for (int k = 0; k < rotations; ++k) {
            int top = layer;
            int left = layer;
            int right = n - 1 - layer;
            int bottom = m - 1 - layer;
            
            int temp = matrix[top][left];
            
            // Move top row left
            for (int j = left; j < right; ++j)
                matrix[top][j] = matrix[top][j + 1];
            
            // Move right column up
            for (int i = top; i < bottom; ++i)
                matrix[i][right] = matrix[i + 1][right];
            
            // Move bottom row right
            for (int j = right; j > left; --j)
                matrix[bottom][j] = matrix[bottom][j - 1];
            
            // Move left column down
            for (int i = bottom; i > top; --i)
                matrix[i][left] = matrix[i - 1][left];
            
            matrix[top + 1][left] = temp;
        }
    }
    
    for (const auto &row : matrix) {
        for (int num : row)
            cout << num << " ";
        cout << endl;
    }
}

int main() {
    int m, n, r;
    cin >> m >> n >> r;
    vector<vector<int>> matrix(m, vector<int>(n));
    for (int i = 0; i < m; ++i)
        for (int j = 0; j < n; ++j)
            cin >> matrix[i][j];
    matrixRotation(matrix, m, n, r);
    return 0;
}