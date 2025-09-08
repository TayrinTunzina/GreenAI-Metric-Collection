def matrixRotation(matrix, m, n, r):
    layers = min(m, n) // 2
    for layer in range(layers):
        perimeter = 2 * (m + n - 4 * layer - 2)
        rotations = r % perimeter
        for _ in range(rotations):
            # Top row: left to right
            top = layer
            left = layer
            right = n - layer - 1
            bottom = m - layer - 1
            
            # Save the top-left element
            temp = matrix[top][left]
            
            # Move top row (except first element) left
            for j in range(left, right):
                matrix[top][j] = matrix[top][j + 1]
            
            # Move right column (except first element) up
            for i in range(top, bottom):
                matrix[i][right] = matrix[i + 1][right]
            
            # Move bottom row (except last element) right
            for j in range(right, left, -1):
                matrix[bottom][j] = matrix[bottom][j - 1]
            
            # Move left column (except last element) down
            for i in range(bottom, top, -1):
                matrix[i][left] = matrix[i - 1][left]
            
            # Put the saved element back
            matrix[top + 1][left] = temp
    
    for row in matrix:
        print(' '.join(map(str, row)))

if __name__ == '__main__':
    import sys
    m, n, r = map(int, sys.stdin.readline().split())
    matrix = []
    for _ in range(m):
        matrix.append(list(map(int, sys.stdin.readline().split())))
    matrixRotation(matrix, m, n, r)