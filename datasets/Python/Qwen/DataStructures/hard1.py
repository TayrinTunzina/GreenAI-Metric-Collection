def arrayManipulation(n, queries):
    # Step 1: Initialize the difference array
    diff = [0] * (n + 2)
    
    # Step 2: Process all queries
    for a, b, k in queries:
        diff[a] += k
        if b + 1 <= n:
            diff[b + 1] -= k
    
    # Step 3: Compute prefix sums and find the maximum value
    max_value = 0
    current_sum = 0
    for i in range(1, n + 1):
        current_sum += diff[i]
        max_value = max(max_value, current_sum)
    
    return max_value

# Input handling
if __name__ == "__main__":
    # Read n and m
    n, m = map(int, input("Enter the size of the array (n) and number of operations (m): ").split())
    queries = []
    
    print("Enter the queries (each line as 'a b k'):")
    for _ in range(m):
        a, b, k = map(int, input().split())
        queries.append((a, b, k))
    
    # Call the function and print the result
    result = arrayManipulation(n, queries)
    print("The maximum value in the array is:", result)