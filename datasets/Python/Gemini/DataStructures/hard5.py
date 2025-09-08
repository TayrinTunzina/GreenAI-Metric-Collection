import sys

# It's necessary to increase the recursion limit for deep trees in Python.
sys.setrecursionlimit(2 * 10**5)

def solve():
    """
    This function encapsulates the entire logic for solving the Tree-Space problem.
    """
    try:
        n_str, m_str = sys.stdin.readline().split()
        n = int(n_str)
        m = int(m_str)
    except (IOError, ValueError):
        return

    adj = [[] for _ in range(n + 1)]
    for _ in range(n - 1):
        u, v = map(int, sys.stdin.readline().split())
        adj[u].append(v)
        adj[v].append(u)

    points = []
    for _ in range(m):
        points.append(tuple(map(int, sys.stdin.readline().split())))

    if not points:
        print(0)
        return

    # --- Step 1: Find Tree Diameter and Distances from Endpoints ---
    def bfs(start_node):
        distances = [-1] * (n + 1)
        distances[start_node] = 0
        queue = [(start_node, 0)]
        farthest_node = start_node
        max_dist = 0
        
        head = 0
        while head < len(queue):
            u, d = queue[head]
            head += 1

            if d > max_dist:
                max_dist = d
                farthest_node = u
            
            for v in adj[u]:
                if distances[v] == -1:
                    distances[v] = d + 1
                    queue.append((v, d + 1))
        
        return farthest_node, distances

    a, _ = bfs(1)
    b, dist_a = bfs(a)
    _, dist_b = bfs(b)

    # --- Step 2: Identify Candidate Points ---
    candidate_indices = set()
    
    # Each tracker holds (value, index)
    val_funcs = [(float('inf'), -1), (float('-inf'), -1)] * 4
    
    for i, (x, y) in enumerate(points):
        vals = [
            dist_a[x] + dist_b[y], dist_a[x] - dist_b[y],
            dist_b[x] + dist_a[y], dist_b[x] - dist_a[y]
        ]
        for j in range(4):
            if vals[j] < val_funcs[2*j][0]: val_funcs[2*j] = (vals[j], i)
            if vals[j] > val_funcs[2*j+1][0]: val_funcs[2*j+1] = (vals[j], i)

    for _, idx in val_funcs:
        if idx != -1:
            candidate_indices.add(idx)

    # --- Step 3: Find Maximum Distance using LCA ---
    LOGN = n.bit_length()
    parent = [[0] * LOGN for _ in range(n + 1)]
    depth = [-1] * (n + 1)

    def dfs_lca(u, p, d):
        depth[u] = d
        parent[u][0] = p
        for i in range(1, LOGN):
            parent[u][i] = parent[parent[u][i-1]][i-1]
        for v in adj[u]:
            if v != p:
                dfs_lca(v, u, d + 1)

    dfs_lca(1, 0, 0)

    def lca(u, v):
        if depth[u] < depth[v]: u, v = v, u
        for i in range(LOGN - 1, -1, -1):
            if depth[u] - (1 << i) >= depth[v]:
                u = parent[u][i]
        if u == v: return u
        for i in range(LOGN - 1, -1, -1):
            if parent[u][i] != parent[v][i]:
                u, v = parent[u][i], parent[v][i]
        return parent[u][0]

    def get_dist(u, v):
        l = lca(u, v)
        return depth[u] + depth[v] - 2 * depth[l]

    max_dist = 0
    for i in candidate_indices:
        p1_x, p1_y = points[i]
        for j in range(m):
            p2_x, p2_y = points[j]
            dist = get_dist(p1_x, p2_x) + get_dist(p1_y, p2_y)
            if dist > max_dist:
                max_dist = dist
    
    print(max_dist)

solve()