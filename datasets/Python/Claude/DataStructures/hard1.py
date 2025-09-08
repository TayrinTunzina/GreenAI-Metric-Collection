def arrayManipulation(n, queries):
    # Initialize array with zeros
    arr = [0] * (n + 2)
    
    # Process all queries
    for query in queries:
        a, b, k = query
        # Add k at index a
        arr[a] += k
        # Subtract k at index b + 1
        arr[b + 1] -= k
    
    # Calculate maximum prefix sum
    max_value = 0
    running_sum = 0
    
    for i in range(1, n + 1):
        running_sum += arr[i]
        max_value = max(max_value, running_sum)
    
    return max_value

# Manual input processing
if __name__ == "__main__":
    n, m = map(int, input().split())
    queries = []
    for _ in range(m):
        queries.append(list(map(int, input().split())))
    
    result = arrayManipulation(n, queries)
    print(result)