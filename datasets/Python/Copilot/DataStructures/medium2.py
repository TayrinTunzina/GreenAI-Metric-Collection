def isBalanced(s):
    stack = []
    bracket_map = {')': '(', '}': '{', ']': '['}
    
    for char in s:
        if char in bracket_map.values():
            stack.append(char)
        elif char in bracket_map.keys():
            if stack == [] or bracket_map[char] != stack.pop():
                return "NO"
        else:
            continue
    return "YES" if stack == [] else "NO"

# Input and output handling
n = int(input("Enter the number of strings: "))
for _ in range(n):
    s = input("Enter the string of brackets: ")
    print(isBalanced(s))
