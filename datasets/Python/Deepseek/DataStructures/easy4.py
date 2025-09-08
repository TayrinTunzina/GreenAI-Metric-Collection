def getMax(operations):
    stack = []
    max_stack = []
    result = []
    for op in operations:
        if op.startswith('1'):
            num = int(op.split()[1])
            stack.append(num)
            if not max_stack or num >= max_stack[-1]:
                max_stack.append(num)
        elif op == '2':
            if stack.pop() == max_stack[-1]:
                max_stack.pop()
        elif op == '3':
            result.append(max_stack[-1])
    return result

n = int(input())
operations = [input().strip() for _ in range(n)]
output = getMax(operations)
for num in output:
    print(num)