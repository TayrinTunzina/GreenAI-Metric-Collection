class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

def isBSTUtil(node, min_val, max_val):
    # An empty tree is BST
    if node is None:
        return True
    
    # False if this node violates the min/max constraint
    if node.data < min_val or node.data > max_val:
        return False
    
    # Otherwise check the subtrees recursively
    # tightening the min or max constraint
    return (isBSTUtil(node.left, min_val, node.data - 1) and
            isBSTUtil(node.right, node.data + 1, max_val))

def isBST(root):
    return isBSTUtil(root, float('-inf'), float('inf'))

def insert_node():
    print("Enter node value (or -1 to skip): ")
    val = int(input())
    if val == -1:
        return None
    
    node = Node(val)
    print(f"Enter left child of {val}:")
    node.left = insert_node()
    print(f"Enter right child of {val}:")
    node.right = insert_node()
    
    return node

def main():
    print("Enter the binary tree:")
    print("Enter -1 for null nodes")
    root = insert_node()
    
    if isBST(root):
        print("Yes")
    else:
        print("No")

if __name__ == "__main__":
    main()