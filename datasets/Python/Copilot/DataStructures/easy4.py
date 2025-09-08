def getMax(operations):
    stack = []
    max_stack = []
    result = []

    for op in operations:
        if op.startswith("1"):
            _, val = op.split()
            val = int(val)
            stack.append(val)
            max_stack.append(val if not max_stack else max(val, max_stack[-1]))
        elif op == "2":
            if stack:
                stack.pop()
                max_stack.pop()
        elif op == "3":
            if max_stack:
                result.append(max_stack[-1])
    return result

# Manual Input
n = int(input("Enter number of operations: "))
operations = []
for _ in range(n):
    operations.append(input())
answers = getMax(operations)
print("Results of max queries:")
for val in answers:
    print(val)
