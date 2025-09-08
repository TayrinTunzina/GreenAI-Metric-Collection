class TrieNode:
    def __init__(self):
        self.children = {}
        self.is_end = False  # Marks end of a word

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        node = self.root
        for char in word:
            if char not in node.children:
                node.children[char] = TrieNode()
            node = node.children[char]
            if node.is_end:  # If prefix already exists
                return False
        if node.children:  # If current word is a prefix of an existing word
            return False
        node.is_end = True
        return True

def noPrefix(words):
    trie = Trie()
    for word in words:
        if not trie.insert(word):
            print("BAD SET")
            print(word)
            return
    print("GOOD SET")

if __name__ == "__main__":
    n = int(input().strip())
    words = [input().strip() for _ in range(n)]
    noPrefix(words)
