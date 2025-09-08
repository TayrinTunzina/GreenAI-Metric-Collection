#include <iostream>
#include <vector>
#include <queue>
#include <unordered_set>
#include <algorithm>
using namespace std;

void solve() {
    // Manual input - user enters values during runtime
    cout << "Enter N and K (space separated): ";
    int n, k;
    cin >> n >> k;
    
    cout << "Enter " << k << " elements of array A (space separated): ";
    vector<int> a(k);
    for (int i = 0; i < k; i++) {
        cin >> a[i];
    }
    
    // Sort to ensure lexicographic ordering
    sort(a.begin(), a.end());
    
    // BFS
    queue<pair<long long, vector<long long>>> q;
    unordered_set<long long> visited;
    
    q.push({1, {1}});
    visited.insert(1);
    
    while (!q.empty()) {
        auto [current, path] = q.front();
        q.pop();
        
        if (current == n) {
            for (int i = 0; i < path.size(); i++) {
                if (i > 0) cout << " ";
                cout << path[i];
            }
            cout << endl;
            return;
        }
        
        // Try each multiplier in sorted order
        for (int multiplier : a) {
            long long next_val = current * multiplier;
            
            // Pruning
            if (next_val > n) continue;
            
            if (visited.find(next_val) == visited.end()) {
                visited.insert(next_val);
                vector<long long> new_path = path;
                new_path.push_back(next_val);
                q.push({next_val, new_path});
            }
        }
    }
    
    cout << -1 << endl;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    cout << "=== Reverse Factorization Problem ===" << endl;
    cout << "Find the lexicographically smallest path with minimum states from 1 to N" << endl;
    cout << "Example: N=12, A=[2,3,4] should give output: 1 3 12" << endl;
    cout << endl;
    
    solve();
    
    return 0;
}