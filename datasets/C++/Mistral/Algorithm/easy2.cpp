#include <iostream>
#include <string>

int repeatedString(const std::string& s, int n) {
    int count_a_in_s = 0;
    for (char c : s) {
        if (c == 'a') {
            count_a_in_s++;
        }
    }
    int full_repeats = n / s.length();
    int remaining = n % s.length();
    int count_a_in_remaining = 0;
    for (int i = 0; i < remaining; i++) {
        if (s[i] == 'a') {
            count_a_in_remaining++;
        }
    }
    int total_count = full_repeats * count_a_in_s + count_a_in_remaining;
    return total_count;
}

int main() {
    std::string s;
    int n;
    std::cout << "Enter the string s: ";
    std::cin >> s;
    std::cout << "Enter the integer n: ";
    std::cin >> n;

    int result = repeatedString(s, n);
    std::cout << "The number of 'a's in the first " << n << " letters of the infinite string is: " << result << std::endl;
    return 0;
}
