#include <iostream>
#include <set>
#include <string>
#include <algorithm>
#include <vector>
using namespace std;

bool isValid(const string &str) {
    for (int i = 0; i < str.size() - 1; ++i)
        if (str[i] == str[i + 1])
            return false;
    return true;
}

int alternate(string s) {
    set<char> chars(s.begin(), s.end());
    vector<char> unique(chars.begin(), chars.end());
    int maxLen = 0;

    for (int i = 0; i < unique.size(); ++i) {
        for (int j = i + 1; j < unique.size(); ++j) {
            string temp = "";
            for (char c : s)
                if (c == unique[i] || c == unique[j])
                    temp += c;
            if (isValid(temp))
                maxLen = max(maxLen, (int)temp.size());
        }
    }
    return maxLen;
}

int main() {
    int n;
    string s;
    cout << "Enter length of string: ";
    cin >> n;
    cout << "Enter the string: ";
    cin >> s;
    cout << "Longest length: " << alternate(s) << endl;
    return 0;
}
