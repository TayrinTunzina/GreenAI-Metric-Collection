from collections import deque

class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None

def main():
    # Read number of nodes
    try:
        n = int(input().strip())
    except:
        print()
        return

    if n == 0:
        print()
        return

    # Read node values
    values = list(map(int, input().split()))

    # Create node map
    node_map = {val: TreeNode(val) for val in values}

    # Read number of edges
    try:
        e = int(input().strip())
    except:
        # If no edges, only root exists
        print(values[0])
        return

    children_set = set()

    # Read each edge
    for _ in range(e):
        try:
            parts = input().split()
            if len(parts) != 3:
                continue
            parent_val = int(parts[0])
            child_val = int(parts[1])
            direction = parts[2]

            if parent_val not in node_map or child_val not in node_map:
                continue

            parent_node = node_map[parent_val]
            child_node = node_map[child_val]

            if direction == 'L':
                parent_node.left = child_node
            elif direction == 'R':
                parent_node.right = child_node

            children_set.add(child_val)
        except Exception:
            continue

    # Find root: the node not in children_set
    root = None
    for val in values:
        if val not in children_set:
            root = node_map[val]
            break

    if root is None:
        # Fallback: use first node if no root found (shouldn't happen in valid input)
        root = node_map[values[0]]

    # BFS for top view
    hd_map = {}  # horizontal distance -> node value
    queue = deque([(root, 0)])  # (node, hd)

    while queue:
        node, hd = queue.popleft()
        # Only record first node at this horizontal distance
        if hd not in hd_map:
            hd_map[hd] = node.val

        if node.left:
            queue.append((node.left, hd - 1))
        if node.right:
            queue.append((node.right, hd + 1))

    # Output from left to right (sorted by hd)
    sorted_hds = sorted(hd_map.keys())
    result = [str(hd_map[hd]) for hd in sorted_hds]
    print(' '.join(result))

if __name__ == "__main__":
    main()