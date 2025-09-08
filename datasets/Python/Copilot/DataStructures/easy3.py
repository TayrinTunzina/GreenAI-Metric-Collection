class SinglyLinkedListNode:
    def __init__(self, data):
        self.data = data
        self.next = None

def reversePrint(head):
    stack = []
    current = head
    while current:
        stack.append(current.data)
        current = current.next
    
    while stack:
        print(stack.pop(), end=" ")
    print()

# Helper function to create a linked list from input
def createLinkedList(n):
    head = None
    if n > 0:
        head = SinglyLinkedListNode(int(input()))
        current = head
        for _ in range(n - 1):
            new_node = SinglyLinkedListNode(int(input()))
            current.next = new_node
            current = new_node
    return head

# Taking input from the user
t = int(input())
for _ in range(t):
    n = int(input())
    head = createLinkedList(n)
    if head:
        reversePrint(head)
