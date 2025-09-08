#include <iostream>
#include <vector>
#include <limits.h> // For INT_MIN

using namespace std;

int main() {
    // Define the 6x6 2D array
    int arr[6][6];
    
    // Taking input for the 6x6 array from the user
    cout << "Enter the elements of the 6x6 array: " << endl;
    for (int i = 0; i < 6; i++) {
        for (int j = 0; j < 6; j++) {
            cin >> arr[i][j];
        }
    }

    int max_sum = INT_MIN; // Initialize the maximum sum to the smallest integer value
    
    // Iterate over each possible hourglass starting point
    for (int i = 0; i <= 3; i++) { // i ranges from 0 to 3
        for (int j = 0; j <= 3; j++) { // j ranges from 0 to 3
            // Calculate the sum of the current hourglass
            int sum = arr[i][j] + arr[i][j+1] + arr[i][j+2]  // top row
                        + arr[i+1][j+1]  // middle element
                        + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2]; // bottom row
            
            // Update max_sum if the current hourglass sum is greater
            if (sum > max_sum) {
                max_sum = sum;
            }
        }
    }
    
    // Print the maximum hourglass sum
    cout << "The maximum hourglass sum is: " << max_sum << endl;

    return 0;
}
