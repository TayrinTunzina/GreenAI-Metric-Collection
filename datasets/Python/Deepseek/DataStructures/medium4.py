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
    contact_list = Contacts()
    results = []
    for query in queries:
        parts = query.split()
        if parts[0] == 'add':
            contact_list.add(parts[1])
        elif parts[0] == 'find':
            results.append(contact_list.find(parts[1]))
    return results

if __name__ == '__main__':
    n = int(input())
    queries = [input().strip() for _ in range(n)]
    output = contacts(queries)
    for result in output:
        print(result)