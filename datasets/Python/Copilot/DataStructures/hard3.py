class TrieNode:
    def __init__(self):
        self.children = {}
        self.is_end_of_word = False

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        current = self.root
        for char in word:
            if char not in current.children:
                current.children[char] = TrieNode()
            current = current.children[char]
            if current.is_end_of_word:
                return False
        if current.children:
            return False
        current.is_end_of_word = True
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
    n = int(input("Enter the number of words: "))
    words = [input() for _ in range(n)]
    noPrefix(words)
