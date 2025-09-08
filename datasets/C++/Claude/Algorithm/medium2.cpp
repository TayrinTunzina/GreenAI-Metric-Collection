#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int flippingMatrix(vector<vector<int>>& matrix) {
    int n = matrix.size() / 2;
    int total = 0;
    
    // For each element in the upper left quadrant
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            // Find max of all possible values that could be flipped to this position
            vector<int> possible_values = {
                matrix[i][j],               // Current position
                matrix[i][2*n-1-j],         // Same row, reflected column
                matrix[2*n-1-i][j],         // Reflected row, same column
                matrix[2*n-1-i][2*n-1-j]    // Reflected row and column
            };
            total += *max_element(possible_values.begin(), possible_values.end());
        }
    }
    
    return total;
}

int main() {
    int q;
    cin >> q;  // Number of queries
    
    while(q--) {
        int n;
        cin >> n;  // Size of matrix quadrant
        
        vector<vector<int>> matrix(2*n, vector<int>(2*n));
        for(int i = 0; i < 2*n; i++) {
            for(int j = 0; j < 2*n; j++) {
                cin >> matrix[i][j];
            }
        }
        
        cout << flippingMatrix(matrix) << endl;
    }
    
    return 0;
}
