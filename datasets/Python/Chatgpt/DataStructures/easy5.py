from collections import deque

class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

def build_tree_manual():
    n = int(input("Enter number of nodes: "))
    if n == 0:
        return None
    print("Enter node values (unique IDs):")
    node_vals = list(map(int, input().split()))
    if len(node_vals) != n:
        print("Error: number of values doesn't match node count")
        return None
    nodes = {val: Node(val) for val in node_vals}

    e = int(input("Enter number of edges: "))
    if e > n - 1:
        print("Error: too many edges")
        return None
    print("Enter edges in format: parent child L/R")
    for _ in range(e):
        p, c, d = input().split()
        p, c = int(p), int(c)
        if p not in nodes or c not in nodes:
            print("Error: invalid node ID")
            return None
        if d.upper() == 'L':
            nodes[p].left = nodes[c]
        elif d.upper() == 'R':
            nodes[p].right = nodes[c]
        else:
            print("Error: direction must be L or R")
            return None
    return nodes[node_vals[0]]

def topView(root):
    if not root:
        return
    q = deque([(root, 0)])
    hd_map = {}
    while q:
        node, hd = q.popleft()
        if hd not in hd_map:
            hd_map[hd] = node.data
        if node.left:
            q.append((node.left, hd - 1))
        if node.right:
            q.append((node.right, hd + 1))
    for hd in sorted(hd_map):
        print(hd_map[hd], end=' ')
    print()

# ---- TESTING ----
if __name__ == "__main__":
    root = build_tree_manual()
    topView(root)