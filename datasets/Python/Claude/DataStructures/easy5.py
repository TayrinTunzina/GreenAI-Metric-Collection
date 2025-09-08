from collections import deque, defaultdict

class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None

def build_tree(nodes, edges):
    if not nodes:
        return None
    
    # Create node objects
    node_map = {}
    for val in nodes:
        node_map[val] = TreeNode(val)
    
    # Find root (node that doesn't appear as a child)
    children = set()
    parents = set()
    
    for parent_val, child_val, direction in edges:
        parents.add(parent_val)
        children.add(child_val)
        
        if direction == 'L':
            node_map[parent_val].left = node_map[child_val]
        else:  # direction == 'R'
            node_map[parent_val].right = node_map[child_val]
    
    # Root is in parents but not in children
    root_val = None
    for parent in parents:
        if parent not in children:
            root_val = parent
            break
    
    # If no edges, first node is root
    if root_val is None and nodes:
        root_val = nodes[0]
    
    return node_map.get(root_val)

def top_view(root):
    if not root:
        return []
    
    # Dictionary to store the first node at each horizontal distance
    top_view_map = {}
    
    # Queue for level order traversal: (node, horizontal_distance)
    queue = deque([(root, 0)])
    
    while queue:
        node, hd = queue.popleft()
        
        # If this horizontal distance is seen for the first time,
        # this node is part of top view
        if hd not in top_view_map:
            top_view_map[hd] = node.val
        
        # Add left child with hd-1
        if node.left:
            queue.append((node.left, hd - 1))
        
        # Add right child with hd+1
        if node.right:
            queue.append((node.right, hd + 1))
    
    # Sort by horizontal distance and return values
    result = []
    for hd in sorted(top_view_map.keys()):
        result.append(top_view_map[hd])
    
    return result

def main():
    # Read number of nodes
    n = int(input())
    
    if n == 0:
        print()
        return
    
    # Read node values
    nodes = list(map(int, input().split()))
    
    # Read number of edges
    e = int(input())
    
    # Read edges
    edges = []
    for _ in range(e):
        line = input().split()
        parent = int(line[0])
        child = int(line[1])
        direction = line[2]
        edges.append((parent, child, direction))
    
    # Build tree
    root = build_tree(nodes, edges)
    
    # Get top view
    result = top_view(root)
    
    # Print result
    print(' '.join(map(str, result)))

if __name__ == "__main__":
    main()