def isBalanced(s):
    stack = []
    mapping = {')': '(', '}': '{', ']': '['}
    for char in s:
        if char in ['(', '{', '[']:
            stack.append(char)
        elif char in [')', '}', ']']:
            if not stack or stack.pop() != mapping[char]:
                return "NO"
    return "YES" if not stack else "NO"

if __name__ == "__main__":
    t = int(input())
    for t_itr in range(t):
        s = input()
        result = isBalanced(s)
        print(result)
