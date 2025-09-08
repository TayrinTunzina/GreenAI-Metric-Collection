#include <bits/stdc++.h>
using namespace std;

vector<vector<int>> graph;
vector<int> bfs(int start, int n) {
    vector<int> dist(n+1, -1);
    queue<int> q;
    q.push(start);
    dist[start] = 0;
    while (!q.empty()) {
        int node = q.front(); q.pop();
        for (int nei : graph[node]) {
            if (dist[nei] == -1) {
                dist[nei] = dist[node] + 1;
                q.push(nei);
            }
        }
    }
    return dist;
}

int main() {
    int n, m;
    cin >> n >> m;
    graph.resize(n+1);
    for (int i = 0; i < n - 1; ++i) {
        int u, v; cin >> u >> v;
        graph[u].push_back(v);
        graph[v].push_back(u);
    }

    vector<pair<int,int>> points(m);
    set<int> used;
    for (int i = 0; i < m; ++i) {
        cin >> points[i].first >> points[i].second;
        used.insert(points[i].first);
        used.insert(points[i].second);
    }

    unordered_map<int, vector<int>> dist_map;
    for (int v : used) {
        dist_map[v] = bfs(v, n);
    }

    int max_dist = 0;
    for (int i = 0; i < m; ++i) {
        for (int j = i+1; j < m; ++j) {
            int d = dist_map[points[i].first][points[j].first] +
                    dist_map[points[i].second][points[j].second];
            max_dist = max(max_dist, d);
        }
    }

    cout << max_dist << endl;
    return 0;
}
