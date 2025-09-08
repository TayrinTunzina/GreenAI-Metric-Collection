def max_si(arr):
    stack = []
    max_xor = 0

    for num in arr:
        while stack and stack[-1] < num:
            max_xor = max(max_xor, stack[-1] ^ num)
            stack.pop()
        if stack:
            max_xor = max(max_xor, stack[-1] ^ num)
        stack.append(num)

    return max_xor

# Manual input
N = int(input("Enter N: "))
A = list(map(int, input("Enter array elements: ").split()))
print(max_si(A))