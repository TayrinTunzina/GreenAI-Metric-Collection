#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <climits>

using namespace std;

vector<int> bfs_distances(const vector<vector<int>>& graph, int start, int n) {
    vector<int> distances(n + 1, -1);
    distances[start] = 0;
    queue<int> q;
    q.push(start);
    
    while (!q.empty()) {
        int curr = q.front();
        q.pop();
        
        for (int neighbor : graph[curr]) {
            if (distances[neighbor] == -1) {
                distances[neighbor] = distances[curr] + 1;
                q.push(neighbor);
            }
        }
    }
    
    return distances;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int n, m;
    cin >> n >> m;
    
    // Build adjacency list for the tree
    vector<vector<int>> graph(n + 1);
    for (int i = 0; i < n - 1; i++) {
        int u, v;
        cin >> u >> v;
        graph[u].push_back(v);
        graph[v].push_back(u);
    }
    
    // Precompute all pairwise distances in the tree
    vector<vector<int>> dist(n + 1, vector<int>(n + 1));
    for (int i = 1; i <= n; i++) {
        vector<int> distances = bfs_distances(graph, i, n);
        for (int j = 1; j <= n; j++) {
            dist[i][j] = distances[j];
        }
    }
    
    // Read the points in the squared metric space
    vector<pair<int, int>> points(m);
    for (int i = 0; i < m; i++) {
        cin >> points[i].first >> points[i].second;
    }
    
    // Find maximum distance between any two points
    int max_distance = 0;
    for (int i = 0; i < m; i++) {
        for (int j = i + 1; j < m; j++) {
            int x1 = points[i].first, y1 = points[i].second;
            int x2 = points[j].first, y2 = points[j].second;
            
            // Distance in squared metric space: ρ(x1,x2) + ρ(y1,y2)
            int distance = dist[x1][x2] + dist[y1][y2];
            max_distance = max(max_distance, distance);
        }
    }
    
    cout << max_distance << endl;
    
    return 0;
}