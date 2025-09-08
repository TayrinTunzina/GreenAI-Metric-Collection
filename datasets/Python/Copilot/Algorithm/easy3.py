def diagonalDifference(arr):
    primary_diagonal_sum = 0
    secondary_diagonal_sum = 0
    n = len(arr)

    for i in range(n):
        primary_diagonal_sum += arr[i][i]
        secondary_diagonal_sum += arr[i][n - 1 - i]
    
    return abs(primary_diagonal_sum - secondary_diagonal_sum)

# Taking input from the user
n = int(input("Enter the number of rows and columns: "))
arr = []
print("Enter the matrix elements row by row:")
for _ in range(n):
    arr.append(list(map(int, input().split())))

print(diagonalDifference(arr))
