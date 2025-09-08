#include <iostream>
#include <vector>
#include <cmath> // for std::abs

using namespace std;

int diagonalDifference(vector<vector<int>> arr, int n) {
    int primaryDiagonalSum = 0;
    int secondaryDiagonalSum = 0;

    for (int i = 0; i < n; i++) {
        primaryDiagonalSum += arr[i][i];
        secondaryDiagonalSum += arr[i][n - i - 1];
    }

    return abs(primaryDiagonalSum - secondaryDiagonalSum);
}

int main() {
    int n;
    cout << "Enter the size of the square matrix: ";
    cin >> n;

    vector<vector<int>> arr(n, vector<int>(n));

    cout << "Enter the elements of the matrix: " << endl;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> arr[i][j];
        }
    }

    int result = diagonalDifference(arr, n);
    cout << "The absolute difference between the sums of the diagonals is: " << result << endl;

    return 0;
}
