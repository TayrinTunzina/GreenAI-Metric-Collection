#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <unordered_map>
#include <climits>

using namespace std;

vector<int> solve() {
    int N, K;
    cin >> N >> K;
    vector<int> A(K);
    for (int i = 0; i < K; ++i) {
        cin >> A[i];
    }
    sort(A.begin(), A.end());
    
    unordered_map<int, int> visited; // value -> steps
    queue<pair<int, vector<int>>> q;
    q.push({1, {1}});
    visited[1] = 1;
    
    vector<vector<int>> found_paths;
    
    while (!q.empty()) {
        auto current_pair = q.front();
        q.pop();
        int current = current_pair.first;
        vector<int> path = current_pair.second;
        
        if (current == N) {
            found_paths.push_back(path);
            continue;
        }
        
        for (int num : A) {
            long long next_val = (long long)current * num;
            if (next_val > N) continue;
            if (visited.find(next_val) == visited.end() || path.size() + 1 <= visited[next_val]) {
                vector<int> new_path = path;
                new_path.push_back(next_val);
                if (visited.find(next_val) == visited.end()) {
                    visited[next_val] = new_path.size();
                    q.push({next_val, new_path});
                } else if (path.size() + 1 == visited[next_val]) {
                    q.push({next_val, new_path});
                }
            }
        }
    }
    
    if (found_paths.empty()) {
        return {-1};
    }
    
    int min_len = INT_MAX;
    for (auto& path : found_paths) {
        if (path.size() < min_len) {
            min_len = path.size();
        }
    }
    
    vector<vector<int>> candidates;
    for (auto& path : found_paths) {
        if (path.size() == min_len) {
            candidates.push_back(path);
        }
    }
    
    sort(candidates.begin(), candidates.end());
    return candidates[0];
}

int main() {
    vector<int> result = solve();
    if (result.size() == 1 && result[0] == -1) {
        cout << -1 << endl;
    } else {
        for (size_t i = 0; i < result.size(); ++i) {
            if (i != 0) cout << " ";
            cout << result[i];
        }
        cout << endl;
    }
    return 0;
}