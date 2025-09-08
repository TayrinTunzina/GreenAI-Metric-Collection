from collections import deque

class Node:
    def __init__(self, value):
        self.value = value
        self.left = None
        self.right = None

def print_top_view(root):
    if root is None:
        return
    
    # Dictionary to store the first node at each horizontal distance
    top_view = {}
    # Queue for level order traversal: stores (node, horizontal distance)
    queue = deque()
    queue.append((root, 0))
    
    while queue:
        node, hd = queue.popleft()
        
        # If the HD is encountered for the first time, add to dictionary
        if hd not in top_view:
            top_view[hd] = node.value
        
        if node.left:
            queue.append((node.left, hd - 1))
        if node.right:
            queue.append((node.right, hd + 1))
    
    # Sort the dictionary by HD and print the values
    for hd in sorted(top_view.keys()):
        print(top_view[hd], end=" ")
    print()

def main():
    n = int(input())
    if n == 0:
        return
    values = list(map(int, input().split()))
    e = int(input())
    
    # Create nodes
    nodes = {value: Node(value) for value in values}
    root = nodes[values[0]]  # Assuming the first value is the root unless specified otherwise
    
    for _ in range(e):
        parent_val, child_val, direction = input().split()
        parent = nodes[int(parent_val)]
        child = nodes[int(child_val)]
        if direction == 'L':
            parent.left = child
        else:
            parent.right = child
    
    print_top_view(root)

if __name__ == "__main__":
    main()