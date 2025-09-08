def diagonal_difference():
    # Input size of the square matrix
    n = int(input("Enter the size of the square matrix (n): "))

    # Initialize the matrix
    arr = []

    # Input matrix elements
    print("Enter the elements of the matrix row by row:")
    for _ in range(n):
        row = list(map(int, input().split()))
        arr.append(row)

    # Calculate diagonal sums
    primary_diagonal_sum = sum(arr[i][i] for i in range(n))  # Primary diagonal: arr[i][i]
    secondary_diagonal_sum = sum(arr[i][n - 1 - i] for i in range(n))  # Secondary diagonal: arr[i][n-1-i]

    # Calculate absolute difference
    difference = abs(primary_diagonal_sum - secondary_diagonal_sum)

    # Output the result
    print("The absolute difference between the sums of the diagonals is:", difference)

# Call the function
diagonal_difference()