#include <iostream>
#include <set>
#include <string>
using namespace std;

bool isValid(const string &s) {
    for (size_t i = 1; i < s.size(); ++i) {
        if (s[i] == s[i - 1])
            return false;
    }
    return true;
}

int alternate(string s) {
    set<char> chars(s.begin(), s.end());
    int maxLen = 0;

    for (auto it1 = chars.begin(); it1 != chars.end(); ++it1) {
        auto it2 = it1;
        ++it2;
        for (; it2 != chars.end(); ++it2) {
            string temp = "";
            for (char c : s) {
                if (c == *it1 || c == *it2)
                    temp += c;
            }
            if (isValid(temp))
                maxLen = max(maxLen, (int)temp.length());
        }
    }
    return maxLen;
}

int main() {
    int n;
    string s;
    cout << "Enter string length: ";
    cin >> n;
    cout << "Enter the string: ";
    cin >> s;

    cout << "Longest alternating string length: " << alternate(s) << endl;
    return 0;
}
