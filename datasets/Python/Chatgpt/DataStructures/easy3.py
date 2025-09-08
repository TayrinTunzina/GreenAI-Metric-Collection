class SinglyLinkedListNode:
    def __init__(self, data):
        self.data = data
        self.next = None

def reversePrint(head):
    # Stack to store the values of the nodes
    stack = []
    
    # Traverse the list and push the data onto the stack
    current = head
    while current:
        stack.append(current.data)
        current = current.next
    
    # Print the elements in reverse order by popping from the stack
    while stack:
        print(stack.pop(), end=" ")
    print()

# Function to create a linked list from a list of values
def create_linked_list(values):
    if not values:
        return None
    
    head = SinglyLinkedListNode(values[0])
    current = head
    for value in values[1:]:
        current.next = SinglyLinkedListNode(value)
        current = current.next
    
    return head

# Input reading
t = int(input("Enter number of test cases: "))

for _ in range(t):
    n = int(input("Enter number of elements in the list: "))
    if n == 0:
        continue  # Skip if no elements in the list
    values = []
    for _ in range(n):
        values.append(int(input()))
    
    head = create_linked_list(values)
    reversePrint(head)
