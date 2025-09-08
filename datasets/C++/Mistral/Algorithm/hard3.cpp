#include <iostream>
#include <string>
#include <vector>

using namespace std;

int calculateSimilaritySum(const string& s) {
    int n = s.length();
    int totalSimilarity = 0;
    for (int i = 0; i < n; ++i) {
        string suffix = s.substr(i);
        int similarity = 0;
        for (int j = 0; j < suffix.length(); ++j) {
            if (s[j] == suffix[j]) {
                similarity++;
            } else {
                break;
            }
        }
        totalSimilarity += similarity;
    }
    return totalSimilarity;
}

int main() {
    int t;
    cout << "Enter the number of test cases: ";
    cin >> t;
    vector<int> results;
    for (int i = 0; i < t; ++i) {
        string s;
        cout << "Enter the string: ";
        cin >> s;
        results.push_back(calculateSimilaritySum(s));
    }
    for (int result : results) {
        cout << result << endl;
    }
    return 0;
}
