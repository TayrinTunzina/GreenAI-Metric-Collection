def maxHourglassSum(arr):
    max_sum = -float('inf')  # Initialize with negative infinity

    for i in range(4):  # Rows (0 to 3)
        for j in range(4):  # Columns (0 to 3)
            # Calculate the hourglass sum
            hourglass_sum = (
                arr[i][j] + arr[i][j + 1] + arr[i][j + 2] +  # Top row
                arr[i + 1][j + 1] +  # Middle element
                arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2]  # Bottom row
            )
            # Update max_sum if the current hourglass sum is greater
            if hourglass_sum > max_sum:
                max_sum = hourglass_sum

    return max_sum

# Input
arr = []
print("Enter the 6x6 array:")
for _ in range(6):
    row = list(map(int, input().split()))
    arr.append(row)

# Output
print("Maximum hourglass sum:", maxHourglassSum(arr))