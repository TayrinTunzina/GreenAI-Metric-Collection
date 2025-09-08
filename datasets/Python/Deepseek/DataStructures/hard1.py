def arrayManipulation(n, queries):
    # Initialize a difference array with zeros
    diff = [0] * (n + 2)
    
    # Process each query
    for a, b, k in queries:
        diff[a] += k
        if b + 1 <= n:
            diff[b + 1] -= k
    
    # Compute the prefix sum to get the final array
    max_value = 0
    current = 0
    for i in range(1, n + 1):
        current += diff[i]
        if current > max_value:
            max_value = current
    
    return max_value

# Manual input
n = int(input("Enter the size of the array (n): "))
num_queries = int(input("Enter the number of queries: "))

queries = []
for i in range(num_queries):
    print(f"Enter query {i+1} (a, b, k): ")
    a = int(input("Enter a: "))
    b = int(input("Enter b: "))
    k = int(input("Enter k: "))
    queries.append([a, b, k])

# Get the result
result = arrayManipulation(n, queries)
print("Maximum value after all operations:", result)