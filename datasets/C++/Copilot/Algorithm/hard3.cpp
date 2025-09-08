#include <iostream>
#include <vector>
using namespace std;

vector<int> calculate_z(const string& s) {
    int n = s.length();
    vector<int> z(n);
    int l = 0, r = 0;
    for (int i = 1; i < n; ++i) {
        if (i > r) {
            l = r = i;
            while (r < n && s[r] == s[r - l]) r++;
            z[i] = r - l;
            r--;
        } else {
            int k = i - l;
            if (z[k] < r - i + 1) {
                z[i] = z[k];
            } else {
                l = i;
                while (r < n && s[r] == s[r - l]) r++;
                z[i] = r - l;
                r--;
            }
        }
    }
    z[0] = n;
    return z;
}

int similarity_sum(const string& s) {
    vector<int> z = calculate_z(s);
    int sum = 0;
    for (int val : z) sum += val;
    return sum;
}

int main() {
    int t;
    cout << "Enter the number of test cases: ";
    cin >> t;
    for (int i = 0; i < t; ++i) {
        string s;
        cin >> s;
        cout << similarity_sum(s) << endl;
    }
    return 0;
}
