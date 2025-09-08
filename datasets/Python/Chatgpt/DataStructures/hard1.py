def arrayManipulation(n, queries):
    arr = [0] * (n + 2)  # Extra space to handle b+1 index

    # Apply difference array technique
    for a, b, k in queries:
        arr[a] += k
        arr[b + 1] -= k

    # Find the maximum value using prefix sum
    max_value = 0
    current_value = 0
    for value in arr:
        current_value += value
        max_value = max(max_value, current_value)

    return max_value

# Read input
n, m = map(int, input().split())
queries = [tuple(map(int, input().split())) for _ in range(m)]
print(arrayManipulation(n, queries))
