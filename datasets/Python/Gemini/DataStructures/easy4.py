def getMax(operations):
    """
    Processes a list of stack operations and returns the results of all '3' queries.
    """
    stack = []
    max_stack = []
    results = []

    for op in operations:
        parts = op.split()
        query_type = int(parts[0])

        if query_type == 1:
            # Push operation
            val = int(parts[1])
            stack.append(val)
            if not max_stack or val >= max_stack[-1]:
                max_stack.append(val)
        elif query_type == 2:
            # Pop operation
            if stack:
                popped = stack.pop()
                if popped == max_stack[-1]:
                    max_stack.pop()
        elif query_type == 3:
            # Get Max operation
            if max_stack:
                results.append(max_stack[-1])
    
    return results

if __name__ == '__main__':
    # Read number of operations
    n = int(input().strip())
    
    # Read all operations into a list
    ops = []
    for _ in range(n):
        ops.append(input().strip())
        
    # Get the results from the function
    res = getMax(ops)
    
    # Print each result on a new line
    for item in res:
        print(item)