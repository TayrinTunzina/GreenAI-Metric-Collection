from collections import deque

def bfs(graph, start, n):
    dist = [-1] * (n + 1)
    q = deque([start])
    dist[start] = 0
    while q:
        u = q.popleft()
        for v in graph[u]:
            if dist[v] == -1:
                dist[v] = dist[u] + 1
                q.append(v)
    return dist

# Read n and m
n, m = map(int, input().split())

# Build graph
graph = [[] for _ in range(n + 1)]
for _ in range(n - 1):
    u, v = map(int, input().split())
    graph[u].append(v)
    graph[v].append(u)

# Find diameter: U and V
dist1 = bfs(graph, 1, n)
U = 1
for i in range(1, n + 1):
    if dist1[i] > dist1[U]:
        U = i

distU = bfs(graph, U, n)
V = U
for i in range(1, n + 1):
    if distU[i] > distU[V]:
        V = i

distV = bfs(graph, V, n)

# Read m points
values = [[], [], [], []]  # v1, v2, v3, v4

for _ in range(m):
    x, y = map(int, input().split())
    v1 = distU[x] + distU[y]
    v2 = distU[x] + distV[y]
    v3 = distV[x] + distU[y]
    v4 = distV[x] + distV[y]
    values[0].append(v1)
    values[1].append(v2)
    values[2].append(v3)
    values[3].append(v4)

answer = max(max(vals) - min(vals) for vals in values)
print(answer)