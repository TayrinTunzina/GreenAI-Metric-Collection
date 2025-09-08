#include <iostream>
#include <vector>
#include <cmath>

int diagonalDifference(const std::vector<std::vector<int>>& arr) {
    int n = arr.size();
    int primary_diagonal_sum = 0;
    int secondary_diagonal_sum = 0;

    for (int i = 0; i < n; ++i) {
        primary_diagonal_sum += arr[i][i];
        secondary_diagonal_sum += arr[i][n - i - 1];
    }

    return std::abs(primary_diagonal_sum - secondary_diagonal_sum);
}

int main() {
    int n;
    std::cout << "Enter the size of the square matrix: ";
    std::cin >> n;

    std::vector<std::vector<int>> arr(n, std::vector<int>(n));
    std::cout << "Enter the elements of the matrix row by row:" << std::endl;
    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            std::cin >> arr[i][j];
        }
    }

    int result = diagonalDifference(arr);
    std::cout << "The absolute difference between the sums of the diagonals is: " << result << std::endl;

    return 0;
}
