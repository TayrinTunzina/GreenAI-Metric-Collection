#include <iostream>
#include <string>
#include <cstdint>

using namespace std;

int64_t repeatedString(string s, int64_t n) {
    // Base case for empty string
    if (s.empty()) {
        return 0;
    }
    
    // Count 'a' in the original string
    int64_t count_in_full_string = 0;
    for (char c : s) {
        if (c == 'a') {
            count_in_full_string++;
        }
    }
    
    // Calculate number of complete strings
    int64_t complete_strings = n / s.length();
    
    // Calculate remaining characters
    int64_t remaining_chars = n % s.length();
    
    // Count 'a' in the remaining part
    int64_t count_in_remaining = 0;
    for (int64_t i = 0; i < remaining_chars; i++) {
        if (s[i] == 'a') {
            count_in_remaining++;
        }
    }
    
    // Calculate total count
    return (count_in_full_string * complete_strings) + count_in_remaining;
}

bool isLowerCase(const string& s) {
    for (char c : s) {
        if (c < 'a' || c > 'z') {
            return false;
        }
    }
    return true;
}

int main() {
    string s;
    int64_t n;
    
    // Get string input
    cout << "Enter the string: ";
    getline(cin, s);
    
    // Validate string
    if (s.empty() || s.length() > 100) {
        cout << "Error: String length must be between 1 and 100" << endl;
        return 1;
    }
    
    if (!isLowerCase(s)) {
        cout << "Error: String must contain only lowercase letters" << endl;
        return 1;
    }
    
    // Get n input
    cout << "Enter n: ";
    if (!(cin >> n)) {
        cout << "Error: Invalid number" << endl;
        return 1;
    }
    
    // Validate n
    if (n < 1 || n > 1e12) {
        cout << "Error: n must be between 1 and 10^12" << endl;
        return 1;
    }
    
    // Calculate and print result
    int64_t result = repeatedString(s, n);
    cout << "Result: " << result << endl;
    
    return 0;
}