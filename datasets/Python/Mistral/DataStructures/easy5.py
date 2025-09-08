from collections import deque, defaultdict

def print_top_view():
    n = int(input())
    if n == 0:
        print()
        return

    nodes = list(map(int, input().split()))
    node_to_index = {val: idx for idx, val in enumerate(nodes)}
    root_val = nodes[0]

    # Build adjacency list for the tree
    adj = defaultdict(list)
    e = int(input())
    for _ in range(e):
        parent, child, lr = input().split()
        parent = int(parent)
        child = int(child)
        adj[parent].append((child, lr))

    # BFS setup: queue stores (node, HD)
    hd_map = {}
    queue = deque()
    queue.append((root_val, 0))

    while queue:
        node, hd = queue.popleft()
        if hd not in hd_map:
            hd_map[hd] = node

        for (child, lr) in adj.get(node, []):
            if lr == 'L':
                queue.append((child, hd - 1))
            else:
                queue.append((child, hd + 1))

    # Sort by HD and print
    for hd in sorted(hd_map.keys()):
        print(hd_map[hd], end=' ')
    print()

print_top_view()