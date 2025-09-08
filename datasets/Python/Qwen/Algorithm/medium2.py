def flippingMatrix(matrix):
    n = len(matrix) // 2
    max_sum = 0

    # Iterate through each cell in the upper-left quadrant
    for i in range(n):
        for j in range(n):
            # Find the maximum value among the four possible positions
            max_val = max(
                matrix[i][j],               # Current position
                matrix[i][2 * n - j - 1],   # Column reverse
                matrix[2 * n - i - 1][j],   # Row reverse
                matrix[2 * n - i - 1][2 * n - j - 1]  # Both reversed
            )
            max_sum += max_val

    return max_sum


# Input handling
if __name__ == "__main__":
    q = int(input("Enter the number of queries: "))
    results = []

    for _ in range(q):
        n = int(input("Enter the value of n: "))
        matrix = []
        print(f"Enter the {2*n}x{2*n} matrix row by row:")
        for _ in range(2 * n):
            row = list(map(int, input().split()))
            matrix.append(row)

        result = flippingMatrix(matrix)
        results.append(result)

    print("\nResults:")
    for res in results:
        print(res)