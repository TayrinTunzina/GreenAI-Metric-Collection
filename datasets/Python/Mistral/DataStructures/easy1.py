class SinglyLinkedListNode:
    def __init__(self, data):
        self.data = data
        self.next = None

def printLinkedList(head):
    current = head
    while current:
        print(current.data)
        current = current.next

def createLinkedList(values):
    if not values:
        return None
    head = SinglyLinkedListNode(values[0])
    current = head
    for value in values[1:]:
        current.next = SinglyLinkedListNode(value)
        current = current.next
    return head

def main():
    # Manually input the number of elements and the elements themselves
    n = int(input("Enter the number of elements in the linked list: "))
    elements = [int(input("Enter an element: ")) for _ in range(n)]

    # Create the linked list from the input elements
    head = createLinkedList(elements)

    # Print the linked list
    printLinkedList(head)

if __name__ == "__main__":
    main()