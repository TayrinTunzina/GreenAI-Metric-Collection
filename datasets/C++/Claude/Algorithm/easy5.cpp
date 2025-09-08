#include <iostream>
#include <vector>
using namespace std;

string gameOfStones(int n) {
    // dp[i] = true if current player can win with i stones
    vector<bool> dp(n + 1, false);
    
    // Base cases: if we can make a move and opponent will be in losing position
    for (int i = 2; i <= n; i++) {
        // Try removing 2, 3, or 5 stones
        int moves[] = {2, 3, 5};
        for (int move : moves) {
            if (i >= move && !dp[i - move]) {
                dp[i] = true;
                break;
            }
        }
    }
    
    return dp[n] ? "First" : "Second";
}

// Optimized pattern-based solution
string gameOfStonesOptimized(int n) {
    return (n % 7 == 0 || n % 7 == 1) ? "Second" : "First";
}

int main() {
    int t;
    cout << "Enter the number of test cases: ";
    cin >> t;
    
    cout << "Enter " << t << " test case(s), each containing the number of stones:" << endl;
    
    for (int i = 0; i < t; i++) {
        int n;
        cin >> n;
        
        // Use either the DP solution or optimized solution
        string result = gameOfStones(n);
        // string result = gameOfStonesOptimized(n);  // Uncomment for optimized version
        
        cout << result << endl;
    }
    
    return 0;
}