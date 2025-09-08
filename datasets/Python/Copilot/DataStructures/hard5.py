from collections import deque

def bfs(start, n, graph):
    dist = [-1] * (n + 1)
    queue = deque([start])
    dist[start] = 0
    while queue:
        node = queue.popleft()
        for nei in graph[node]:
            if dist[nei] == -1:
                dist[nei] = dist[node] + 1
                queue.append(nei)
    return dist

# Input
n, m = map(int, input().split())
graph = [[] for _ in range(n + 1)]
for _ in range(n - 1):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

points = [tuple(map(int, input().split())) for _ in range(m)]

# Precompute BFS from all vertices used in points
unique = set()
for x, y in points:
    unique.add(x)
    unique.add(y)

distances = {}
for v in unique:
    distances[v] = bfs(v, n, graph)

# Compute max distance in (V, 𝜌)^2
max_dist = 0
for i in range(m):
    x1, y1 = points[i]
    for j in range(i + 1, m):
        x2, y2 = points[j]
        d = distances[x1][x2] + distances[y1][y2]
        max_dist = max(max_dist, d)

print(max_dist)