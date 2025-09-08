#include <iostream>
#include <vector>
#include <queue>
#include <utility>

using namespace std;

vector<vector<int>> computeDistances(int n, const vector<vector<int>>& tree) {
    vector<vector<int>> distance(n + 1, vector<int>(n + 1, 0));

    for (int i = 1; i <= n; ++i) {
        vector<bool> visited(n + 1, false);
        queue<int> q;
        q.push(i);
        visited[i] = true;

        while (!q.empty()) {
            int u = q.front();
            q.pop();

            for (int v : tree[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    distance[i][v] = distance[i][u] + 1;
                    q.push(v);
                }
            }
        }
    }

    return distance;
}

int main() {
    int n, m;
    cout << "Enter the number of vertices (n): ";
    cin >> n;
    cout << "Enter the number of points (m): ";
    cin >> m;

    vector<vector<int>> tree(n + 1);
    cout << "Enter the edges (u and v for each edge):" << endl;
    for (int i = 0; i < n - 1; ++i) {
        int u, v;
        cout << "Enter edge " << i + 1 << " (u v): ";
        cin >> u >> v;
        tree[u].push_back(v);
        tree[v].push_back(u);
    }

    vector<vector<int>> distance = computeDistances(n, tree);

    vector<pair<int, int>> points(m);
    cout << "Enter the points (x and y for each point):" << endl;
    for (int i = 0; i < m; ++i) {
        cout << "Enter point " << i + 1 << " (x y): ";
        cin >> points[i].first >> points[i].second;
    }

    int max_distance = 0;
    for (int i = 0; i < m; ++i) {
        for (int j = i + 1; j < m; ++j) {
            int current_distance = distance[points[i].first][points[j].first] +
                                  distance[points[i].second][points[j].second];
            if (current_distance > max_distance) {
                max_distance = current_distance;
            }
        }
    }

    cout << "The maximum distance is: " << max_distance << endl;

    return 0;
}
