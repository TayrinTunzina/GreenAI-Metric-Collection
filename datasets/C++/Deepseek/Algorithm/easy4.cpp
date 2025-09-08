#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

bool compareStrings(const string &a, const string &b) {
    if (a.length() != b.length()) {
        return a.length() < b.length();
    } else {
        return a < b;
    }
}

int main() {
    int n;
    cin >> n;
    vector<string> unsorted(n);
    for (int i = 0; i < n; i++) {
        cin >> unsorted[i];
    }
    sort(unsorted.begin(), unsorted.end(), compareStrings);
    for (const string &num : unsorted) {
        cout << num << endl;
    }
    return 0;
}