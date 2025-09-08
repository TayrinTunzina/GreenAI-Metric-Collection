def arrayManipulation(n, queries):
    arr = [0] * (n + 1)

    for a, b, k in queries:
        arr[a - 1] += k
        if b < n:
            arr[b] -= k

    max_value = x = 0
    for i in arr:
        x += i
        if x > max_value:
            max_value = x

    return max_value

if __name__ == "__main__":
    n, m = map(int, input("Enter the size of the array and the number of operations: ").split())
    queries = []
    for _ in range(m):
        a, b, k = map(int, input(f"Enter the operation (a b k) for operation {_ + 1}: ").split())
        queries.append([a, b, k])
    print("The maximum value in the resultant array is:", arrayManipulation(n, queries))
