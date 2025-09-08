def getMax(operations):
    stack = []
    max_stack = []
    output = []

    for operation in operations:
        parts = operation.split()
        if parts[0] == '1':
            x = int(parts[1])
            stack.append(x)
            if not max_stack or x >= max_stack[-1]:
                max_stack.append(x)
        elif parts[0] == '2':
            if stack:
                popped = stack.pop()
                if max_stack and popped == max_stack[-1]:
                    max_stack.pop()
        elif parts[0] == '3':
            if max_stack:
                output.append(max_stack[-1])

    return output

def main():
    n = int(input("Enter the number of operations: "))
    operations = []
    for _ in range(n):
        operations.append(input("Enter operation: "))
    results = getMax(operations)
    for result in results:
        print(result)

if __name__ == "__main__":
    main()
