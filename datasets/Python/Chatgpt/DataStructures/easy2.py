def hourglass_sum(arr):
    max_sum = -float('inf')
    for i in range(4):
        for j in range(4):
            top = arr[i][j] + arr[i][j+1] + arr[i][j+2]
            mid = arr[i+1][j+1]
            bottom = arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2]
            hourglass = top + mid + bottom
            
            if hourglass > max_sum:
                max_sum = hourglass
                
    return max_sum

# Manually input the 6x6 array
arr = []
print("Enter the 6x6 array elements row by row:")
for _ in range(6):
    arr.append(list(map(int, input().rstrip().split())))

result = hourglass_sum(arr)
print(f"Maximum hourglass sum: {result}")