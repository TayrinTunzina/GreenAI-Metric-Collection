#include <iostream>
#include <vector>
#include <set>
#include <algorithm>

using namespace std;

int alternate(string s) {
    set<char> unique_chars(s.begin(), s.end());
    int max_len = 0;
    
    for (auto first = unique_chars.begin(); first != unique_chars.end(); ++first) {
        for (auto second = unique_chars.begin(); second != unique_chars.end(); ++second) {
            if (*first == *second) {
                continue;
            }
            vector<char> filtered;
            for (char c : s) {
                if (c == *first || c == *second) {
                    filtered.push_back(c);
                }
            }
            bool valid = true;
            for (int i = 0; i < (int)filtered.size() - 1; ++i) {
                if (filtered[i] == filtered[i + 1]) {
                    valid = false;
                    break;
                }
            }
            if (valid && filtered.size() > max_len) {
                max_len = filtered.size();
            }
        }
    }
    
    return max_len >= 2 ? max_len : 0;
}

int main() {
    int n;
    cin >> n;
    string s;
    cin >> s;
    
    cout << alternate(s) << endl;
    
    return 0;
}