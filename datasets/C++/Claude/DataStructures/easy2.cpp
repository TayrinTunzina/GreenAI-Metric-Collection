#include <iostream>
using namespace std;

int maxHourglassSum() {
    int arr[6][6];
    
    // Input
    cout << "Enter the 6x6 matrix elements row by row:\n";
    for(int i = 0; i < 6; i++) {
        for(int j = 0; j < 6; j++) {
            cin >> arr[i][j];
        }
    }
    
    int maxSum = INT_MIN;
    
    // Calculate sum for each hourglass
    for(int i = 0; i < 4; i++) {
        for(int j = 0; j < 4; j++) {
            int currentSum = 
                // Top row
                arr[i][j] + arr[i][j+1] + arr[i][j+2] +
                // Middle
                arr[i+1][j+1] +
                // Bottom row
                arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2];
                
            maxSum = max(maxSum, currentSum);
        }
    }
    
    return maxSum;
}

int main() {
    cout << "Maximum hourglass sum: " << maxHourglassSum() << endl;
    return 0;
}
