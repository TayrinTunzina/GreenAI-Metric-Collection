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
            # If the character is not in the children, add it
            if char not in node.children:
                node.children[char] = TrieNode()
            node = node.children[char]
            # Check if the current node is the end of another word (prefix conflict)
            if node.is_end_of_word:
                return False
        # If the current word is a prefix of another word, return False
        if node.children:
            return False
        # Mark the end of the current word
        node.is_end_of_word = True
        return True

def main():
    # Prompt the user to enter the number of words
    n = int(input("Enter the number of words: "))
    
    # Initialize an empty list to store the words
    words = []
    
    # Collect the words one by one from the user
    for i in range(n):
        word = input(f"Enter word {i + 1}: ").strip()  # Strip any extra whitespace
        words.append(word)
    
    # Create a Trie and insert the words
    trie = Trie()
    for word in words:
        if not trie.insert(word):
            # If there's a conflict, print "BAD SET" and the conflicting word
            print(f"BAD SET\n{word}")
            return
    
    # If all words are inserted successfully, print "GOOD SET"
    print("GOOD SET")

# Run the program
if __name__ == "__main__":
    main()