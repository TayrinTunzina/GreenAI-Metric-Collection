#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int n, m;
    cin >> n >> m;

    vector<vector<int>> adj(n+1);
    for (int i = 0; i < n-1; ++i) {
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    vector<vector<int>> distance(n+1, vector<int>(n+1, 0));
    for (int u = 1; u <= n; ++u) {
        vector<int> visited(n+1, -1);
        queue<int> q;
        q.push(u);
        visited[u] = 0;
        while (!q.empty()) {
            int current = q.front();
            q.pop();
            for (int neighbor : adj[current]) {
                if (visited[neighbor] == -1) {
                    visited[neighbor] = visited[current] + 1;
                    q.push(neighbor);
                }
            }
        }
        for (int v = 1; v <= n; ++v) {
            distance[u][v] = visited[v];
        }
    }

    vector<pair<int, int>> points(m);
    for (int i = 0; i < m; ++i) {
        cin >> points[i].first >> points[i].second;
    }

    int max_dist = 0;
    for (int i = 0; i < m; ++i) {
        int x1 = points[i].first;
        int y1 = points[i].second;
        for (int j = i+1; j < m; ++j) {
            int x2 = points[j].first;
            int y2 = points[j].second;
            int dist = distance[x1][x2] + distance[y1][y2];
            if (dist > max_dist) {
                max_dist = dist;
            }
        }
    }
    cout << max_dist << endl;

    return 0;
}