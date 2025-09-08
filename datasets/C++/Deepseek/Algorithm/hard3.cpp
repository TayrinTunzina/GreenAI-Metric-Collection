#include <iostream>
#include <vector>
#include <string>

using namespace std;

vector<int> calculateZArray(const string& s) {
    int n = s.length();
    vector<int> Z(n, 0);
    Z[0] = n;
    int l = 0, r = 0;
    for (int i = 1; i < n; ++i) {
        if (i > r) {
            l = r = i;
            while (r < n && s[r - l] == s[r]) {
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
                while (r < n && s[r - l] == s[r]) {
                    r++;
                }
                Z[i] = r - l;
                r--;
            }
        }
    }
    return Z;
}

int sumOfSimilarities(const string& s) {
    vector<int> Z = calculateZArray(s);
    int sum = 0;
    for (int z : Z) {
        sum += z;
    }
    return sum;
}

int main() {
    int t;
    cout << "Enter the number of test cases: ";
    cin >> t;
    cin.ignore();  // To ignore the newline character after the integer input

    vector<string> test_cases(t);
    for (int i = 0; i < t; ++i) {
        cout << "Enter string " << i + 1 << ": ";
        getline(cin, test_cases[i]);
    }

    for (int i = 0; i < t; ++i) {
        cout << "Sum of similarities for \"" << test_cases[i] << "\": " << sumOfSimilarities(test_cases[i]) << endl;
    }

    return 0;
}