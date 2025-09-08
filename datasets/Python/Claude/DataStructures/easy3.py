class SinglyLinkedListNode:
    def __init__(self, data):
        self.data = data
        self.next = None

def reversePrint(head):
    # Base case: if list is empty
    if head is None:
        return
    
    # Recursive approach
    reversePrint(head.next)
    print(head.data, end=" ")

# Driver code for Python
if __name__ == '__main__':
    t = int(input("Enter number of test cases: "))
    
    for _ in range(t):
        n = int(input("Enter number of elements: "))
        
        # Create the linked list
        head = None
        tail = None
        
        for i in range(n):
            data = int(input())
            node = SinglyLinkedListNode(data)
            
            if head is None:
                head = node
            else:
                tail.next = node
            tail = node
            
        reversePrint(head)
        print()  # New line after each test case