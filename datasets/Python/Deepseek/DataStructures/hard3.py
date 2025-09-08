class TrieNode:
    def __init__(self):
        self.children = {}
        self.is_end_of_word = False

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        node = self.root
        for char in word:
            if char not in node.children:
                node.children[char] = TrieNode()
            node = node.children[char]
            if node.is_end_of_word:
                return False
        node.is_end_of_word = True
        return True

def noPrefix(words):
    trie = Trie()
    for word in words:
        if not trie.insert(word):
            print("BAD SET")
            print(word)
            return
    print("GOOD SET")

# Manual input
n = int(input("Enter the number of words: "))
words = []
for i in range(n):
    word = input(f"Enter word {i+1}: ")
    words.append(word)

noPrefix(words)