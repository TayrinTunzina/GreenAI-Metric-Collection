#include <iostream>
#include <cstdlib>
using namespace std;

int diagonalDifference(int** arr, int n) {
    int primary_diagonal = 0;
    int secondary_diagonal = 0;
    
    for(int i = 0; i < n; i++) {
        primary_diagonal += arr[i][i];
        secondary_diagonal += arr[i][n-1-i];
    }
    
    return abs(primary_diagonal - secondary_diagonal);
}

int main() {
    int n;
    cout << "Enter the size of square matrix: ";
    cin >> n;
    
    // Dynamically allocate 2D array
    int** arr = new int*[n];
    for(int i = 0; i < n; i++) {
        arr[i] = new int[n];
    }
    
    cout << "Enter the matrix elements row by row:\n";
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n; j++) {
            cin >> arr[i][j];
        }
    }
    
    int result = diagonalDifference(arr, n);
    cout << "Absolute diagonal difference: " << result << endl;
    
    // Free allocated memory
    for(int i = 0; i < n; i++) {
        delete[] arr[i];
    }
    delete[] arr;
    
    return 0;
}