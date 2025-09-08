#include <iostream>
#include <vector>

using namespace std;

int diagonalDifference(vector<vector<int>> arr) {
    int n = arr.size();
    int leftDiagonalSum = 0, rightDiagonalSum = 0;

    for (int i = 0; i < n; i++) {
        leftDiagonalSum += arr[i][i];
        rightDiagonalSum += arr[i][n - i - 1];
    }

    return abs(leftDiagonalSum - rightDiagonalSum);
}

int main() {
    int n;
    cin >> n;

    vector<vector<int>> arr(n, vector<int>(n));
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> arr[i][j];
        }
    }

    int result = diagonalDifference(arr);
    cout << result << endl;

    return 0;
}
