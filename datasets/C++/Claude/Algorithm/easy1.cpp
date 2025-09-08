#include <iostream>
#include <string>
#include <set>
#include <vector>
#include <algorithm>
using namespace std;

bool isAlternating(const string& s, char char1, char char2) {
    // Filter string to contain only char1 and char2
    string filtered;
    for (char c : s) {
        if (c == char1 || c == char2) {
            filtered += c;
        }
    }
    
    if (filtered.length() < 2) {
        return true;
    }
    
    // Check if it alternates
    for (int i = 1; i < filtered.length(); i++) {
        if (filtered[i] == filtered[i-1]) {
            return false;
        }
    }
    
    return true;
}

int alternate(const string& s) {
    // Get all unique characters
    set<char> unique_set(s.begin(), s.end());
    vector<char> unique_chars(unique_set.begin(), unique_set.end());
    
    int max_length = 0;
    
    // Try all pairs of characters
    for (int i = 0; i < unique_chars.size(); i++) {
        for (int j = i + 1; j < unique_chars.size(); j++) {
            char char1 = unique_chars[i];
            char char2 = unique_chars[j];
            
            // Create string with only these two characters
            string filtered_string;
            for (char c : s) {
                if (c == char1 || c == char2) {
                    filtered_string += c;
                }
            }
            
            // Check if this filtered string alternates
            if (isAlternating(filtered_string, char1, char2)) {
                max_length = max(max_length, (int)filtered_string.length());
            }
        }
    }
    
    return max_length;
}

int main() {
    cout << "=== C++ Solution ===" << endl;
    
    // Take manual input
    int n;
    string s;
    cout << "Enter the length of string: ";
    cin >> n;
    cout << "Enter the string: ";
    cin >> s;
    
    int result = alternate(s);
    cout << "Length of longest alternating string: " << result << endl;
    
    return 0;
}