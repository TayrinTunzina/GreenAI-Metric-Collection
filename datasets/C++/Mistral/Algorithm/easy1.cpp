#include <iostream>
#include <vector>
#include <unordered_set>
#include <algorithm>

using namespace std;

int alternate(const string &s) {
    unordered_set<char> chars(s.begin(), s.end());
    int max_length = 0;

    for (char char1 : chars) {
        for (char char2 : chars) {
            if (char1 == char2) continue;

            string filtered;
            for (char c : s) {
                if (c == char1 || c == char2) {
                    filtered += c;
                }
            }

            bool valid = true;
            for (size_t i = 0; i < filtered.size() - 1; ++i) {
                if (filtered[i] == filtered[i + 1]) {
                    valid = false;
                    break;
                }
            }

            if (valid && filtered.size() > max_length) {
                max_length = filtered.size();
            }
        }
    }

    return max_length;
}

int main() {
    int length;
    cout << "Enter the length of the string: ";
    cin >> length;
    string s;
    cout << "Enter the string: ";
    cin >> s;

    int result = alternate(s);
    cout << result << endl;

    return 0;
}
