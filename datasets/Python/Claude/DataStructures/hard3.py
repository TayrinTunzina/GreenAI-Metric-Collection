class TrieNode:
    def __init__(self):
        self.children = {}
        self.is_end = False

class Trie:
    def __init__(self):
        self.root = TrieNode()
    
    def insert_and_check(self, word):
        current = self.root
        # Check if this word is a prefix of any existing word
        for char in word:
            if char not in current.children:
                current.children[char] = TrieNode()
            current = current.children[char]
            # If we hit a word end while still having characters, it's a prefix
            if current.is_end:
                return True
                
        # Mark current node as end of word
        current.is_end = True
        
        # Check if this word is a prefix of any existing word
        return len(current.children) > 0

def noPrefix(words):
    trie = Trie()
    
    for word in words:
        if trie.insert_and_check(word):
            print("BAD SET")
            print(word)
            return
            
    print("GOOD SET")

if __name__ == '__main__':
    n = int(input().strip())
    words = []
    
    for _ in range(n):
        words_item = input().strip()
        words.append(words_item)
    
    noPrefix(words)