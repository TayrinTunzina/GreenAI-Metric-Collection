#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

void matrixRotation(vector<vector<int>>& matrix, int r) {
    int m = matrix.size();
    int n = matrix[0].size();
    int rings = min(m, n) / 2;
    
    for (int ring = 0; ring < rings; ring++) {
        vector<int> elements;
        
        // Extract ring elements
        // Top row (left to right)
        for (int j = ring; j < n - ring; j++) {
            elements.push_back(matrix[ring][j]);
        }
        
        // Right column (top to bottom, excluding corners)
        for (int i = ring + 1; i < m - ring; i++) {
            elements.push_back(matrix[i][n - ring - 1]);
        }
        
        // Bottom row (right to left, excluding corner if not single row)
        if (m - ring - 1 > ring) {
            for (int j = n - ring - 2; j >= ring; j--) {
                elements.push_back(matrix[m - ring - 1][j]);
            }
        }
        
        // Left column (bottom to top, excluding corners if not single column)
        if (n - ring - 1 > ring) {
            for (int i = m - ring - 2; i > ring; i--) {
                elements.push_back(matrix[i][ring]);
            }
        }
        
        // Calculate effective rotations
        int ringSize = elements.size();
        if (ringSize == 0) continue;
        
        int effectiveR = r % ringSize;
        
        // Create rotated array
        vector<int> rotated(ringSize);
        for (int i = 0; i < ringSize; i++) {
            rotated[i] = elements[(i + effectiveR) % ringSize];
        }
        
        // Place back rotated elements
        int idx = 0;
        
        // Top row
        for (int j = ring; j < n - ring; j++) {
            matrix[ring][j] = rotated[idx++];
        }
        
        // Right column
        for (int i = ring + 1; i < m - ring; i++) {
            matrix[i][n - ring - 1] = rotated[idx++];
        }
        
        // Bottom row
        if (m - ring - 1 > ring) {
            for (int j = n - ring - 2; j >= ring; j--) {
                matrix[m - ring - 1][j] = rotated[idx++];
            }
        }
        
        // Left column
        if (n - ring - 1 > ring) {
            for (int i = m - ring - 2; i > ring; i--) {
                matrix[i][ring] = rotated[idx++];
            }
        }
    }
    
    // Print the result
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            cout << matrix[i][j];
            if (j < n - 1) cout << " ";
        }
        cout << endl;
    }
}

int main() {
    // Read input
    int m, n, r;
    cin >> m >> n >> r;
    
    vector<vector<int>> matrix(m, vector<int>(n));
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            cin >> matrix[i][j];
        }
    }
    
    // Solve and print result
    matrixRotation(matrix, r);
    
    return 0;
}