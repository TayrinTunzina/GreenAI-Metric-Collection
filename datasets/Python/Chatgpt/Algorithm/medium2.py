def flippingMatrix(matrix):
    n = len(matrix) // 2  # Since the matrix is 2n x 2n
    max_sum = 0

    for i in range(n):
        for j in range(n):
            max_sum += max(
                matrix[i][j], 
                matrix[i][2*n - j - 1], 
                matrix[2*n - i - 1][j], 
                matrix[2*n - i - 1][2*n - j - 1]
            )
    
    return max_sum

# Input handling
q = int(input("Enter number of queries: "))
for _ in range(q):
    n = int(input("Enter value of n: "))
    matrix = [list(map(int, input().split())) for _ in range(2 * n)]
    print(flippingMatrix(matrix))
