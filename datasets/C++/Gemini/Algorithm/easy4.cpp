#include <iostream>
#include <vector>
#include <string>
#include <algorithm> // Required for std::sort

// Custom comparison function for sorting large numbers as strings
bool compareBigNumbers(const std::string& s1, const std::string& s2) {
    // 1. Compare by length first
    if (s1.length() != s2.length()) {
        return s1.length() < s2.length(); // Shorter string comes first
    } else {
        // 2. If lengths are same, compare lexicographically
        // (which is equivalent to numerical comparison for same-length numbers)
        return s1 < s2; // Standard string comparison
    }
}

int main() {
    // Optimize C++ I/O for competitive programming
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);

    // Manual Input:
    std::cout << "Enter the number of strings (n):" << std::endl;
    int n;
    std::cin >> n;

    std::vector<std::string> unsorted(n);
    for (int i = 0; i < n; ++i) {
        std::cout << "Enter string " << (i + 1) << ":" << std::endl;
        std::cin >> unsorted[i];
    }

    // For competitive programming, typically input is just read without prompts:
    /*
    int n;
    std::cin >> n;
    std::vector<std::string> unsorted(n);
    for (int i = 0; i < n; ++i) {
        std::cin >> unsorted[i];
    }
    */

    // Sort the vector using the custom comparison function
    std::sort(unsorted.begin(), unsorted.end(), compareBigNumbers);

    std::cout << "\n--- Sorted Array ---" << std::endl;
    for (const std::string& s : unsorted) {
        std::cout << s << std::endl;
    }

    return 0;
}