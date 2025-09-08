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
        print(stack.pop(), end=' ')
    print()

if __name__ == "__main__":
    t = int(input("Enter the number of test cases: "))
    for _ in range(t):
        n = int(input("Enter the number of elements in the list: "))
        head = None
        tail = None
        for _ in range(n):
            data = int(input("Enter the data element: "))
            new_node = SinglyLinkedListNode(data)
            if head is None:
                head = new_node
                tail = new_node
            else:
                tail.next = new_node
                tail = new_node
        reversePrint(head)
