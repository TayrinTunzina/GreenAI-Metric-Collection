def diagonalDifference(arr, n):
    primary_diagonal = 0
    secondary_diagonal = 0
    
    for i in range(n):
        primary_diagonal += arr[i][i]
        secondary_diagonal += arr[i][n-1-i]
    
    return abs(primary_diagonal - secondary_diagonal)

# Taking input
n = int(input("Enter the size of square matrix: "))
arr = []
print("Enter the matrix elements row by row:")
for i in range(n):
    row = list(map(int, input().split()))
    arr.append(row)

result = diagonalDifference(arr, n)
print("Absolute diagonal difference:", result)