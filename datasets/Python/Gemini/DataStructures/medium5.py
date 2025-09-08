import collections

class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

def is_bst_helper(node, min_val, max_val):
    if node is None:
        return True

    # Check if the current node's data is within the valid range
    if not (min_val < node.data < max_val):
        return False

    # Recursively check left subtree: update max_val to current node's data
    # Recursively check right subtree: update min_val to current node's data
    return (is_bst_helper(node.left, min_val, node.data) and
            is_bst_helper(node.right, node.data, max_val))

def is_binary_search_tree(root):
    # Initialize with negative and positive infinity for the root's range
    return is_bst_helper(root, float('-inf'), float('inf'))

def build_tree_from_input():
    print("Enter tree nodes in level order (BFS), separated by spaces.")
    print("Use 'null' for missing children (e.g., 3 5 2 1 4 6 null):")
    input_line = input().strip().split()

    if not input_line or input_line[0].lower() == 'null':
        return None

    root_data = int(input_line[0])
    root = Node(root_data)
    queue = collections.deque([root])
    i = 1

    while queue and i < len(input_line):
        current_node = queue.popleft()

        # Left child
        if i < len(input_line) and input_line[i].lower() != 'null':
            left_data = int(input_line[i])
            current_node.left = Node(left_data)
            queue.append(current_node.left)
        i += 1

        # Right child
        if i < len(input_line) and input_line[i].lower() != 'null':
            right_data = int(input_line[i])
            current_node.right = Node(right_data)
            queue.append(current_node.right)
        i += 1
    return root

if __name__ == "__main__":
    root = build_tree_from_input()
    if is_binary_search_tree(root):
        print("Yes")
    else:
        print("No")