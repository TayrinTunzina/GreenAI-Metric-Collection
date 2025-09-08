#include <iostream>
#include <vector>

using namespace std;

string gameOfStones(int n) {
    vector<bool> dp(101, false);
    dp[0] = false;
    dp[1] = false;
    for (int i = 2; i <= 100; ++i) {
        if (i >= 2 && !dp[i - 2]) {
            dp[i] = true;
        } else if (i >= 3 && !dp[i - 3]) {
            dp[i] = true;
        } else if (i >= 5 && !dp[i - 5]) {
            dp[i] = true;
        } else {
            dp[i] = false;
        }
    }
    return dp[n] ? "First" : "Second";
}

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        cout << gameOfStones(n) << endl;
    }
    return 0;
}