#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <climits>
using namespace std;

vector<int> bfs(const vector<vector<int>>& graph, int start, int n) {
    vector<int> dist(n + 1, -1);
    queue<int> q;
    q.push(start);
    dist[start] = 0;
    while (!q.empty()) {
        int u = q.front();
        q.pop();
        for (int v : graph[u]) {
            if (dist[v] == -1) {
                dist[v] = dist[u] + 1;
                q.push(v);
            }
        }
    }
    return dist;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);

    int n, m;
    cin >> n >> m;

    vector<vector<int>> graph(n + 1);
    for (int i = 0; i < n - 1; i++) {
        int u, v;
        cin >> u >> v;
        graph[u].push_back(v);
        graph[v].push_back(u);
    }

    // BFS from node 1 to find U (farthest from 1)
    vector<int> dist1 = bfs(graph, 1, n);
    int U = 1;
    for (int i = 1; i <= n; i++) {
        if (dist1[i] > dist1[U]) {
            U = i;
        }
    }

    // BFS from U to find V (farthest from U)
    vector<int> distU = bfs(graph, U, n);
    int V = U;
    for (int i = 1; i <= n; i++) {
        if (distU[i] > distU[V]) {
            V = i;
        }
    }

    // BFS from V to get distances from V
    vector<int> distV = bfs(graph, V, n);

    // Read m points and compute 4 values
    vector<long long> v1_vals, v2_vals, v3_vals, v4_vals;

    for (int i = 0; i < m; i++) {
        int x, y;
        cin >> x >> y;

        long long v1 = (long long)distU[x] + distU[y];
        long long v2 = (long long)distU[x] + distV[y];
        long long v3 = (long long)distV[x] + distU[y];
        long long v4 = (long long)distV[x] + distV[y];

        v1_vals.push_back(v1);
        v2_vals.push_back(v2);
        v3_vals.push_back(v3);
        v4_vals.push_back(v4);
    }

    // Compute range for each value
    auto range = [](const vector<long long>& v) {
        return *max_element(v.begin(), v.end()) - *min_element(v.begin(), v.end());
    };

    long long r1 = range(v1_vals);
    long long r2 = range(v2_vals);
    long long r3 = range(v3_vals);
    long long r4 = range(v4_vals);

    long long answer = max({r1, r2, r3, r4});
    cout << answer << endl;

    return 0;
}