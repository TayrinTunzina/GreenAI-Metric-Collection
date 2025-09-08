def flippingMatrix(matrix, n):
    max_sum = 0
    for i in range(n):
        for j in range(n):
            max_sum += max(matrix[i][j], matrix[i][2*n-1-j], matrix[2*n-1-i][j], matrix[2*n-1-i][2*n-1-j])
    return max_sum

# Read input
q = int(input("Enter the number of queries: "))
results = []

for _ in range(q):
    n = int(input(f"Enter the value of n for query {_ + 1}: "))
    matrix = []
    print(f"Enter the {2 * n} x {2 * n} matrix for query {_ + 1}:")
    for _ in range(2 * n):
        row = list(map(int, input().split()))
        matrix.append(row)
    results.append(flippingMatrix(matrix, n))

# Print results
print("Results:")
for result in results:
    print(result)
