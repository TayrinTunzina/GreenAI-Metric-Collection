#include <iostream>
#include <vector>
#include <string>

using namespace std;

// Z-function to calculate the Z-array for string s
vector<int> zFunction(const string& s) {
    int n = s.size();
    vector<int> Z(n);
    Z[0] = n;
    int l = 0, r = 0;
    
    for (int i = 1; i < n; i++) {
        if (i > r) {
            l = r = i;
            while (r < n && s[r] == s[r - l]) {
                r++;
            }
            Z[i] = r - l;
            r--;
        } else {
            int k = i - l;
            if (Z[k] < r - i + 1) {
                Z[i] = Z[k];
            } else {
                l = i;
                while (r < n && s[r] == s[r - l]) {
                    r++;
                }
                Z[i] = r - l;
                r--;
            }
        }
    }
    
    return Z;
}

// Function to calculate the sum of similarities for string s
int sumOfSimilarities(const string& s) {
    vector<int> Z = zFunction(s);
    int sum = 0;
    for (int value : Z) {
        sum += value;
    }
    return sum;
}

int main() {
    int t;
    cin >> t;
    cin.ignore();  // To ignore the newline after reading the number of test cases
    
    for (int i = 0; i < t; i++) {
        string s;
        getline(cin, s);
        cout << sumOfSimilarities(s) << endl;
    }
    
    return 0;
}
