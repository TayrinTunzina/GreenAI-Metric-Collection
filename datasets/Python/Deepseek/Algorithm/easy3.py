def diagonalDifference(arr):
    n = len(arr)
    primary_sum = 0
    secondary_sum = 0

    for i in range(n):
        primary_sum += arr[i][i]  # Primary diagonal
        secondary_sum += arr[i][n - 1 - i]  # Secondary diagonal

    return abs(primary_sum - secondary_sum)

# Input
n = int(input("Enter the size of the matrix: "))
arr = []
for _ in range(n):
    row = list(map(int, input().split()))
    arr.append(row)

# Output
print("Absolute diagonal difference:", diagonalDifference(arr))