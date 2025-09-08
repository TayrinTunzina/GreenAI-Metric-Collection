#include <iostream>
#include <vector>
#include <queue>
#include <unordered_set>
#include <algorithm>
using namespace std;

struct State {
    long long val;
    vector<long long> path;
};

int main() {
    long long N;
    int K;
    cout << "Enter N and K: ";
    cin >> N >> K;
    vector<int> A(K);
    cout << "Enter " << K << " elements of A: ";
    for (int i = 0; i < K; i++) cin >> A[i];
    sort(A.begin(), A.end());

    queue<State> q;
    q.push({1, {1}});
    unordered_set<long long> visited;
    visited.insert(1);

    while (!q.empty()) {
        State curr = q.front(); q.pop();
        if (curr.val == N) {
            for (auto v : curr.path) cout << v << " ";
            cout << endl;
            return 0;
        }
        for (int a : A) {
            long long next = curr.val * a;
            if (next <= N && N % next == 0 && !visited.count(next)) {
                visited.insert(next);
                vector<long long> new_path = curr.path;
                new_path.push_back(next);
                q.push({next, new_path});
            }
        }
    }

    cout << -1 << endl;
    return 0;
}
