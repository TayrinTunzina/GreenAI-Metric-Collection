#include <iostream>
#include <vector>
#include <numeric>
#include <algorithm>
#include <map>

using namespace std;

// Memoization table to store results for subproblems
map<long long, vector<long long>> memo;
// The given set of multipliers
vector<long long> A;

// Recursive function to find the optimal path to 'n'
vector<long long> solve(long long n) {
    // Base case: The path to 1 is just [1]
    if (n == 1) {
        return {1};
    }
    // If we have already computed the path for 'n', return it
    if (memo.count(n)) {
        return memo[n];
    }

    vector<long long> best_path; // An empty vector signifies an impossible path

    // Iterate through all possible multipliers in descending order
    for (long long a : A) {
        if (n % a == 0) {
            // Recursively find the path to the previous number (n / a)
            vector<long long> prev_path = solve(n / a);

            // If a path to the previous number exists
            if (!prev_path.empty()) {
                vector<long long> current_path = prev_path;
                current_path.push_back(n);

                // Check if the new path is better than the best one found so far
                // 1. Shorter length is better.
                // 2. Same length, lexicographically smaller is better.
                if (best_path.empty() ||
                    current_path.size() < best_path.size() ||
                    (current_path.size() == best_path.size() && current_path < best_path)) {
                    best_path = current_path;
                }
            }
        }
    }

    // Store the result in the memoization table and return it
    return memo[n] = best_path;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    long long N;
    int K;

    // Read input
    cout << "Enter N and K: ";
    cin >> N >> K;
    A.resize(K);
    cout << "Enter the " << K << " elements of set A: ";
    for (int i = 0; i < K; ++i) {
        cin >> A[i];
    }

    // Sort A in descending order for a better heuristic
    sort(A.rbegin(), A.rend());

    // Solve the problem for N
    vector<long long> result = solve(N);

    // Print the output
    cout << "Output: ";
    if (result.empty()) {
        cout << -1 << endl;
    } else {
        for (size_t i = 0; i < result.size(); ++i) {
            cout << result[i] << (i == result.size() - 1 ? "" : " ");
        }
        cout << endl;
    }

    return 0;
}