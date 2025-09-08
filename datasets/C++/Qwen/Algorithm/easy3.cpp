#include <iostream>
#include <cmath> // For abs()

using namespace std;

int main() {
    // Input size of the square matrix
    int n;
    cout << "Enter the size of the square matrix (n): ";
    cin >> n;

    // Initialize the matrix
    int arr[n][n];

    // Input matrix elements
    cout << "Enter the elements of the matrix row by row:" << endl;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> arr[i][j];
        }
    }

    // Calculate diagonal sums
    int primaryDiagonalSum = 0, secondaryDiagonalSum = 0;
    for (int i = 0; i < n; i++) {
        primaryDiagonalSum += arr[i][i]; // Primary diagonal: arr[i][i]
        secondaryDiagonalSum += arr[i][n - 1 - i]; // Secondary diagonal: arr[i][n-1-i]
    }

    // Calculate absolute difference
    int difference = abs(primaryDiagonalSum - secondaryDiagonalSum);

    // Output the result
    cout << "The absolute difference between the sums of the diagonals is: " << difference << endl;

    return 0;
}