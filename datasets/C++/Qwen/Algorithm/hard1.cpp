#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

void matrixRotation(vector<vector<int>>& matrix, int r) {
    int m = matrix.size();
    int n = matrix[0].size();
    int num_rings = min(m, n) / 2;

    for (int ring = 0; ring < num_rings; ++ring) {
        int height = m - 2 * ring;
        int width = n - 2 * ring;
        int perimeter;

        if (height == 1 || width == 1) {
            perimeter = height * width;
        } else {
            perimeter = 2 * (height + width - 2);
        }

        int effective_r = r % perimeter;
        if (effective_r == 0) continue;

        vector<int> layer;
        // 1. Left column: top to bottom
        for (int i = ring; i < ring + height; ++i) {
            layer.push_back(matrix[i][ring]);
        }
        // 2. Bottom row: left to right (exclude corners)
        for (int j = ring + 1; j < ring + width - 1; ++j) {
            layer.push_back(matrix[ring + height - 1][j]);
        }
        // 3. Right column: bottom to top
        for (int i = ring + height - 1; i >= ring; --i) {
            layer.push_back(matrix[i][ring + width - 1]);
        }
        // 4. Top row: right to left (exclude corners)
        for (int j = ring + width - 2; j > ring; --j) {
            layer.push_back(matrix[ring][j]);
        }

        // To simulate anti-clockwise rotation by 'effective_r', we do:
        // equivalent to left rotation by effective_r => right rotate by (perimeter - effective_r)
        int shift = perimeter - effective_r;
        rotate(layer.begin(), layer.begin() + shift, layer.end());

        // Put back into matrix
        int idx = 0;
        // Left column
        for (int i = ring; i < ring + height; ++i) {
            matrix[i][ring] = layer[idx++];
        }
        // Bottom row
        for (int j = ring + 1; j < ring + width - 1; ++j) {
            matrix[ring + height - 1][j] = layer[idx++];
        }
        // Right column
        for (int i = ring + height - 1; i >= ring; --i) {
            matrix[i][ring + width - 1] = layer[idx++];
        }
        // Top row
        for (int j = ring + width - 2; j > ring; --j) {
            matrix[ring][j] = layer[idx++];
        }
    }

    // Print the result
    for (int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j) {
            cout << matrix[i][j];
            if (j < n - 1) cout << " ";
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

    matrixRotation(matrix, r);
    return 0;
}