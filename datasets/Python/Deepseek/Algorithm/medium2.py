def flippingMatrix(matrix):
    n = len(matrix) // 2
    max_sum = 0
    for i in range(n):
        for j in range(n):
            # Find the maximum value among the four symmetric positions
            max_val = max(matrix[i][j], matrix[i][2*n-1-j], matrix[2*n-1-i][j], matrix[2*n-1-i][2*n-1-j])
            max_sum += max_val
    return max_sum

# Example usage:
q = int(input("Enter the number of queries: "))
for _ in range(q):
    n = int(input("Enter the value of n: "))
    matrix = []
    for _ in range(2*n):
        row = list(map(int, input().split()))
        matrix.append(row)
    print("Maximum sum:", flippingMatrix(matrix))