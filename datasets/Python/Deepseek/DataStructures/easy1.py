class SinglyLinkedListNode:
    def __init__(self, data):
        self.data = data
        self.next = None

def printLinkedList(head):
    current = head
    while current:
        print(current.data)
        current = current.next

# Input
n = int(input("Enter the number of elements in the linked list: "))
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
printLinkedList(head)