#include <iostream>
#include <vector>
#include <set>
#include <algorithm>
#include <string>

using namespace std;

int alternate(string s) {
    set<char> unique_chars(s.begin(), s.end());
    vector<char> chars(unique_chars.begin(), unique_chars.end());
    int max_length = 0;

    // Try all pairs of distinct characters
    for (int i = 0; i < chars.size(); ++i) {
        for (int j = i + 1; j < chars.size(); ++j) {
            char a = chars[i];
            char b = chars[j];
            string filtered = "";
            bool valid = true;

            for (char c : s) {
                if (c == a || c == b) {
                    filtered += c;
                }
            }

            // Check if alternating
            for (int k = 0; k < filtered.size() - 1; ++k) {
                if (filtered[k] == filtered[k+1]) {
                    valid = false;
                    break;
                }
            }

            if (valid && filtered.length() >= 2) {
                max_length = max(max_length, (int)filtered.length());
            }
        }
    }

    return max_length;
}

int main() {
    int n;
    string s;
    cin >> n;
    cin.ignore(); // ignore newline
    getline(cin, s);

    cout << alternate(s) << endl;
    return 0;
}