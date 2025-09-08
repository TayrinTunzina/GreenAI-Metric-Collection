#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <unordered_set>
using namespace std;

int main() {
    int N, K;
    cout << "Enter N and K: ";
    cin >> N >> K;
    vector<int> A(K);
    cout << "Enter " << K << " integers for A: ";
    for (int i = 0; i < K; ++i) cin >> A[i];
    sort(A.begin(), A.end());

    queue<pair<long long, vector<long long>>> q;
    unordered_set<long long> visited;
    q.push({1, {1}});
    visited.insert(1);

    while (!q.empty()) {
        auto [curr, path] = q.front(); q.pop();
        for (int a : A) {
            long long next_val = curr * a;
            if (next_val > N || N % next_val != 0 || visited.count(next_val)) continue;
            visited.insert(next_val);
            vector<long long> new_path = path;
            new_path.push_back(next_val);
            if (next_val == N) {
                for (auto v : new_path) cout << v << " ";
                cout << endl;
                return 0;
            }
            q.push({next_val, new_path});
        }
    }
    cout << -1 << endl;
    return 0;
}
