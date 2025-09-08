def hourglass_sum(arr):
    max_sum = float('-inf')

    for i in range(4):
        for j in range(4):
            current_sum = (arr[i][j] + arr[i][j+1] + arr[i][j+2] +
                          arr[i+1][j+1] +
                          arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2])
            if current_sum > max_sum:
                max_sum = current_sum

    return max_sum

# Manually input the 6x6 array
arr = []
print("Enter the elements of the 6x6 array:")
for _ in range(6):
    row = list(map(int, input().split()))
    arr.append(row)

print("The maximum hourglass sum is:", hourglass_sum(arr))
