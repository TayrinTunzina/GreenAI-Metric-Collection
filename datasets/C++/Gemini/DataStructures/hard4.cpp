#include <iostream>
#include <vector>
#include <stack>
#include <algorithm>

// Calculates max XOR using a monotonic stack
long long calculate_max_xor(const std::vector<int>& nums) {
    std::stack<int> s;
    long long max_val = 0;
    for (int num : nums) {
        while (!s.empty() && s.top() > num) {
            // Current 'num' is the next smaller element for s.top()
            max_val = std::max(max_val, (long long)s.top() ^ num);
            s.pop();
        }
        s.push(num);
    }
    return max_val;
}

int main() {
    int n;
    std::cout << "Enter the number of elements (N): ";
    std::cin >> n;
    
    if (std::cin.fail() || n <= 1) {
        std::cerr << "Invalid input for N. It must be an integer greater than 1." << std::endl;
        return 1;
    }
    
    std::vector<int> arr(n);
    std::cout << "Enter " << n << " space-separated integers for the array A[]: ";
    for (int i = 0; i < n; ++i) {
        std::cin >> arr[i];
         if (std::cin.fail()) {
            std::cerr << "Invalid input for array element." << std::endl;
            return 1;
        }
    }

    // Pass 1: Left to right (finds max XOR with next smaller elements)
    long long max1 = calculate_max_xor(arr);

    // Pass 2: Right to left (finds max XOR with previous smaller elements)
    std::reverse(arr.begin(), arr.end());
    long long max2 = calculate_max_xor(arr);

    std::cout << "\nMaximum possible value of Si: " << std::max(max1, max2) << std::endl;
    
    return 0;
}