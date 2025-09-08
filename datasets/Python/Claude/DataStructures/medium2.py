# Python Solution
def isBalanced(s):
    stack = []
    brackets = {')': '(', ']': '[', '}': '{'}
    
    for char in s:
        if char in '([{':
            stack.append(char)
        elif char in ')]}':
            if not stack or stack.pop() != brackets[char]:
                return "NO"
    
    return "YES" if not stack else "NO"

# Manual input handling
def main():
    n = int(input())
    for _ in range(n):
        s = input().strip()
        print(isBalanced(s))

if __name__ == "__main__":
    main()