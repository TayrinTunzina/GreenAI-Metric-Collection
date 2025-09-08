#include <iostream>
#include <vector>
using namespace std;

string gameOfStones(int n) {
    vector<bool> dp(n + 1, false);
    for (int i = 1; i <= n; ++i) {
        if (i >= 2 && !dp[i - 2]) dp[i] = true;
        else if (i >= 3 && !dp[i - 3]) dp[i] = true;
        else if (i >= 5 && !dp[i - 5]) dp[i] = true;
    }
    return dp[n] ? "First" : "Second";
}

int main() {
    int t, n;
    cout << "Enter number of test cases: ";
    cin >> t;
    while (t--) {
        cout << "Enter number of stones: ";
        cin >> n;
        cout << gameOfStones(n) << endl;
    }
    return 0;
}
