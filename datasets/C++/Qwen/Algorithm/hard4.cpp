#include <iostream>
#include <vector>
#include <map>
#include <set>
#include <algorithm>
using namespace std;

int main() {
    long long N;
    int K;
    cin >> N >> K;

    vector<int> A(K);
    for (int i = 0; i < K; i++) {
        cin >> A[i];
    }

    // Special case: N is 1
    if (N == 1) {
        cout << 1 << endl;
        return 0;
    }

    // Map to store the best (shortest & lex smallest) path to each number
    map<long long, vector<long long>> best_path;
    best_path[1] = {1};

    vector<long long> level = {1}; // Current BFS level

    while (!level.empty()) {
        map<long long, vector<long long>> next_level_candidates;

        // Sort current level to process smaller values first (helps lex order)
        sort(level.begin(), level.end());

        for (long long u : level) {
            if (best_path.find(u) == best_path.end()) continue;

            for (int a : A) {
                long long v = u * a;
                if (v > N) continue;

                vector<long long> new_path = best_path[u];
                new_path.push_back(v);

                // Keep the lexicographically smallest path to v at this level
                if (next_level_candidates.find(v) == next_level_candidates.end()) {
                    next_level_candidates[v] = new_path;
                } else {
                    if (new_path < next_level_candidates[v]) {
                        next_level_candidates[v] = new_path;
                    }
                }
            }
        }

        vector<long long> next_level;
        for (auto& kv : next_level_candidates) {
            long long v = kv.first;
            vector<long long> path = kv.second;

            if (best_path.find(v) == best_path.end()) {
                best_path[v] = path;
                next_level.push_back(v);
            } else {
                vector<long long>& old_path = best_path[v];
                if (path.size() < old_path.size()) {
                    best_path[v] = path;
                    next_level.push_back(v);
                } else if (path.size() == old_path.size() && path < old_path) {
                    best_path[v] = path;
                    next_level.push_back(v);
                }
            }
        }

        // If we reached N, break (shortest path found)
        if (best_path.find(N) != best_path.end()) {
            break;
        }

        // Remove duplicates for next level
        sort(next_level.begin(), next_level.end());
        next_level.erase(unique(next_level.begin(), next_level.end()), next_level.end());
        level = next_level;
    }

    // Output
    if (best_path.find(N) != best_path.end()) {
        vector<long long>& result = best_path[N];
        for (int i = 0; i < result.size(); i++) {
            if (i > 0) cout << " ";
            cout << result[i];
        }
        cout << endl;
    } else {
        cout << -1 << endl;
    }

    return 0;
}