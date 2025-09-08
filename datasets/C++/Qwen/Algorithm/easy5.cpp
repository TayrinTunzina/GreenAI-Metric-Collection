#include <iostream>
#include <vector>
using namespace std;

string gameOfStones(int n) {
    // dp[i] represents whether the current player can win with i stones
    if (n <= 1) {
        return "Second";
    }
    
    vector<bool> dp(n + 1, false);
    
    // Fill dp array
    for (int i = 2; i <= n; i++) {
        // Check if we can make a move that leads to opponent's loss
        if (i >= 2 && !dp[i - 2]) {  // Take 2 stones
            dp[i] = true;
        } else if (i >= 3 && !dp[i - 3]) {  // Take 3 stones
            dp[i] = true;
        } else if (i >= 5 && !dp[i - 5]) {  // Take 5 stones
            dp[i] = true;
        }
        // If none of the above, dp[i] remains false
    }
    
    return dp[n] ? "First" : "Second";
}

int main() {
    int t;
    cin >> t;
    
    for (int i = 0; i < t; i++) {
        int n;
        cin >> n;
        cout << gameOfStones(n) << endl;
    }
    
    return 0;
}