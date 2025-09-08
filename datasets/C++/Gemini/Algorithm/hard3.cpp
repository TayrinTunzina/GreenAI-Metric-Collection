#include <iostream>
#include <string>

using namespace std;

int sumOfSimilarities(const string& s) {
    int n = s.size();
    int sumSimilarities = 0;

    for (int i = 0; i < n; ++i) { // Iterate through each suffix
        int j = 0;
        while (i + j < n && s[j] == s[i + j]) {
            j++;
        }
        sumSimilarities += j;
    }

    return sumSimilarities;
}

int main() {
    int t;
    cin >> t;
    for (int i = 0; i < t; i++) {
        string s;
        cin >> s;
        cout << sumOfSimilarities(s) << endl;
    }
    return 0;
}
