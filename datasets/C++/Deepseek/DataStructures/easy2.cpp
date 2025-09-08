#include <iostream>
#include <vector>
#include <climits>

using namespace std;

int maxHourglassSum(vector<vector<int>>& arr) {
    int max_sum = INT_MIN;  // Initialize with the smallest possible integer

    for (int i = 0; i < 4; i++) {  // Rows (0 to 3)
        for (int j = 0; j < 4; j++) {  // Columns (0 to 3)
            // Calculate the hourglass sum
            int hourglass_sum = (
                arr[i][j] + arr[i][j + 1] + arr[i][j + 2] +  // Top row
                arr[i + 1][j + 1] +  // Middle element
                arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2]  // Bottom row
            );
            // Update max_sum if the current hourglass sum is greater
            if (hourglass_sum > max_sum) {
                max_sum = hourglass_sum;
            }
        }
    }

    return max_sum;
}

int main() {
    vector<vector<int>> arr(6, vector<int>(6));
    cout << "Enter the 6x6 array:" << endl;
    for (int i = 0; i < 6; i++) {
        for (int j = 0; j < 6; j++) {
            cin >> arr[i][j];
        }
    }

    cout << "Maximum hourglass sum: " << maxHourglassSum(arr) << endl;

    return 0;
}