#include <iostream>
#include <vector>
#include <algorithm>

void matrixRotation(std::vector<std::vector<int>>& matrix, int m, int n, int r) {
    int num_layers = std::min(m, n) / 2;

    for (int i = 0; i < num_layers; ++i) {
        // Define boundaries for the current layer
        int top = i, bottom = m - 1 - i;
        int left = i, right = n - 1 - i;

        // A layer that is just a line has 0 perimeter, so skip
        if (left >= right || top >= bottom) {
            break;
        }

        // 1. Extract layer elements into a 1D vector (anti-clockwise)
        std::vector<int> layer_1d;
        // Move down the left column
        for (int row = top; row <= bottom; ++row) layer_1d.push_back(matrix[row][left]);
        // Move right across the bottom row
        for (int col = left + 1; col <= right; ++col) layer_1d.push_back(matrix[bottom][col]);
        // Move up the right column
        for (int row = bottom - 1; row >= top; --row) layer_1d.push_back(matrix[row][right]);
        // Move left across the top row
        for (int col = right - 1; col > left; --col) layer_1d.push_back(matrix[top][col]);
        
        // 2. Calculate effective rotations
        int perimeter = layer_1d.size();
        int effective_rotations = r % perimeter;

        // If no effective rotation needed, continue
        if (effective_rotations == 0) {
            continue;
        }

        // 3. Rotate the 1D vector. A right shift by k is a left shift by (size - k).
        // std::rotate performs a left shift.
        std::rotate(layer_1d.begin(), layer_1d.begin() + (perimeter - effective_rotations), layer_1d.end());
        
        // 4. Place rotated elements back into the matrix
        int idx = 0;
        // Move down the left column
        for (int row = top; row <= bottom; ++row) matrix[row][left] = layer_1d[idx++];
        // Move right across the bottom row
        for (int col = left + 1; col <= right; ++col) matrix[bottom][col] = layer_1d[idx++];
        // Move up the right column
        for (int row = bottom - 1; row >= top; --row) matrix[row][right] = layer_1d[idx++];
        // Move left across the top row
        for (int col = right - 1; col > left; --col) matrix[top][col] = layer_1d[idx++];
    }

    // Print the final matrix
    for (int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j) {
            std::cout << matrix[i][j] << (j == n - 1 ? "" : " ");
        }
        std::cout << std::endl;
    }
}

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);

    int m, n, r;
    std::cin >> m >> n >> r;

    std::vector<std::vector<int>> matrix(m, std::vector<int>(n));
    for (int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j) {
            std::cin >> matrix[i][j];
        }
    }

    matrixRotation(matrix, m, n, r);

    return 0;
}