def isBalanced(s):
    stack = []
    bracket_map = {')': '(', '}': '{', ']': '['}

    for char in s:
        if char in bracket_map.values():  # Opening brackets
            stack.append(char)
        elif char in bracket_map:  # Closing brackets
            if not stack or stack.pop() != bracket_map[char]:
                return "NO"
    
    return "YES" if not stack else "NO"

# Read input
n = int(input().strip())
for _ in range(n):
    s = input().strip()
    print(isBalanced(s))
