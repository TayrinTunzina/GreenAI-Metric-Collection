class TrieNode:
    def __init__(self):
        self.children = {}
        self.count = 0

class Contacts:
    def __init__(self):
        self.root = TrieNode()

    def add(self, name):
        node = self.root
        for char in name:
            if char not in node.children:
                node.children[char] = TrieNode()
            node = node.children[char]
            node.count += 1

    def find(self, partial):
        node = self.root
        for char in partial:
            if char not in node.children:
                return 0
            node = node.children[char]
        return node.count

# Manual Input
n = int(input("Enter number of operations: "))
contacts = Contacts()
results = []
for _ in range(n):
    parts = input().split()
    if parts[0] == 'add':
        contacts.add(parts[1])
    elif parts[0] == 'find':
        results.append(contacts.find(parts[1]))

print("Results:")
for res in results:
    print(res)
