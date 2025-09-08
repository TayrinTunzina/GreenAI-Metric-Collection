class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

def insert_manual():
    val = input("Enter node value (or press Enter for null): ")
    if val == "":
        return None
    node = Node(int(val))
    print(f"Left child of {node.data}:")
    node.left = insert_manual()
    print(f"Right child of {node.data}:")
    node.right = insert_manual()
    return node

def is_bst(node, min_val=float('-inf'), max_val=float('inf')):
    if node is None:
        return True
    if not (min_val < node.data < max_val):
        return False
    return is_bst(node.left, min_val, node.data) and is_bst(node.right, node.data, max_val)

root = insert_manual()
print("Yes" if is_bst(root) else "No")
