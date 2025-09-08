#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

int diagonalDifference(vector<vector<int>> arr) {
    int n = arr.size();
    int primary_sum = 0, secondary_sum = 0;

    for (int i = 0; i < n; i++) {
        primary_sum += arr[i][i];  // Primary diagonal
        secondary_sum += arr[i][n - 1 - i];  // Secondary diagonal
    }

    return abs(primary_sum - secondary_sum);
}

int main() {
    int n;
    cout << "Enter the size of the matrix: ";
    cin >> n;

    vector<vector<int>> arr(n, vector<int>(n));
    cout << "Enter the matrix row by row:" << endl;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> arr[i][j];
        }
    }

    cout << "Absolute diagonal difference: " << diagonalDifference(arr) << endl;

    return 0;
}