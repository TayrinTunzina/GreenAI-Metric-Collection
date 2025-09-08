#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

vector<string> bigSorting(vector<string> unsorted) {
    // Sort using custom comparator
    sort(unsorted.begin(), unsorted.end(), [](const string& a, const string& b) {
        // First compare by length
        if (a.length() != b.length()) {
            return a.length() < b.length();
        }
        // If same length, compare lexicographically
        return a < b;
    });
    return unsorted;
}

int main() {
    int n;
    cin >> n;
    cin.ignore(); // consume newline
    
    vector<string> unsorted(n);
    for (int i = 0; i < n; i++) {
        getline(cin, unsorted[i]);
    }
    
    vector<string> result = bigSorting(unsorted);
    for (const string& item : result) {
        cout << item << endl;
    }
    
    return 0;
}