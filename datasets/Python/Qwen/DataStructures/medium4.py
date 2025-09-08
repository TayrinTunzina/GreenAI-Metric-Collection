class TrieNode:
    def __init__(self):
        self.children = {}
        self.count = 0  # Number of contacts with prefix ending here

def contacts(queries):
    root = TrieNode()
    result = []
    
    for query in queries:
        op, s = query.split()
        node = root
        
        if op == "add":
            for char in s:
                if char not in node.children:
                    node.children[char] = TrieNode()
                node = node.children[char]
                node.count += 1  # Increment count for each prefix
        elif op == "find":
            found = True
            for char in s:
                if char not in node.children:
                    found = False
                    break
                node = node.children[char]
            result.append(node.count if found else 0)
    
    return result

# Read input
if __name__ == "__main__":
    n = int(input())
    queries = []
    for _ in range(n):
        queries.append(input().strip())
    
    # Process and print results
    results = contacts(queries)
    for res in results:
        print(res)