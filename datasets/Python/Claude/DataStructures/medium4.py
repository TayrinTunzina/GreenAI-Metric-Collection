class TrieNode:
    def __init__(self):
        self.children = {}  # Dictionary to store child nodes
        self.count = 0      # Count of words that pass through this node

class Trie:
    def __init__(self):
        self.root = TrieNode()
    
    def add(self, word):
        """Add a word to the trie and update counts"""
        node = self.root
        for char in word:
            if char not in node.children:
                node.children[char] = TrieNode()
            node = node.children[char]
            node.count += 1  # Increment count for each node in the path
    
    def find(self, prefix):
        """Find count of words starting with given prefix"""
        node = self.root
        for char in prefix:
            if char not in node.children:
                return 0  # Prefix not found
            node = node.children[char]
        return node.count

def contacts(queries):
    """
    Process contact operations and return results for find operations.
    
    Algorithm:
    - Use Trie data structure for efficient prefix searching
    - Each node stores count of words passing through it
    - add: Insert word into trie, increment counts along path
    - find: Traverse to prefix end, return count at that node
    """
    trie = Trie()
    results = []
    
    for query in queries:
        parts = query.strip().split(' ', 1)  # Split into at most 2 parts
        operation = parts[0]
        
        if operation == "add":
            name = parts[1]
            trie.add(name)
        elif operation == "find":
            partial = parts[1]
            count = trie.find(partial)
            results.append(count)
    
    return results

def main():
    print("Enter the number of operations:")
    n = int(input())
    
    queries = []
    print(f"Enter {n} operations:")
    print("Format: 'add name' or 'find partial'")
    
    for i in range(n):
        query = input().strip()
        queries.append(query)
    
    results = contacts(queries)
    
    print("\nResults for find operations:")
    for result in results:
        print(result)

if __name__ == "__main__":
    main()