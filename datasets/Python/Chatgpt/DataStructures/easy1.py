class SinglyLinkedListNode:
    def __init__(self, data):
        self.data = data
        self.next = None

def printLinkedList(head):
    current = head
    while current:
        print(current.data)
        current = current.next

# Manually creating a linked list
n = int(input("Enter the number of elements in the linked list: "))

if n > 0:
    # Read the first element and create the head of the linked list
    head = SinglyLinkedListNode(int(input()))
    current = head

    # Read the rest of the elements
    for _ in range(1, n):
        current.next = SinglyLinkedListNode(int(input()))
        current = current.next

    # Print the linked list
    printLinkedList(head)
else:
    print("The list is empty.")
