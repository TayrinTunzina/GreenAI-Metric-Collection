def hourglassSum(arr):

    max_sum = -63  # Minimum possible hourglass sum

    for i in range(4):
        for j in range(4):
            hourglass_sum = (
                arr[i][j] + arr[i][j + 1] + arr[i][j + 2] +
                arr[i + 1][j + 1] +
                arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2]
            )
            max_sum = max(max_sum, hourglass_sum)

    return max_sum

if __name__ == "__main__":
    arr = []
    for _ in range(6):
        row = list(map(int, input().rstrip().split()))
        arr.append(row)

    result = hourglassSum(arr)
    print(result)
