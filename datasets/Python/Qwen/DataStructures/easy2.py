# Function to calculate the maximum hourglass sum
def max_hourglass_sum(arr):
    max_sum = float('-inf')  # Initialize with negative infinity
    for i in range(4):  # Rows: 0 to 3
        for j in range(4):  # Columns: 0 to 3
            # Calculate the hourglass sum
            top = arr[i][j] + arr[i][j+1] + arr[i][j+2]
            middle = arr[i+1][j+1]
            bottom = arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2]
            hourglass_sum = top + middle + bottom
            # Update max_sum if current hourglass_sum is greater
            max_sum = max(max_sum, hourglass_sum)
    return max_sum

# Input the 6x6 array manually
arr = []
print("Enter the 6x6 array row by row (space-separated integers):")
for _ in range(6):
    row = list(map(int, input().split()))
    arr.append(row)

# Calculate and print the maximum hourglass sum
result = max_hourglass_sum(arr)
print("Maximum Hourglass Sum:", result)