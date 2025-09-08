#include <iostream>
#include <string>
using namespace std;

long long similarity(string s) {
    int n = s.length();
    long long total = n;  // Similarity with itself is length of string
    
    // Compare with each suffix
    for(int i = 1; i < n; i++) {
        // Count matching prefix characters
        int j = 0;
        while(j + i < n && s[j] == s[j + i]) {
            j++;
        }
        total += j;
    }
    
    return total;
}

int main() {
    int t;
    cin >> t;
    cin.ignore();  // Clear newline
    
    while(t--) {
        string s;
        getline(cin, s);
        cout << similarity(s) << endl;
    }
    
    return 0;
}