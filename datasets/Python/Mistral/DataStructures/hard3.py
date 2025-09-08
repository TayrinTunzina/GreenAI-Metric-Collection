def noPrefix(words):
    words.sort()
    for i in range(len(words) - 1):
        if words[i+1].startswith(words[i]):
            print("BAD SET")
            print(words[i+1])
            return
    print("GOOD SET")

# Reading input manually
n = int(input("Enter the number of strings: "))
words = [input() for _ in range(n)]

noPrefix(words)
