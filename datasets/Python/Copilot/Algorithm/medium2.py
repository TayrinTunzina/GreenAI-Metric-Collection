def flippingMatrix(matrix):
    n = len(matrix) // 2
    max_sum = 0
    for i in range(n):
        for j in range(n):
            max_sum += max(matrix[i][j], matrix[i][2*n - j - 1], matrix[2*n - i - 1][j], matrix[2*n - i - 1][2*n - j - 1])
    return max_sum

# Taking input from the user
q = int(input("Enter the number of queries: "))
for _ in range(q):
    n = int(input())
    matrix = []
    for _ in range(2 * n):
        matrix.append(list(map(int, input().split())))
    print(flippingMatrix(matrix))
