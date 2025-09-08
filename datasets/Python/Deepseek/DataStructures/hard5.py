import sys
from collections import deque

def main():
    input = sys.stdin
    n, m = map(int, input.readline().split())

    adj = [[] for _ in range(n+1)]
    for _ in range(n-1):
        u, v = map(int, input.readline().split())
        adj[u].append(v)
        adj[v].append(u)

    # Precompute distances from each node
    distance = [[0]*(n+1) for _ in range(n+1)]
    for u in range(1, n+1):
        visited = [-1]*(n+1)
        q = deque()
        q.append(u)
        visited[u] = 0
        while q:
            current = q.popleft()
            for neighbor in adj[current]:
                if visited[neighbor] == -1:
                    visited[neighbor] = visited[current] + 1
                    q.append(neighbor)
        for v in range(1, n+1):
            distance[u][v] = visited[v]

    points = []
    for _ in range(m):
        x, y = map(int, input.readline().split())
        points.append((x, y))

    max_dist = 0
    for i in range(m):
        x1, y1 = points[i]
        for j in range(i+1, m):
            x2, y2 = points[j]
            dist = distance[x1][x2] + distance[y1][y2]
            if dist > max_dist:
                max_dist = dist
    print(max_dist)

if __name__ == "__main__":
    main()