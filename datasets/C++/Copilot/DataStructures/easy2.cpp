#include <iostream>
#include <vector>
#include <limits>
using namespace std;

int hourglassSum(vector<vector<int>> arr) {
    int max_sum = numeric_limits<int>::min();
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
            int top = arr[i][j] + arr[i][j+1] + arr[i][j+2];
            int middle = arr[i+1][j+1];
            int bottom = arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
            int hourglass_sum = top + middle + bottom;
            if (hourglass_sum > max_sum) {
                max_sum = hourglass_sum;
            }
        }
    }
    return max_sum;
}

int main() {
    vector<vector<int>> arr(6, vector<int>(6));
    cout << "Enter the 6x6 matrix elements row by row:" << endl;
    for (int i = 0; i < 6; i++) {
        for (int j = 0; j < 6; j++) {
            cin >> arr[i][j];
        }
    }

    cout << hourglassSum(arr) << endl;
    return 0;
}
