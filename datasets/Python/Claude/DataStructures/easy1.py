class SinglyLinkedListNode:
    def __init__(self, data):
        self.data = data
        self.next = None

def printLinkedList(head):
    current = head
    while current is not None:
        print(current.data)
        current = current.next

if __name__ == "__main__":
    # Read number of nodes
    n = int(input().strip())
    
    head = None
    tail = None
    
    # Create linked list from input
    for _ in range(n):
        data = int(input().strip())
        node = SinglyLinkedListNode(data)
        
        if head is None:
            head = node
            tail = node
        else:
            tail.next = node
            tail = node
    
    # Print the linked list
    printLinkedList(head)