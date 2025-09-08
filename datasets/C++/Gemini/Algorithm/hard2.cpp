#include <iostream>
#include <vector>
#include <cmath>
#include <numeric>
#include <algorithm>

/*
 * Calculates the minimum starting energy by working backward from the last building.
 */
int chiefHopper(const std::vector<int>& arr) {
    long required_energy = 0;
    
    // Iterate from the last building to the first
    for (int i = arr.size() - 1; i >= 0; --i) {
        // Using floating point math with ceil
        // required_energy = static_cast<long>(std::ceil((double)(required_energy + arr[i]) / 2.0));
        
        // Or using integer math, which is often preferred to avoid floating point inaccuracies
        required_energy = (required_energy + arr[i] + 1) / 2;
    }
    
    return static_cast<int>(required_energy);
}

int main() {
    int n;
    std::cin >> n;
    
    std::vector<int> arr(n);
    for (int i = 0; i < n; ++i) {
        std::cin >> arr[i];
    }
    
    int result = chiefHopper(arr);
    std::cout << result << std::endl;
    
    return 0;
}