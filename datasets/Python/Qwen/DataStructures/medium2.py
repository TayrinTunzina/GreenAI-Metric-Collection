def isBalanced(s):
    stack = []
    bracket_map = {')': '(', '}': '{', ']': '['}
    
    for char in s:
        if char in bracket_map.values():  # Opening bracket
            stack.append(char)
        elif char in bracket_map:  # Closing bracket
            if not stack or stack.pop() != bracket_map[char]:
                return "NO"
    
    return "YES" if not stack else "NO"

# Manual Input Handling
if __name__ == "__main__":
    n = int(input("Enter the number of strings: "))
    results = []
    for _ in range(n):
        s = input("Enter a string of brackets: ")
        results.append(isBalanced(s))
    
    print("\n".join(results))