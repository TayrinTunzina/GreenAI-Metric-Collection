#include <iostream>
#include <vector>
#include <unordered_map>
#include <set>
using namespace std;

int mex(const set<int>& s) {
    int i = 0;
    while (s.count(i)) {
        i++;
    }
    return i;
}

int calculateGrundy(long long m, int k, unordered_map<long long, int>& memo) {
    if (memo.count(m)) {
        return memo[m];
    }
    
    if (m == 1) {
        return memo[m] = 0;
    }
    
    set<int> reachable;
    
    // Move 1: Remove entire tree
    reachable.insert(0);
    
    // Move 2: Remove leaf nodes
    vector<long long> leaves;
    
    // Node 1 is always a leaf if m > 1
    if (m > 1) {
        leaves.push_back(1);
    }
    
    // Check other potential leaves
    for (long long node = 2; node <= m; node++) {
        int connections = 0;
        
        // Check if this node is a parent
        for (long long j = 1; j < m; j++) {
            long long parent = max(1LL, (j + k - 1) / k);
            if (parent == node) {
                connections++;
            }
        }
        
        // Check if this node has a parent
        if (node > 1) {
            long long edge_num = node - 1;
            long long parent = max(1LL, (edge_num + k - 1) / k);
            if (parent != node) {
                connections++;
            }
        }
        
        if (connections == 1) {
            leaves.push_back(node);
        }
    }
    
    // Calculate Grundy numbers for leaf removals
    for (long long leaf : leaves) {
        if (leaf == 1 && m > 1) {
            long long new_m = m - 1;
            reachable.insert(calculateGrundy(new_m, k, memo));
        } else if (leaf == m) {
            long long new_m = m - 1;
            reachable.insert(calculateGrundy(new_m, k, memo));
        }
    }
    
    return memo[m] = mex(reachable);
}

int calculateGrundyOptimized(long long m, int k) {
    if (m == 1) {
        return 0;
    } else if (m <= k) {
        return 1;
    } else {
        return (m - 1) % (k + 1);
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int g;
    cin >> g;
    
    while (g--) {
        int n;
        cin >> n;
        
        int total_grundy = 0;
        
        for (int i = 0; i < n; i++) {
            long long m;
            int k;
            cin >> m >> k;
            
            // Use optimized calculation
            int tree_grundy = calculateGrundyOptimized(m, k);
            total_grundy ^= tree_grundy;
        }
        
        if (total_grundy == 0) {
            cout << "BEN" << endl;
        } else {
            cout << "BOB" << endl;
        }
    }
    
    return 0;
}