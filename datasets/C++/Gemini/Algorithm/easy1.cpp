#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <set>

/**
 * @brief Calculates the length of the longest possible string of two alternating characters.
 * * @param s The input string.
 * @return int The length of the longest alternating string, or 0 if none can be formed.
 */
int alternate(std::string s) {
    // Use a set to get unique characters, then convert to a vector
    std::set<char> unique_char_set(s.begin(), s.end());
    std::vector<char> unique_chars(unique_char_set.begin(), unique_char_set.end());

    if (unique_chars.size() < 2) {
        return 0;
    }

    int max_len = 0;

    // Generate all unique pairs of characters
    for (size_t i = 0; i < unique_chars.size(); ++i) {
        for (size_t j = i + 1; j < unique_chars.size(); ++j) {
            char c1 = unique_chars[i];
            char c2 = unique_chars[j];

            std::string temp_s;
            // Build a temporary string containing only the characters from the current pair
            for (char ch : s) {
                if (ch == c1 || ch == c2) {
                    temp_s.push_back(ch);
                }
            }

            bool is_valid = true;
            // Check if the sequence is alternating
            if (temp_s.length() > 1) {
                for (size_t k = 0; k < temp_s.length() - 1; ++k) {
                    if (temp_s[k] == temp_s[k + 1]) {
                        is_valid = false;
                        break;
                    }
                }
            }

            // If the sequence is valid, update the maximum length
            if (is_valid) {
                max_len = std::max(max_len, static_cast<int>(temp_s.length()));
            }
        }
    }

    return max_len;
}

int main() {
    std::ios_base::sync_with_stdio(false);
    std::cin.tie(NULL);

    int l;
    std::cin >> l; // Read length
    std::string s;
    std::cin >> s; // Read string

    int result = alternate(s);
    std::cout << result << std::endl;

    return 0;
}