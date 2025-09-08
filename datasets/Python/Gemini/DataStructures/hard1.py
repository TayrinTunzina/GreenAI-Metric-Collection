def arrayManipulation(n, queries):
    arr = [0] * (n + 1)  # Create an array of zeros

    for a, b, k in queries:
        arr[a - 1] += k  # Add k to the starting index
        if b < n:
            arr[b] -= k  # Subtract k from the next index after the end

    max_val = 0
    temp_sum = 0
    for i in range(n):
        temp_sum += arr[i]
        max_val = max(max_val, temp_sum)

    return max_val

if __name__ == "__main__":
    n, m = map(int, input().split())
    queries = []
    for _ in range(m):
        queries.append(list(map(int, input().split())))
    result = arrayManipulation(n, queries)
    print(result)