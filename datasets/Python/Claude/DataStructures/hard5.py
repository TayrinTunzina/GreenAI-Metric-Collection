from collections import deque, defaultdict

def bfs_distances(graph, start, n):
    """Calculate distances from start vertex to all other vertices using BFS"""
    distances = [-1] * (n + 1)
    distances[start] = 0
    queue = deque([start])
    
    while queue:
        curr = queue.popleft()
        for neighbor in graph[curr]:
            if distances[neighbor] == -1:
                distances[neighbor] = distances[curr] + 1
                queue.append(neighbor)
    
    return distances

def solve():
    # Read input
    n, m = map(int, input().split())
    
    # Build adjacency list for the tree
    graph = defaultdict(list)
    for _ in range(n - 1):
        u, v = map(int, input().split())
        graph[u].append(v)
        graph[v].append(u)
    
    # Precompute all pairwise distances in the tree
    dist = {}
    for i in range(1, n + 1):
        distances = bfs_distances(graph, i, n)
        for j in range(1, n + 1):
            dist[(i, j)] = distances[j]
    
    # Read the points in the squared metric space
    points = []
    for _ in range(m):
        x, y = map(int, input().split())
        points.append((x, y))
    
    # Find maximum distance between any two points
    max_distance = 0
    for i in range(m):
        for j in range(i + 1, m):
            x1, y1 = points[i]
            x2, y2 = points[j]
            
            # Distance in squared metric space: ρ(x1,x2) + ρ(y1,y2)
            distance = dist[(x1, x2)] + dist[(y1, y2)]
            max_distance = max(max_distance, distance)
    
    print(max_distance)

if __name__ == "__main__":
    solve()