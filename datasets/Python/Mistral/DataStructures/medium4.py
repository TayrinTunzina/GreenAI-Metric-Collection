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

def contacts(queries):
    contacts_app = Contacts()
    results = []
    for query in queries:
        if query.startswith('add'):
            name = query.split()[1]
            contacts_app.add(name)
        elif query.startswith('find'):
            partial = query.split()[1]
            results.append(contacts_app.find(partial))
    return results

def main():
    n = int(input("Enter the number of operations: "))
    queries = []
    for _ in range(n):
        queries.append(input("Enter operation: "))
    results = contacts(queries)
    for result in results:
        print(result)

if __name__ == "__main__":
    main()
