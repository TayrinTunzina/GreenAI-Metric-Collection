#include <iostream>
#include <vector>
#include <string>
using namespace std;

vector<int> z_algorithm(const string& s) {
    int n = s.size();
    vector<int> z(n, 0);
    int l = 0, r = 0;
    for (int i = 1; i < n; ++i) {
        if (i <= r) {
            z[i] = min(r - i + 1, z[i - l]);
        }
        while (i + z[i] < n && s[z[i]] == s[i + z[i]]) {
            z[i]++;
        }
        if (i + z[i] - 1 > r) {
            l = i;
            r = i + z[i] - 1;
        }
    }
    return z;
}

long long sum_of_similarities(const string& s) {
    vector<int> z = z_algorithm(s);
    long long total = s.size(); // Similarity of string with itself
    for (int val : z) {
        total += val;
    }
    return total;
}

int main() {
    int t;
    cout << "Enter the number of test cases: ";
    cin >> t;
    while (t--) {
        string s;
        cout << "Enter the string: ";
        cin >> s;
        cout << sum_of_similarities(s) << endl;
    }
    return 0;
}