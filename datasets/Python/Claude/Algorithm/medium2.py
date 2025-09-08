def flippingMatrix(matrix):
    n = len(matrix) // 2
    total = 0
    
    # For each element in the upper left quadrant
    for i in range(n):
        for j in range(n):
            # Find max of all possible values that could be flipped to this position
            possible_values = [
                matrix[i][j],           # Current position
                matrix[i][2*n-1-j],     # Same row, reflected column
                matrix[2*n-1-i][j],     # Reflected row, same column
                matrix[2*n-1-i][2*n-1-j] # Reflected row and column
            ]
            total += max(possible_values)
    
    return total

# Manual input handling
def main():
    q = int(input())  # Number of queries
    for _ in range(q):
        n = int(input())  # Size of matrix quadrant
        matrix = []
        for _ in range(2*n):
            row = list(map(int, input().split()))
            matrix.append(row)
        result = flippingMatrix(matrix)
        print(result)

if __name__ == "__main__":
    main()