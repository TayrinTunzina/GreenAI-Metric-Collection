#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

const int MAXN = 75005;
vector<int> tree[MAXN];
int dist[MAXN];

void bfs(int start, int n) {
    fill(dist, dist + n + 1, -1);
    queue<int> q;
    q.push(start);
    dist[start] = 0;

    while (!q.empty()) {
        int node = q.front(); q.pop();
        for (int v : tree[node]) {
            if (dist[v] == -1) {
                dist[v] = dist[node] + 1;
                q.push(v);
            }
        }
    }
}

int main() {
    int n, m;
    cin >> n >> m;

    for (int i = 0; i < n - 1; i++) {
        int u, v;
        cin >> u >> v;
        tree[u].push_back(v);
        tree[v].push_back(u);
    }

    // First BFS to find a far node
    bfs(1, n);
    int far1 = 1;
    for (int i = 1; i <= n; i++) {
        if (dist[i] > dist[far1])
            far1 = i;
    }

    bfs(far1, n);
    vector<pair<int, int>> points(m);
    for (int i = 0; i < m; i++) {
        cin >> points[i].first >> points[i].second;
    }

    auto tree_distance = [&](int u, int v) {
        return abs(dist[u] - dist[v]);
    };

    auto squared_distance = [&](pair<int, int> a, pair<int, int> b) {
        return tree_distance(a.first, b.first) + tree_distance(a.second, b.second);
    };

    int idx = 0, max_d = 0;
    for (int i = 0; i < m; i++) {
        int d = squared_distance(points[0], points[i]);
        if (d > max_d) {
            max_d = d;
            idx = i;
        }
    }

    for (int i = 0; i < m; i++) {
        int d = squared_distance(points[idx], points[i]);
        max_d = max(max_d, d);
    }

    cout << max_d << endl;
    return 0;
}
