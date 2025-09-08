#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <cmath>
#include <set>

using namespace std;

const int MAXN = 75005;
const int LOGN = 17; // ceil(log2(75005))

vector<int> adj[MAXN];
pair<int, int> points[MAXN];
int n, m;

int depth[MAXN];
int parent[MAXN][LOGN];
long long dist_a[MAXN], dist_b[MAXN];

void bfs(int start_node, long long dist[]) {
    for (int i = 1; i <= n; ++i) {
        dist[i] = -1;
    }
    dist[start_node] = 0;
    queue<int> q;
    q.push(start_node);

    while (!q.empty()) {
        int u = q.front();
        q.pop();

        for (int v : adj[u]) {
            if (dist[v] == -1) {
                dist[v] = dist[u] + 1;
                q.push(v);
            }
        }
    }
}

int get_farthest_node(long long dist[]) {
    int farthest_node = 1;
    for (int i = 1; i <= n; ++i) {
        if (dist[i] > dist[farthest_node]) {
            farthest_node = i;
        }
    }
    return farthest_node;
}

void dfs_lca(int u, int p, int d) {
    depth[u] = d;
    parent[u][0] = p;
    for (int i = 1; i < LOGN; ++i) {
        parent[u][i] = parent[parent[u][i - 1]][i - 1];
    }
    for (int v : adj[u]) {
        if (v != p) {
            dfs_lca(v, u, d + 1);
        }
    }
}

int lca(int u, int v) {
    if (depth[u] < depth[v]) {
        swap(u, v);
    }
    for (int i = LOGN - 1; i >= 0; --i) {
        if (depth[u] - (1 << i) >= depth[v]) {
            u = parent[u][i];
        }
    }
    if (u == v) {
        return u;
    }
    for (int i = LOGN - 1; i >= 0; --i) {
        if (parent[u][i] != parent[v][i]) {
            u = parent[u][i];
            v = parent[v][i];
        }
    }
    return parent[u][0];
}

int get_dist(int u, int v) {
    int ancestor = lca(u, v);
    return depth[u] + depth[v] - 2 * depth[ancestor];
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n >> m;

    for (int i = 0; i < n - 1; ++i) {
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    for (int i = 0; i < m; ++i) {
        cin >> points[i].first >> points[i].second;
    }
    
    if (m == 0) {
        cout << 0 << endl;
        return 0;
    }

    // Step 1: Find diameter
    long long temp_dist[MAXN];
    bfs(1, temp_dist);
    int a = get_farthest_node(temp_dist);
    bfs(a, dist_a);
    int b = get_farthest_node(dist_a);
    bfs(b, dist_b);
    
    // Step 2: Find candidates
    set<int> candidate_indices;
    pair<long long, int> v_funcs[8];
    for(int i = 0; i < 8; i += 2) {
        v_funcs[i] = {__LONG_LONG_MAX__, -1};
        v_funcs[i+1] = {-__LONG_LONG_MAX__, -1};
    }

    for (int i = 0; i < m; ++i) {
        int x = points[i].first;
        int y = points[i].second;
        long long vals[] = {
            dist_a[x] + dist_b[y], dist_a[x] - dist_b[y],
            dist_b[x] + dist_a[y], dist_b[x] - dist_a[y]
        };
        for(int j=0; j<4; ++j) {
            if (vals[j] < v_funcs[2*j].first) v_funcs[2*j] = {vals[j], i};
            if (vals[j] > v_funcs[2*j+1].first) v_funcs[2*j+1] = {vals[j], i};
        }
    }
    for(int i = 0; i < 8; ++i) {
        if(v_funcs[i].second != -1) candidate_indices.insert(v_funcs[i].second);
    }

    // Step 3: Calculate max distance
    dfs_lca(1, 0, 0);

    long long max_dist = 0;
    for (int i : candidate_indices) {
        int p1_x = points[i].first;
        int p1_y = points[i].second;
        for (int j = 0; j < m; ++j) {
            int p2_x = points[j].first;
            int p2_y = points[j].second;
            long long current_dist = (long long)get_dist(p1_x, p2_x) + get_dist(p1_y, p2_y);
            if (current_dist > max_dist) {
                max_dist = current_dist;
            }
        }
    }

    cout << max_dist << endl;

    return 0;
}