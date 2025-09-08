def isBalanced(s):
    stack = []
    mapping = {')': '(', '}': '{', ']': '['}
    
    for char in s:
        if char in mapping:
            top_element = stack.pop() if stack else '#'
            if mapping[char] != top_element:
                return "NO"
        else:
            stack.append(char)
    
    return "YES" if not stack else "NO"

# Read the number of strings
n = int(input("Enter the number of strings: "))
results = []

# Process each string
for i in range(n):
    s = input(f"Enter string {i+1}: ").strip()
    results.append(isBalanced(s))

# Print the results
print("Results:")
for result in results:
    print(result)