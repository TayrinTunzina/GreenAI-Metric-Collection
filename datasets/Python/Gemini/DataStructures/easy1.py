class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

def printLinkedList(head):


    current_node = head
    while current_node:
        print(current_node.data)
        current_node = current_node.next

if __name__ == "__main__":
    n = int(input("Enter the number of nodes: "))
    head = None
    for i in range(n):
        data = int(input("Enter data for node {}: ".format(i + 1)))
        new_node = Node(data)
        if head is None:
            head = new_node
        else:
            current_node = head
            while current_node.next:
                current_node = current_node.next
            current_node.next = new_node

    printLinkedList(head)
