from collections import deque

class TreeNode:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

def checkBST(root):
    def validate(node, min_val, max_val):
        if not node:
            return True
        
        if node.data <= min_val or node.data >= max_val:
            return False
        
        return (validate(node.left, min_val, node.data) and 
                validate(node.right, node.data, max_val))
    
    return validate(root, float('-inf'), float('inf'))

def build_tree_from_input():
    print("Enter the tree nodes level by level (use -1 for null nodes):")
    print("Example: 3 5 2 1 4 6 -1 -1 -1 -1 -1 -1 -1")
    
    values = list(map(int, input().split()))
    
    if not values or values[0] == -1:
        return None
    
    root = TreeNode(values[0])
    queue = deque([root])
    i = 1
    
    while queue and i < len(values):
        node = queue.popleft()
        
        # Left child
        if i < len(values) and values[i] != -1:
            node.left = TreeNode(values[i])
            queue.append(node.left)
        i += 1
        
        # Right child
        if i < len(values) and values[i] != -1:
            node.right = TreeNode(values[i])
            queue.append(node.right)
        i += 1
    
    return root

def print_tree(root, level=0, prefix="Root: "):
    if root is not None:
        print(" " * (level * 4) + prefix + str(root.data))
        if root.left is not None or root.right is not None:
            print_tree(root.left, level + 1, "L--- ")
            print_tree(root.right, level + 1, "R--- ")

# Main execution
if __name__ == "__main__":
    root = build_tree_from_input()
    
    if root:
        print("\nBuilt tree:")
        print_tree(root)
        
        result = checkBST(root)
        print(f"\nIs BST: {'Yes' if result else 'No'}")
    else:
        print("Empty tree - considered valid BST: Yes")