from collections import deque

def main():
    # Read n and m interactively
    n = int(input("Enter the number of vertices (n): "))
    m = int(input("Enter the number of points (m): "))

    # Build the tree
    tree = [[] for _ in range(n + 1)]
    print("Enter the edges (u and v for each edge):")
    for i in range(n - 1):
        u, v = map(int, input(f"Enter edge {i + 1} (u v): ").split())
        tree[u].append(v)
        tree[v].append(u)

    # Precompute distances between all pairs of vertices using BFS
    distance = [[0] * (n + 1) for _ in range(n + 1)]
    for i in range(1, n + 1):
        queue = deque([i])
        visited = [False] * (n + 1)
        visited[i] = True
        while queue:
            u = queue.popleft()
            for v in tree[u]:
                if not visited[v]:
                    visited[v] = True
                    distance[i][v] = distance[i][u] + 1
                    queue.append(v)

    # Process each point and find the maximum distance
    max_distance = 0
    points = []
    print("Enter the points (x and y for each point):")
    for i in range(m):
        x, y = map(int, input(f"Enter point {i + 1} (x y): ").split())
        points.append((x, y))

    for i in range(m):
        xi, yi = points[i]
        for j in range(i + 1, m):
            xj, yj = points[j]
            current_distance = distance[xi][xj] + distance[yi][yj]
            if current_distance > max_distance:
                max_distance = current_distance

    print("The maximum distance is:", max_distance)

if __name__ == "__main__":
    main()