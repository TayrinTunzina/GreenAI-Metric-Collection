#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

bool compareStrings(const string& s1, const string& s2) {
    // First compare by length
    if (s1.length() != s2.length()) {
        return s1.length() < s2.length();
    }
    // If same length, compare lexicographically
    return s1 < s2;
}

vector<string> bigSorting(vector<string>& unsorted) {
    sort(unsorted.begin(), unsorted.end(), compareStrings);
    return unsorted;
}

int main() {
    int n;
    cout << "Enter the number of strings: ";
    cin >> n;
    
    vector<string> unsorted(n);
    cout << "Enter " << n << " numeric strings:" << endl;
    
    for (int i = 0; i < n; i++) {
        cin >> unsorted[i];
    }
    
    vector<string> result = bigSorting(unsorted);
    
    cout << "\nSorted array:" << endl;
    for (const string& num : result) {
        cout << num << endl;
    }
    
    return 0;
}