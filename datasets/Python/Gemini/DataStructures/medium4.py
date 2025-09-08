class TrieNode:
    def __init__(self):
        # Children nodes for characters 'a'-'z'
        self.children = [None] * 26
        # Counter for words passing through this node
        self.count = 0

def contacts(queries):
    root = TrieNode()
    results = []

    for query in queries:
        operation, value = query.split()
        
        if operation == 'add':
            node = root
            for char in value:
                index = ord(char) - ord('a')
                if not node.children[index]:
                    node.children[index] = TrieNode()
                node = node.children[index]
                # Increment the counter for every node on the path
                node.count += 1
        
        elif operation == 'find':
            node = root
            found = True
            for char in value:
                index = ord(char) - ord('a')
                if not node.children[index]:
                    # Prefix does not exist
                    results.append(0)
                    found = False
                    break
                node = node.children[index]
            
            # If the full prefix was found, its count is the answer
            if found:
                results.append(node.count)
                
    return results

if __name__ == '__main__':
    n = int(input().strip())
    queries_list = []
    for _ in range(n):
        queries_list.append(input().strip())
        
    results = contacts(queries_list)
    
    for res in results:
        print(res)