def getMax(operations):
    stack = []
    max_stack = []  # To keep track of maximum elements
    result = []
    
    for operation in operations:
        if operation[0] == '1':
            # Push operation
            x = int(operation[2:])
            stack.append(x)
            if not max_stack or x >= max_stack[-1]:
                max_stack.append(x)
        elif operation[0] == '2':
            # Pop operation
            if stack:
                popped = stack.pop()
                if max_stack and popped == max_stack[-1]:
                    max_stack.pop()
        elif operation[0] == '3':
            # Print maximum
            if max_stack:
                result.append(max_stack[-1])
    
    return result

# Read input and solve
if __name__ == "__main__":
    n = int(input())
    operations = []
    for _ in range(n):
        operations.append(input().strip())
    
    result = getMax(operations)
    for res in result:
        print(res)