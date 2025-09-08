def diagonal_difference(arr):
    n = len(arr)
    primary_diagonal_sum = 0
    secondary_diagonal_sum = 0

    for i in range(n):
        primary_diagonal_sum += arr[i][i]
        secondary_diagonal_sum += arr[i][n - i - 1]

    return abs(primary_diagonal_sum - secondary_diagonal_sum)

# Taking input manually
n = int(input("Enter the size of the square matrix: "))
arr = []
print("Enter the elements of the matrix row by row:")
for _ in range(n):
    row = list(map(int, input().split()))
    arr.append(row)

result = diagonal_difference(arr)
print("The absolute difference between the sums of the diagonals is:", result)
