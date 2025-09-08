class SinglyLinkedListNode:
    def __init__(self, data):
        self.data = data
        self.next = None

def reversePrint(head):
    if head is None:
        return
    # Recursively print the rest of the list
    reversePrint(head.next)
    # Print the current node's data
    print(head.data)

# Input
t = int(input("Enter the number of test cases: "))
for _ in range(t):
    n = int(input("Enter the number of elements in the list: "))
    head = None
    prev = None
    for _ in range(n):
        data = int(input("Enter the data for the node: "))
        node = SinglyLinkedListNode(data)
        if head is None:
            head = node
        else:
            prev.next = node
        prev = node
    # Output
    reversePrint(head)