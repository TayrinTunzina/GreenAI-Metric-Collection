#include <iostream>
#include <cmath>
#include <algorithm>

int min_moves_to_zero(int N) {
    if (N == 0) return 0;
    if (N <= 3) return N;
    int max_factor = static_cast<int>(sqrt(N));
    for (int i = 2; i <= max_factor; ++i) {
        if (N % i == 0) {
            return 1 + std::min(min_moves_to_zero(N / i), min_moves_to_zero(i));
        }
    }
    return N;
}

int main() {
    int Q;
    std::cout << "Enter the number of queries: ";
    std::cin >> Q;
    int results[Q];
    for (int i = 0; i < Q; ++i) {
        int N;
        std::cout << "Enter the value of N: ";
        std::cin >> N;
        results[i] = min_moves_to_zero(N);
    }
    for (int i = 0; i < Q; ++i) {
        std::cout << results[i] << std::endl;
    }
    return 0;
}
