class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

def reversePrint(head):
    """Reverses a linked list and prints its data values.

    Args:
        head: The head node of the linked list.
    """

    if head is None:
        return

    stack = []
    current = head
    while current:
        stack.append(current.data)
        current = current.next

    while stack:
        print(stack.pop())

if __name__ == "__main__":
    t = int(input("Enter the number of test cases: "))
    for _ in range(t):
        n = int(input("Enter the number of nodes: "))
        head = None
        for i in range(n):
            data = int(input("Enter data for node {}: ".format(i + 1)))
            new_node = Node(data)
            if head is None:
                head = new_node
            else:
                current_node = head
                while current_node.next:
                    current_node = current_node.next
                current_node.next = new_node
        reversePrint(head)
