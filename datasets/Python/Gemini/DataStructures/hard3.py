def noPrefix(words):
    """
    Checks if the given list of strings is a "GOOD SET".

    Args:
        words: A list of strings.

    Prints:
        "GOOD SET" if the set is good, 
        "BAD SET" followed by the offending string otherwise.
    """
    trie = {}
    for word in words:
        node = trie
        for char in word:
            if char not in node:
                node[char] = {}
            node = node[char]
            if '$' in node:  # Found a prefix
                print("BAD SET")
                print(word)
                return
        node['$'] = True  # Mark the end of the word
    print("GOOD SET")

if __name__ == "__main__":
    n = int(input())
    words = []
    for _ in range(n):
        words.append(input())
    noPrefix(words)
