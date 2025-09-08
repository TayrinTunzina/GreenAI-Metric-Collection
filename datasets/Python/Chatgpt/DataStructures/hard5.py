from collections import deque, defaultdict

def bfs(start, tree, n):
    dist = [-1] * (n + 1)
    dist[start] = 0
    q = deque([start])
    while q:
        node = q.popleft()
        for nei in tree[node]:
            if dist[nei] == -1:
                dist[nei] = dist[node] + 1
                q.append(nei)
    return dist

def main():
    n, m = map(int, input().split())
    tree = defaultdict(list)
    
    for _ in range(n - 1):
        u, v = map(int, input().split())
        tree[u].append(v)
        tree[v].append(u)

    # One BFS from any point to find furthest node
    def get_furthest(node):
        dist = bfs(node, tree, n)
        max_dist = -1
        far_node = -1
        for i in range(1, n + 1):
            if dist[i] > max_dist:
                max_dist = dist[i]
                far_node = i
        return far_node, dist

    # First BFS to find farthest node from 1
    far1, _ = get_furthest(1)
    # Second BFS from far1 to get all distances
    _, dist_from_far1 = get_furthest(far1)

    points = []
    for _ in range(m):
        x, y = map(int, input().split())
        points.append((x, y))

    def tree_distance(u, v):
        return abs(dist_from_far1[u] - dist_from_far1[v])

    def squared_distance(p1, p2):
        return tree_distance(p1[0], p2[0]) + tree_distance(p1[1], p2[1])

    max_dist = 0
    idx = 0
    for i in range(m):
        d = squared_distance(points[0], points[i])
        if d > max_dist:
            max_dist = d
            idx = i

    for i in range(m):
        d = squared_distance(points[idx], points[i])
        if d > max_dist:
            max_dist = d

    print(max_dist)

main()