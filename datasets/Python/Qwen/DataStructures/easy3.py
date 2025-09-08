class SinglyLinkedListNode:
    def __init__(self, data):
        self.data = data
        self.next = None

def reversePrint(head):
    if head is None:
        return
    # Use recursion to print in reverse order
    reversePrint(head.next)
    print(head.data)

# Input handling
t = int(input("Enter number of test cases: "))
for _ in range(t):
    n = int(input("Enter number of elements in the list: "))
    if n == 0:
        head = None
    else:
        head = SinglyLinkedListNode(int(input("Enter element: ")))
        current = head
        for _ in range(n - 1):
            current.next = SinglyLinkedListNode(int(input("Enter element: ")))
            current = current.next
    # Call reversePrint
    reversePrint(head)