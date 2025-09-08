def arrayManipulation(n, queries):
    arr = [0] * (n + 1)

    for a, b, k in queries:
        arr[a - 1] += k
        if b <= n:
            arr[b] -= k

    max_value = 0
    running_sum = 0

    for value in arr:
        running_sum += value
        if running_sum > max_value:
            max_value = running_sum

    return max_value

if __name__ == "__main__":
    n = int(input("Enter the number of elements in the array: "))
    m = int(input("Enter the number of operations: "))
    queries = []
    for _ in range(m):
        a = int(input("Enter the start index (a): "))
        b = int(input("Enter the end index (b): "))
        k = int(input("Enter the value to add (k): "))
        queries.append([a, b, k])

    result = arrayManipulation(n, queries)
    print("The maximum value in the array is:", result)
