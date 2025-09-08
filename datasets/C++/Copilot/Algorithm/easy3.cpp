#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

int diagonalDifference(vector<vector<int>> arr) {
    int primary_diagonal_sum = 0;
    int secondary_diagonal_sum = 0;
    int n = arr.size();

    for (int i = 0; i < n; i++) {
        primary_diagonal_sum += arr[i][i];
        secondary_diagonal_sum += arr[i][n - 1 - i];
    }

    return abs(primary_diagonal_sum - secondary_diagonal_sum);
}

int main() {
    int n;
    cout << "Enter the number of rows and columns: ";
    cin >> n;
    vector<vector<int>> arr(n, vector<int>(n));
    cout << "Enter the matrix elements row by row:" << endl;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> arr[i][j];
        }
    }

    cout << diagonalDifference(arr) << endl;
    return 0;
}
