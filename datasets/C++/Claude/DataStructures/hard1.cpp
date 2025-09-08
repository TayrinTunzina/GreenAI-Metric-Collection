#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

long arrayManipulation(int n, vector<vector<int>>& queries) {
    // Initialize array with zeros
    vector<long> arr(n + 2, 0);
    
    // Process all queries
    for(const auto& query : queries) {
        int a = query[0];
        int b = query[1];
        int k = query[2];
        
        // Add k at index a
        arr[a] += k;
        // Subtract k at index b + 1
        arr[b + 1] -= k;
    }
    
    // Calculate maximum prefix sum
    long max_value = 0;
    long running_sum = 0;
    
    for(int i = 1; i <= n; i++) {
        running_sum += arr[i];
        max_value = max(max_value, running_sum);
    }
    
    return max_value;
}

int main() {
    int n, m;
    cin >> n >> m;
    
    vector<vector<int>> queries(m, vector<int>(3));
    for(int i = 0; i < m; i++) {
        cin >> queries[i][0] >> queries[i][1] >> queries[i][2];
    }
    
    long result = arrayManipulation(n, queries);
    cout << result << endl;
    
    return 0;
}