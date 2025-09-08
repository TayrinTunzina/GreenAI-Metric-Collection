def diagonalDifference(arr):
    n = len(arr)
    
    # Initialize sums for the primary and secondary diagonals
    primary_diagonal_sum = 0
    secondary_diagonal_sum = 0
    
    # Calculate the sums of the diagonals
    for i in range(n):
        primary_diagonal_sum += arr[i][i]
        secondary_diagonal_sum += arr[i][n - i - 1]
    
    # Return the absolute difference between the two sums
    return abs(primary_diagonal_sum - secondary_diagonal_sum)

# Example usage:
n = int(input("Enter the number of rows/columns: "))
arr = []

for _ in range(n):
    arr.append(list(map(int, input().split())))

result = diagonalDifference(arr)
print(result)
