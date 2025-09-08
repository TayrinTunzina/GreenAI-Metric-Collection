class SinglyLinkedListNode:
    def __init__(self, data):
        self.data = data
        self.next = None

def printLinkedList(head: SinglyLinkedListNode) -> None:
    current = head
    while current:
        print(current.data)
        current = current.next

def createLinkedList(n: int) -> SinglyLinkedListNode:
    if n == 0:
        return None
    head = SinglyLinkedListNode(int(input()))
    current = head
    for _ in range(n - 1):
        new_node = SinglyLinkedListNode(int(input()))
        current.next = new_node
        current = new_node
    return head

# Taking input from the user
n = int(input("Enter the number of nodes in the linked list: "))
head = createLinkedList(n)
printLinkedList(head)
