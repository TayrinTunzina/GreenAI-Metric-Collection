#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

long arrayManipulation(int n, vector<vector<int>> queries) {
    // Step 1: Initialize the difference array
    vector<long> diff(n + 2, 0);
    
    // Step 2: Process all queries
    for (const auto& query : queries) {
        int a = query[0], b = query[1], k = query[2];
        diff[a] += k;
        if (b + 1 <= n) {
            diff[b + 1] -= k;
        }
    }
    
    // Step 3: Compute prefix sums and find the maximum value
    long max_value = 0, current_sum = 0;
    for (int i = 1; i <= n; ++i) {
        current_sum += diff[i];
        max_value = max(max_value, current_sum);
    }
    
    return max_value;
}

int main() {
    // Input handling
    int n, m;
    cout << "Enter the size of the array (n) and number of operations (m): ";
    cin >> n >> m;
    
    vector<vector<int>> queries(m, vector<int>(3));
    cout << "Enter the queries (each line as 'a b k'):\n";
    for (int i = 0; i < m; ++i) {
        cin >> queries[i][0] >> queries[i][1] >> queries[i][2];
    }
    
    // Call the function and print the result
    long result = arrayManipulation(n, queries);
    cout << "The maximum value in the array is: " << result << endl;
    
    return 0;
}