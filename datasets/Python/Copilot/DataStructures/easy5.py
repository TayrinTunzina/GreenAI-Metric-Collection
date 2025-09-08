from collections import deque

class Node:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None

def build_tree(n, values, e, edges):
    if n == 0:
        return None
    nodes = {val: Node(val) for val in values}
    for parent, child, lr in edges:
        if parent not in nodes or child not in nodes:
            continue  # skip invalid references
        if lr == 'L':
            nodes[parent].left = nodes[child]
        elif lr == 'R':
            nodes[parent].right = nodes[child]
    return nodes[values[0]]

def top_view(root):
    if not root:
        return
    q = deque([(root, 0)])
    hd_map = {}
    while q:
        node, hd = q.popleft()
        if hd not in hd_map:
            hd_map[hd] = node.val
        if node.left:
            q.append((node.left, hd - 1))
        if node.right:
            q.append((node.right, hd + 1))
    for hd in sorted(hd_map):
        print(hd_map[hd], end=' ')
    print()

# Input
try:
    n = int(input("Enter number of nodes: "))
    if n == 0:
        print("No nodes in the tree.")
    else:
        values = list(map(int, input("Enter node values: ").split()))
        e = int(input("Enter number of edges: "))
        edges = []
        for _ in range(e):
            parts = input("Enter edge (parent child L/R): ").split()
            if len(parts) == 3 and parts[2] in ('L', 'R'):
                edges.append((int(parts[0]), int(parts[1]), parts[2]))
        root = build_tree(n, values, e, edges)
        print("Top view of the tree:")
        top_view(root)
except Exception as ex:
    print("Invalid input:", ex)