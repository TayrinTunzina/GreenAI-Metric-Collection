class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

def isBST(node, min_val=float('-inf'), max_val=float('inf')):
    if node is None:
        return True
    if not (min_val < node.data < max_val):
        return False
    return (isBST(node.left, min_val, node.data) and 
            isBST(node.right, node.data, max_val))

def buildTree():
    from collections import deque
    print("Enter the binary tree nodes in level order (use -1 for null):")
    arr = list(map(int, input().split()))
    if not arr or arr[0] == -1:
        return None

    root = Node(arr[0])
    q = deque([root])
    idx = 1
    while q and idx < len(arr):
        current = q.popleft()

        if idx < len(arr) and arr[idx] != -1:
            current.left = Node(arr[idx])
            q.append(current.left)
        idx += 1

        if idx < len(arr) and arr[idx] != -1:
            current.right = Node(arr[idx])
            q.append(current.right)
        idx += 1

    return root

if __name__ == "__main__":
    root = buildTree()
    print("Yes" if isBST(root) else "No")
