from collections import deque

class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

def build_tree(nodes, edges):
    if not nodes:
        return None
    
    node_map = {val: Node(val) for val in nodes}
    
    # Assuming the first node in the list is the root
    root = node_map[nodes[0]]
    
    for parent, child, direction in edges:
        parent_node = node_map.get(parent)
        child_node = node_map.get(child)
        
        if parent_node and child_node:
            if direction == 'L':
                parent_node.left = child_node
            elif direction == 'R':
                parent_node.right = child_node
    
    return root

def top_view(root):
    if not root:
        return
    
    queue = deque([(root, 0)]) # (node, horizontal_distance)
    hd_map = {}
    
    while queue:
        node, hd = queue.popleft()
        
        # If this horizontal distance is seen for the first time, add it to the map
        if hd not in hd_map:
            hd_map[hd] = node.data
            
        if node.left:
            queue.append((node.left, hd - 1))
        
        if node.right:
            queue.append((node.right, hd + 1))
    
    # Sort the horizontal distances to print in order
    sorted_hds = sorted(hd_map.keys())
    
    result = [hd_map[hd] for hd in sorted_hds]
    print(*result)

def main():
    try:
        n_str = input()
        if not n_str.strip():
            n = 0
        else:
            n = int(n_str)
        
        if n == 0:
            print()
            return

        nodes = list(map(int, input().split()))
        
        e = int(input())
        
        edges = []
        for _ in range(e):
            parent, child, direction = input().split()
            edges.append((int(parent), int(child), direction))
            
        root = build_tree(nodes, edges)
        top_view(root)
    except (IOError, ValueError):
        # Handles cases with no nodes and other parsing errors gracefully
        print()

if __name__ == "__main__":
    main()