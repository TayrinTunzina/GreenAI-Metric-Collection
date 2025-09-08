#include <iostream>
#include <vector>

using namespace std;

long arrayManipulation(int n, vector<vector<int>> queries) {
    // Initialize a difference array with zeros
    vector<long> diff(n + 2, 0);

    // Process each query
    for (const auto& query : queries) {
        int a = query[0];
        int b = query[1];
        int k = query[2];
        diff[a] += k;
        if (b + 1 <= n) {
            diff[b + 1] -= k;
        }
    }

    // Compute the prefix sum to get the final array
    long max_value = 0;
    long current = 0;
    for (int i = 1; i <= n; ++i) {
        current += diff[i];
        if (current > max_value) {
            max_value = current;
        }
    }

    return max_value;
}

int main() {
    int n, num_queries;
    cout << "Enter the size of the array (n): ";
    cin >> n;
    cout << "Enter the number of queries: ";
    cin >> num_queries;

    vector<vector<int>> queries(num_queries, vector<int>(3));
    for (int i = 0; i < num_queries; ++i) {
        cout << "Enter query " << i + 1 << " (a, b, k): " << endl;
        cout << "Enter a: ";
        cin >> queries[i][0];
        cout << "Enter b: ";
        cin >> queries[i][1];
        cout << "Enter k: ";
        cin >> queries[i][2];
    }

    // Get the result
    long result = arrayManipulation(n, queries);
    cout << "Maximum value after all operations: " << result << endl;

    return 0;
}