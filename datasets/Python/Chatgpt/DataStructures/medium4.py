class TrieNode:
    def __init__(self):
        self.children = {}
        self.count = 0  # Number of words passing through this node

class Contacts:
    def __init__(self):
        self.root = TrieNode()

    def add(self, name):
        node = self.root
        for ch in name:
            if ch not in node.children:
                node.children[ch] = TrieNode()
            node = node.children[ch]
            node.count += 1

    def find(self, partial):
        node = self.root
        for ch in partial:
            if ch not in node.children:
                return 0
            node = node.children[ch]
        return node.count

# MAIN FUNCTION
def main():
    n = int(input("Enter number of operations: "))
    queries = [input() for _ in range(n)]

    contacts = Contacts()
    result = []

    for query in queries:
        op, *args = query.strip().split()
        if op == "add":
            contacts.add(args[0])
        elif op == "find":
            result.append(contacts.find(args[0]))

    print("Output:")
    for val in result:
        print(val)

main()
