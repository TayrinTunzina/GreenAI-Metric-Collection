class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

def is_bst(node, min_val=float('-inf'), max_val=float('inf')):
    if node is None:
        return True
    if not (min_val < node.data < max_val):
        return False
    return is_bst(node.left, min_val, node.data) and is_bst(node.right, node.data, max_val)

def insert_level_order(arr, root, i):
    if i < len(arr) and arr[i] != -1:
        root = Node(arr[i])
        root.left = insert_level_order(arr, root.left, 2 * i + 1)
        root.right = insert_level_order(arr, root.right, 2 * i + 2)
    return root

def main():
    arr = list(map(int, input("Enter the tree nodes in level order (use -1 for None): ").split()))
    root = None
    root = insert_level_order(arr, root, 0)
    print("Yes" if is_bst(root) else "No")

if __name__ == "__main__":
    main()
