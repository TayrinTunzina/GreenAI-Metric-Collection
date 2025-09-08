class SinglyLinkedListNode:
    def __init__(self, data):
        self.data = data
        self.next = None

def printLinkedList(head):
    # Traverse the linked list starting from the head
    current = head
    while current is not None:
        print(current.data)  # Print the data of the current node
        current = current.next  # Move to the next node

# Manually create the linked list based on user input
if __name__ == "__main__":
    n = int(input("Enter the number of elements in the linked list: "))
    if n == 0:
        head = None  # Empty list
    else:
        # Create the head node
        head_data = int(input("Enter the data for the first node: "))
        head = SinglyLinkedListNode(head_data)
        current = head

        # Add remaining nodes
        for _ in range(1, n):
            data = int(input("Enter the data for the next node: "))
            new_node = SinglyLinkedListNode(data)
            current.next = new_node
            current = new_node

    # Call the function to print the linked list
    printLinkedList(head)