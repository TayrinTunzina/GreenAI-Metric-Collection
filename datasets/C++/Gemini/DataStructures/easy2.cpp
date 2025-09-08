#include <iostream>
#include <climits>

using namespace std;

int main() {
    int arr[6][6];

    // Get input from the user
    cout << "Enter the elements of the 6x6 array:\n";
    for (int i = 0; i < 6; i++) {
        for (int j = 0; j < 6; j++) {
            cin >> arr[i][j];
        }
    }

    // Calculate hourglass sums and find the maximum
    int maxHourglassSum = INT_MIN;
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
            int hourglassSum = arr[i][j] + arr[i][j+1] + arr[i][j+2] +
                                arr[i+1][j+1] +
                                arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
            maxHourglassSum = max(maxHourglassSum, hourglassSum);
        }
    }

    cout << "Maximum hourglass sum: " << maxHourglassSum << endl;

    return 0;
}
