def getMax(operations):
    stack = []
    max_stack = []
    result = []

    for op in operations:
        if op.startswith('1'):
            _, val = op.split()
            val = int(val)
            stack.append(val)
            if not max_stack or val >= max_stack[-1]:
                max_stack.append(val)
        elif op == '2':
            if stack:
                removed = stack.pop()
                if removed == max_stack[-1]:
                    max_stack.pop()
        elif op == '3':
            if max_stack:
                result.append(max_stack[-1])
    return result

# MAIN
n = int(input("Enter number of operations:\n"))
operations = [input() for _ in range(n)]

print("Output:")
for val in getMax(operations):
    print(val)
