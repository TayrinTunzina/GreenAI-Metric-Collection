def getMax(operations):
    """
    Process stack operations and return results for type 3 queries (get maximum).
    
    Algorithm:
    - Use two stacks: main_stack for elements, max_stack for tracking maximums
    - For push: add to main_stack, add max(current_element, top_of_max_stack) to max_stack
    - For pop: remove from both stacks
    - For get_max: return top of max_stack
    """
    main_stack = []
    max_stack = []
    results = []
    
    for operation in operations:
        parts = operation.strip().split()
        op_type = int(parts[0])
        
        if op_type == 1:  # Push element
            x = int(parts[1])
            main_stack.append(x)
            
            # Update max_stack: new max is either current element or previous max
            if not max_stack:
                max_stack.append(x)
            else:
                max_stack.append(max(x, max_stack[-1]))
                
        elif op_type == 2:  # Pop element
            if main_stack:
                main_stack.pop()
                max_stack.pop()
                
        elif op_type == 3:  # Get maximum
            if max_stack:
                results.append(max_stack[-1])
    
    return results

def main():
    print("Enter the number of operations:")
    n = int(input())
    
    operations = []
    print(f"Enter {n} operations:")
    print("Format: '1 x' for push, '2' for pop, '3' for get max")
    
    for i in range(n):
        operation = input().strip()
        operations.append(operation)
    
    results = getMax(operations)
    
    print("\nResults for type 3 operations (get maximum):")
    for result in results:
        print(result)

if __name__ == "__main__":
    main()