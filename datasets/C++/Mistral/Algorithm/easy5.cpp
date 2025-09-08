#include <iostream>
#include <vector>
using namespace std;

string gameOfStones(int n) {
    vector<bool> dp(n + 1, false);

    // Base case
    dp[0] = false;

    // Fill the dp array
    for (int i = 1; i <= n; ++i) {
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
    cout << "Enter the number of test cases: ";
    cin >> t;

    for (int i = 0; i < t; ++i) {
        int n;
        cout << "Enter the number of stones: ";
        cin >> n;
        cout << gameOfStones(n) << endl;
    }

    return 0;
}
