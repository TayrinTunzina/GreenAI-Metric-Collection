def diagonalDifference(arr):

    n = len(arr)
    left_diagonal_sum = 0
    right_diagonal_sum = 0

    for i in range(n):
        left_diagonal_sum += arr[i][i]
        right_diagonal_sum += arr[i][n - i - 1]

    return abs(left_diagonal_sum - right_diagonal_sum)

if __name__ == "__main__":
    n = int(input("Enter the size of the square matrix: "))
    arr = []
    for i in range(n):
        row = list(map(int, input("Enter row {}: ".format(i + 1)).split()))
        arr.append(row)

    result = diagonalDifference(arr)
    print("The absolute difference between the diagonal sums is:", result)
