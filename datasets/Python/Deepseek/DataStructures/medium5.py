from collections import deque

class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

def build_tree(arr):
    if not arr or arr[0] == -1:
        return None
    root = Node(arr[0])
    q = deque([root])
    index = 1
    while q and index < len(arr):
        current = q.popleft()
        if index < len(arr) and arr[index] != -1:
            current.left = Node(arr[index])
            q.append(current.left)
        index += 1
        if index < len(arr) and arr[index] != -1:
            current.right = Node(arr[index])
            q.append(current.right)
        index += 1
    return root

def is_bst(root):
    stack = []
    current = root
    prev = None
    while current or stack:
        while current:
            stack.append(current)
            current = current.left
        current = stack.pop()
        if prev and current.data <= prev.data:
            return False
        prev = current
        current = current.right
    return True

print("Enter the tree in level-order (use -1 for null nodes): ")
arr = list(map(int, input().strip().split()))
root = build_tree(arr)
print("Yes" if is_bst(root) else "No")