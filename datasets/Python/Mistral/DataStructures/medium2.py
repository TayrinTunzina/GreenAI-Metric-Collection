def isBalanced(s):
    stack = []
    matching_bracket = {')': '(', ']': '[', '}': '{'}
    for char in s:
        if char in matching_bracket.values():
            stack.append(char)
        elif char in matching_bracket.keys():
            if stack == [] or matching_bracket[char] != stack.pop():
                return "NO"
        else:
            return "NO"
    return "YES" if not stack else "NO"

if __name__ == "__main__":
    n = int(input("Enter the number of strings: "))
    results = []
    for _ in range(n):
        s = input("Enter a string of brackets: ")
        results.append(isBalanced(s))
    for result in results:
        print(result)
